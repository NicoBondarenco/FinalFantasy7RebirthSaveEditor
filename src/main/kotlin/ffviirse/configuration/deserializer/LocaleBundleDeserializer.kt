package ffviirse.configuration.deserializer

import java.util.Locale
import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.deser.std.StdDeserializer

class LocaleBundleDeserializer : StdDeserializer<Locale>(Locale::class.java) {

    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): Locale = p.valueAsString?.let {
        Locale.forLanguageTag(it)
    } ?: Locale.getDefault()

}
