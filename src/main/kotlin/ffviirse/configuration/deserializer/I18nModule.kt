package ffviirse.configuration.deserializer

import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale
import tools.jackson.databind.module.SimpleModule

class I18nModule : SimpleModule("I18nModule") {

    init {
        addDeserializer(ZoneOffset::class.java, OffsetBundleDeserializer())
        addDeserializer(DateTimeFormatter::class.java, FormatterBundleDeserializer())
        addDeserializer(Locale::class.java, LocaleBundleDeserializer())
    }

}
