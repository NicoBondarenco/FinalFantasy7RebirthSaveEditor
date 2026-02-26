package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundleContentPane(
    val tabGeneralDataTitle: String = nullString(),
    val tabPartyDataTitle: String = nullString(),
)
