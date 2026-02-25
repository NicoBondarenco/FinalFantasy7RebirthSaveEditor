package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundleTitle(
    val mainStageWindowTitle: String = nullString(),
    val tabGeneralDataTitle: String = nullString(),
    val tabPartyDataTitle: String = nullString(),
)
