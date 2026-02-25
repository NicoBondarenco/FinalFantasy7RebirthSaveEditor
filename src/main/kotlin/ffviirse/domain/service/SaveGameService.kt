package ffviirse.domain.service

import ffviirse.domain.context.application.ExternalProperties
import ffviirse.domain.context.session.SessionContext.changeCurrentSave
import ffviirse.domain.context.session.SessionContext.currentSave
import ffviirse.domain.extension.format
import ffviirse.domain.model.entity.GeneralData
import ffviirse.domain.model.entity.SaveGameData
import ffviirse.domain.model.response.SaveGameFile
import java.io.File
import java.io.FileFilter
import java.nio.ByteBuffer
import java.nio.ByteOrder.LITTLE_ENDIAN
import java.time.Duration
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class SaveGameService(
    private val externalProperties: ExternalProperties
) {

    companion object {
        private val FILE_NAME_REGEX = "ff7rebirth([0-9]+)".toRegex()
    }

    fun savedGames(): Set<SaveGameFile> = File(
        externalProperties.saveDirectory
    ).listFiles(FileFilter {
        it.isFile && FILE_NAME_REGEX.matches(it.nameWithoutExtension) && it.extension == "sav"
    })?.map { SaveGameFile(it) }?.toSet() ?: emptySet()

    fun selectSaveGame(saveGame: SaveGameFile) {
        if (!saveGame.saveFile.isValidSave()) {
            changeCurrentSave(SaveGameData())
            println("Saved game data: $currentSave")
            println("Formatted play time: ${currentSave.generalData.playTime.format(3)}")
            return
        }
        val bytes = saveGame.saveFile.readBytes()
        val buffer = ByteBuffer.wrap(bytes).order(LITTLE_ENDIAN)

        val totalSeconds = buffer.getLong(0x3C30) and 0xFFFFFFFFL
        val duration = Duration.ofSeconds(totalSeconds)

        val tableBaseOffset = 0x4FA70
        val entrySize = 0x20
        var gil = 0

        for (i in 0 until 0x800) {
            val currentOffset = tableBaseOffset + (i * entrySize)
            if (currentOffset + 8 > bytes.size) break

            val id = buffer.getInt(currentOffset)
            if (id == 1) {
                gil = buffer.getInt(currentOffset + 4)
                break
            }
        }

        val saveData = SaveGameData(
            saveFile = saveGame.saveFile,
            generalData = GeneralData(
                playTime = duration,
                playHours = duration.toHours(),
                playMinutes = duration.toMinutes(),
                playSeconds = duration.toSeconds(),
                totalGil = gil,
            ),
        )

        changeCurrentSave(saveData)

        println("Saved game data: $currentSave")
        println("Formatted play time: ${currentSave.generalData.playTime.format(3)}")

    }

    private fun File.isValidSave(): Boolean = this.exists() &&
        this.length() > 0 &&
        this.isFile &&
        FILE_NAME_REGEX.matches(this.nameWithoutExtension) &&
        this.extension == "sav"

}
