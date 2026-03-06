package ffviirse.domain.i18n

import ffviirse.domain.extension.nullString

data class I18nBundlePartyItemType(
    val allTypeLabel: String = nullString(),
    val itemCommonLabel: String = nullString(),
    val transmmuterMaterialLabel: String = nullString(),
    val keyItemsLabel: String = nullString(),
    val memberWeaponLabel: String = nullString(),
    val memberArmorLabel: String = nullString(),
    val memberAccessoryLabel: String = nullString(),
    val materiaItemLabel: String = nullString(),
    val tradingTokenLabel: String = nullString(),
    val memberOutfitLabel: String = nullString(),
    val transmuterChipLabel: String = nullString(),
    val folioManuscriptLabel: String = nullString(),
    val chocoboGearLabel: String = nullString(),
    val qbCardLabel: String = nullString(),
    val treasureTroveLabel: String = nullString(),
)
