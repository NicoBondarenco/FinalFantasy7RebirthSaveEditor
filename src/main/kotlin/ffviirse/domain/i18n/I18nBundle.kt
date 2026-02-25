package ffviirse.domain.i18n

import ffviirse.domain.attribute.property.IntProperty
import ffviirse.domain.attribute.property.simple.SimpleIntProperty
import ffviirse.domain.attribute.property.simple.SimpleProperty
import ffviirse.domain.extension.nullString
import java.time.ZoneOffset
import java.time.ZoneOffset.UTC
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
import java.time.format.DateTimeFormatter.ISO_LOCAL_TIME
import java.util.Locale
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

data class I18nBundle(
    val displayOrder: IntProperty = SimpleIntProperty(-1),
    val languageTag: StringProperty = SimpleStringProperty(nullString()),
    val languageName: StringProperty = SimpleStringProperty(nullString()),
    val languageLocale: SimpleObjectProperty<Locale> = SimpleObjectProperty(Locale.getDefault()),
    val displayName: StringProperty = SimpleStringProperty(nullString()),
    val dateFormat: SimpleObjectProperty<DateTimeFormatter> = SimpleObjectProperty(ISO_LOCAL_DATE),
    val timeFormat: SimpleObjectProperty<DateTimeFormatter> = SimpleObjectProperty(ISO_LOCAL_TIME),
    val datetimeFormat: SimpleObjectProperty<DateTimeFormatter> = SimpleObjectProperty(ISO_LOCAL_DATE_TIME),
    val zoneOffset: SimpleObjectProperty<ZoneOffset> = SimpleObjectProperty(UTC),
    val bundleLabel: SimpleObjectProperty<I18nBundleLabel> = SimpleObjectProperty(I18nBundleLabel()),
    val bundleTitle: SimpleObjectProperty<I18nBundleTitle> = SimpleObjectProperty(I18nBundleTitle()),
    val bundleMessage: SimpleObjectProperty<I18nBundleMessage> = SimpleObjectProperty(I18nBundleMessage()),
)
