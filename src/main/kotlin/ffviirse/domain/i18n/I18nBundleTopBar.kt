package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundleTopBar(
    val mainTopSavesLabel: String = nullString(),
    val mainTopLanguagesLabel: String = nullString(),
)
