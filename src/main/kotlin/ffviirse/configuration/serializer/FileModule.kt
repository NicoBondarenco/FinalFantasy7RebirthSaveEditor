package ffviirse.configuration.serializer

import java.io.File
import tools.jackson.databind.module.SimpleModule

class FileModule : SimpleModule("I18nModule") {

    init {
        addSerializer(File::class.java, FileSerializer())
    }

}
