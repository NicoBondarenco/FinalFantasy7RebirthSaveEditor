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
    val bundleMainApplication: I18nBundleMainApplication = I18nBundleMainApplication(),
    val bundleTopBar: I18nBundleTopBar = I18nBundleTopBar(),
    val bundleContentPane: I18nBundleContentPane = I18nBundleContentPane(),
    val bundleGeneralTab: I18nBundleGeneralTab = I18nBundleGeneralTab(),
) : Labeled {
    override val label: String = displayName
}
