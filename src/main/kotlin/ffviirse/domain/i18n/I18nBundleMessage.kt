package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundleMessage(
    val exceptionGenericErrorMessage: String = nullString(),
    val validationGenericErrorMessage: String = nullString(),
)
