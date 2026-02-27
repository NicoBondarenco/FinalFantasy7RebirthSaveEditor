package ffviirse.configuration.serializer

import ffviirse.domain.extension.nullString
import java.io.File
import tools.jackson.core.JsonGenerator
import tools.jackson.databind.SerializationContext
import tools.jackson.databind.ser.std.StdSerializer

class FileSerializer : StdSerializer<File>(File::class.java) {
    override fun serialize(value: File?, gen: JsonGenerator, provider: SerializationContext) {
        gen.writeString(value?.absolutePath ?: nullString())
    }
}
