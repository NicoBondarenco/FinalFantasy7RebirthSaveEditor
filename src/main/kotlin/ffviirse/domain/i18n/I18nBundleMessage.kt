package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

data class I18nBundleMessage(
    val exceptionGenericErrorMessage: StringProperty = SimpleStringProperty(nullString()),
    val validationGenericErrorMessage: StringProperty = SimpleStringProperty(nullString()),
)
