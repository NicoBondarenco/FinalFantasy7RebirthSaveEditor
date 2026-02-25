package ffviirse.domain.model.mapper

import ffviirse.domain.model.entity.SaveGame
import ffviirse.domain.model.response.SaveGameFile
import java.nio.ByteBuffer
import java.nio.ByteOrder.LITTLE_ENDIAN

fun SaveGameFile.toSaveGameData(): SaveGame {
    val bytes = this.saveFile.readBytes()
    val buffer = ByteBuffer.wrap(bytes).order(LITTLE_ENDIAN)

    return SaveGame(
        saveFile = this.saveFile,
        generalData = buffer.generalData(bytes),
    )
}
