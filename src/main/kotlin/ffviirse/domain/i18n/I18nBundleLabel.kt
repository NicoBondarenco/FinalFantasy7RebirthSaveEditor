package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundleLabel(
    val appCheckboxDefaultLabel: String = nullString(),
    val mainTopSavesLabel: String = nullString(),
    val mainTopLanguagesLabel: String = nullString(),
)
