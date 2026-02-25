package ffviirse.configuration.deserializer

import ffviirse.domain.extension.parseOrNull
import java.time.Instant
import java.time.ZoneOffset
import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.deser.std.StdDeserializer

class OffsetBundleDeserializer : StdDeserializer<ZoneOffset>(ZoneOffset::class.java) {

    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): ZoneOffset = p.valueAsString?.takeIf {
        it.trim().isNotEmpty()
    }?.let { value ->
        value.parseOrNull { ZoneOffset.of(it) }
    } ?: ZoneOffset.systemDefault().rules.getOffset(Instant.now())

}
