package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

data class I18nBundleLabel(
    val appCheckboxDefaultLabel: StringProperty = SimpleStringProperty(nullString()),
    val mainTopSavesLabel: StringProperty = SimpleStringProperty(nullString()),
)
