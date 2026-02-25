package ffviirse.domain.service

import ffviirse.domain.context.application.ExternalProperties
import ffviirse.domain.context.session.SessionContext.changeCurrentSave
import ffviirse.domain.model.entity.SaveGame
import ffviirse.domain.model.mapper.generalData
import ffviirse.domain.model.response.SaveGameFile
import java.io.File
import java.io.FileFilter
import java.nio.ByteBuffer
import java.nio.ByteOrder.LITTLE_ENDIAN
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
            changeCurrentSave(SaveGame())
            return
        }
        val bytes = saveGame.saveFile.readBytes()
        val buffer = ByteBuffer.wrap(bytes).order(LITTLE_ENDIAN)

        val saveData = SaveGame(
            saveFile = saveGame.saveFile,
            generalData = buffer.generalData(bytes),
        )

        changeCurrentSave(saveData)
    }

    private fun File.isValidSave(): Boolean = this.exists() &&
        this.length() > 0 &&
        this.isFile &&
        FILE_NAME_REGEX.matches(this.nameWithoutExtension) &&
        this.extension == "sav"

}
