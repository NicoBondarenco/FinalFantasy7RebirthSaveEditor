package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString
import ffviirse.domain.functional.Labeled
import java.time.ZoneOffset
import java.time.ZoneOffset.UTC
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
import java.time.format.DateTimeFormatter.ISO_LOCAL_TIME
import java.util.Locale

data class I18nBundle(
    val displayOrder: Int = -1,
    val languageTag: String = nullString(),
    val languageName: String = nullString(),
    val languageLocale: Locale = Locale.getDefault(),
    val displayName: String = nullString(),
    val dateFormat: DateTimeFormatter = ISO_LOCAL_DATE,
    val timeFormat: DateTimeFormatter = ISO_LOCAL_TIME,
    val datetimeFormat: DateTimeFormatter = ISO_LOCAL_DATE_TIME,
    val zoneOffset: ZoneOffset = UTC,
    val bundleLabel: I18nBundleLabel = I18nBundleLabel(),
    val bundleTitle: I18nBundleTitle = I18nBundleTitle(),
    val bundleMessage: I18nBundleMessage = I18nBundleMessage(),
): Labeled {
    override val label: String = displayName
}
