package ffviirse.configuration.deserializer

import ffviirse.domain.extension.parseOrNull
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_DATE
import java.time.format.DateTimeFormatter.ISO_DATE_TIME
import java.time.format.DateTimeFormatter.ISO_TIME
import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.deser.std.StdDeserializer

class FormatterBundleDeserializer : StdDeserializer<DateTimeFormatter>(DateTimeFormatter::class.java) {

    companion object {
        private val PARAMETER_DEFAULT = mapOf(
            "dateFormat" to ISO_DATE,
            "timeFormat" to ISO_TIME,
            "datetimeFormat" to ISO_DATE_TIME,
        )
    }

    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): DateTimeFormatter = p.valueAsString?.takeIf {
        it.trim().isNotEmpty()
    }?.let { value ->
        value.parseOrNull { DateTimeFormatter.ofPattern(it) }
    } ?: PARAMETER_DEFAULT.getOrDefault(p.currentName(), ISO_DATE_TIME)

}
