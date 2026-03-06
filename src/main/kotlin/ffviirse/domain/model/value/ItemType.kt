package ffviirse.domain.model.value

import ffviirse.domain.context.session.SessionContext.bundlePartyTab
import ffviirse.domain.functional.Labeled
import ffviirse.domain.model.mapper.allTypeOffset
import ffviirse.domain.model.mapper.chocoboGearOffset
import ffviirse.domain.model.mapper.folioManuscriptOffset
import ffviirse.domain.model.mapper.itemCommonOffset
import ffviirse.domain.model.mapper.keyItemsOffset
import ffviirse.domain.model.mapper.materiaItemOffset
import ffviirse.domain.model.mapper.memberAccessoryOffset
import ffviirse.domain.model.mapper.memberArmorOffset
import ffviirse.domain.model.mapper.memberOutfitOffset
import ffviirse.domain.model.mapper.memberWeaponOffset
import ffviirse.domain.model.mapper.qbCardOffset
import ffviirse.domain.model.mapper.tradingTokenOffset
import ffviirse.domain.model.mapper.transmmuterMaterialOffset
import ffviirse.domain.model.mapper.transmuterChipOffset
import ffviirse.domain.model.mapper.treasureTroveOffset

enum class ItemType(
    val fileValue: Int,
    val typeName: () -> String,
) : Labeled {

    ALL_TYPE(allTypeOffset, { bundlePartyTab.partyItemTypeLabels.allTypeLabel }),
    ITEM_COMMON(itemCommonOffset, { bundlePartyTab.partyItemTypeLabels.itemCommonLabel }),
    TRANSMMUTER_MATERIAL(transmmuterMaterialOffset, { bundlePartyTab.partyItemTypeLabels.transmmuterMaterialLabel }),
    KEY_ITEMS(keyItemsOffset, { bundlePartyTab.partyItemTypeLabels.keyItemsLabel }),
    MEMBER_WEAPON(memberWeaponOffset, { bundlePartyTab.partyItemTypeLabels.memberWeaponLabel }),
    MEMBER_ARMOR(memberArmorOffset, { bundlePartyTab.partyItemTypeLabels.memberArmorLabel }),
    MEMBER_ACCESSORY(memberAccessoryOffset, { bundlePartyTab.partyItemTypeLabels.memberAccessoryLabel }),
    MATERIA_ITEM(materiaItemOffset, { bundlePartyTab.partyItemTypeLabels.materiaItemLabel }),
    TRADING_TOKEN(tradingTokenOffset, { bundlePartyTab.partyItemTypeLabels.tradingTokenLabel }),
    MEMBER_OUTFIT(memberOutfitOffset, { bundlePartyTab.partyItemTypeLabels.memberOutfitLabel }),
    TRANSMUTER_CHIP(transmuterChipOffset, { bundlePartyTab.partyItemTypeLabels.transmuterChipLabel }),
    FOLIO_MANUSCRIPT(folioManuscriptOffset, { bundlePartyTab.partyItemTypeLabels.folioManuscriptLabel }),
    CHOCOBO_GEAR(chocoboGearOffset, { bundlePartyTab.partyItemTypeLabels.chocoboGearLabel }),
    QB_CARD(qbCardOffset, { bundlePartyTab.partyItemTypeLabels.qbCardLabel }),
    TREASURE_TROVE(treasureTroveOffset, { bundlePartyTab.partyItemTypeLabels.treasureTroveLabel });

    override val label: String
        get() = this.typeName()
}
