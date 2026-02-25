package ffviirse.domain.service

import ffviirse.domain.context.application.ExternalProperties
import ffviirse.domain.model.response.SaveGameFile
import java.io.File
import java.io.FileFilter
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

}
