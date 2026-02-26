package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundleMainApplication(
    val mainStageWindowTitle: String = nullString(),
    val appCheckboxDefaultLabel: String = nullString(),
    val exceptionGenericErrorMessage: String = nullString(),
    val validationGenericErrorMessage: String = nullString(),
)
