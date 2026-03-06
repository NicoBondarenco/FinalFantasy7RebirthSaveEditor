package ffviirse.domain.model.value

import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.functional.Labeled
import ffviirse.domain.model.mapper.aerithFloralDelightBit
import ffviirse.domain.model.mapper.aerithFloralDelightOffset
import ffviirse.domain.model.mapper.aerithIndependentFloristBit
import ffviirse.domain.model.mapper.aerithIndependentFloristOffset
import ffviirse.domain.model.mapper.aerithMidgarHelmetBit
import ffviirse.domain.model.mapper.aerithMidgarHelmetOffset
import ffviirse.domain.model.mapper.aerithMidgarInfantryBit
import ffviirse.domain.model.mapper.aerithMidgarInfantryOffset
import ffviirse.domain.model.mapper.aerithPinkMermaidBit
import ffviirse.domain.model.mapper.aerithPinkMermaidOffset
import ffviirse.domain.model.mapper.barretAvalancheLeaderBit
import ffviirse.domain.model.mapper.barretAvalancheLeaderOffset
import ffviirse.domain.model.mapper.barretBlackDenimBit
import ffviirse.domain.model.mapper.barretBlackDenimOffset
import ffviirse.domain.model.mapper.barretBlackInjuredBit
import ffviirse.domain.model.mapper.barretBlackInjuredOffset
import ffviirse.domain.model.mapper.barretJunonNavalBit
import ffviirse.domain.model.mapper.barretJunonNavalOffset
import ffviirse.domain.model.mapper.caitCourtJesterBit
import ffviirse.domain.model.mapper.caitCourtJesterOffset
import ffviirse.domain.model.mapper.caitFortuneTellerBit
import ffviirse.domain.model.mapper.caitFortuneTellerOffset
import ffviirse.domain.model.mapper.cloudAlphreidOutfitBit
import ffviirse.domain.model.mapper.cloudAlphreidOutfitOffset
import ffviirse.domain.model.mapper.cloudExSoldierBit
import ffviirse.domain.model.mapper.cloudExSoldierOffset
import ffviirse.domain.model.mapper.cloudMidgarCaptainBit
import ffviirse.domain.model.mapper.cloudMidgarCaptainOffset
import ffviirse.domain.model.mapper.cloudMidgarHelmetBit
import ffviirse.domain.model.mapper.cloudMidgarHelmetOffset
import ffviirse.domain.model.mapper.cloudMidgarInfantryBit
import ffviirse.domain.model.mapper.cloudMidgarInfantryOffset
import ffviirse.domain.model.mapper.cloudOceanChocoboBit
import ffviirse.domain.model.mapper.cloudOceanChocoboOffset
import ffviirse.domain.model.mapper.cloudWildSurfBit
import ffviirse.domain.model.mapper.cloudWildSurfOffset
import ffviirse.domain.model.mapper.redxiiiHellhoundOutfitBit
import ffviirse.domain.model.mapper.redxiiiHellhoundOutfitOffset
import ffviirse.domain.model.mapper.redxiiiLaboratoryEscapeeBit
import ffviirse.domain.model.mapper.redxiiiLaboratoryEscapeeOffset
import ffviirse.domain.model.mapper.redxiiiMidgarInfantryBit
import ffviirse.domain.model.mapper.redxiiiMidgarInfantryOffset
import ffviirse.domain.model.mapper.tifaMajesticGlamourBit
import ffviirse.domain.model.mapper.tifaMajesticGlamourOffset
import ffviirse.domain.model.mapper.tifaMidgarHelmetBit
import ffviirse.domain.model.mapper.tifaMidgarHelmetOffset
import ffviirse.domain.model.mapper.tifaMidgarInfantryBit
import ffviirse.domain.model.mapper.tifaMidgarInfantryOffset
import ffviirse.domain.model.mapper.tifaSeventhHeavenBit
import ffviirse.domain.model.mapper.tifaSeventhHeavenOffset
import ffviirse.domain.model.mapper.tifaShiningSpiritBit
import ffviirse.domain.model.mapper.tifaShiningSpiritOffset
import ffviirse.domain.model.mapper.tifaWithoutGlovesBit
import ffviirse.domain.model.mapper.tifaWithoutGlovesOffset
import ffviirse.domain.model.mapper.yuffieMateriaHunterBit
import ffviirse.domain.model.mapper.yuffieMateriaHunterOffset
import ffviirse.domain.model.mapper.yuffieMoogleCapeBit
import ffviirse.domain.model.mapper.yuffieMoogleCapeOffset
import ffviirse.domain.model.mapper.yuffieSummerOrangeBit
import ffviirse.domain.model.mapper.yuffieSummerOrangeOffset
import ffviirse.domain.model.mapper.yuffieWutaiStarBit
import ffviirse.domain.model.mapper.yuffieWutaiStarOffset
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI

enum class MemberOutfit(
    val partyMember: PartyMember,
    val defaultOutfit: Boolean,
    val fileValue: Int,
    val fileBit: Int,
    val outfitName: () -> String
) : Labeled {
    CLOUD_EX_SOLDIER(CLOUD_STRIFE, true, cloudExSoldierOffset, cloudExSoldierBit, { bundleGeneralTab.cloudExSoldierLabel }),
    CLOUD_OCEAN_CHOCOBO(CLOUD_STRIFE, false, cloudOceanChocoboOffset, cloudOceanChocoboBit, { bundleGeneralTab.cloudOceanChocoboLabel }),
    CLOUD_WILD_SURF(CLOUD_STRIFE, false, cloudWildSurfOffset, cloudWildSurfBit, { bundleGeneralTab.cloudWildSurfLabel }),
    CLOUD_MIDGAR_INFANTRY(CLOUD_STRIFE, false, cloudMidgarInfantryOffset, cloudMidgarInfantryBit, { bundleGeneralTab.cloudMidgarInfantryLabel }),
    CLOUD_MIDGAR_HELMET(CLOUD_STRIFE, false, cloudMidgarHelmetOffset, cloudMidgarHelmetBit, { bundleGeneralTab.cloudMidgarHelmetLabel }),
    CLOUD_MIDGAR_CAPTAIN(CLOUD_STRIFE, false, cloudMidgarCaptainOffset, cloudMidgarCaptainBit, { bundleGeneralTab.cloudMidgarCaptainLabel }),
    CLOUD_ALPHREID_OUTFIT(CLOUD_STRIFE, false, cloudAlphreidOutfitOffset, cloudAlphreidOutfitBit, { bundleGeneralTab.cloudAlphreidOutfitLabel }),

    TIFA_SEVENTH_HEAVEN(TIFA_LOCKHART, true, tifaSeventhHeavenOffset, tifaSeventhHeavenBit, { bundleGeneralTab.tifaSeventhHeavenLabel }),
    TIFA_MAJESTIC_GLAMOUR(TIFA_LOCKHART, false, tifaMajesticGlamourOffset, tifaMajesticGlamourBit, { bundleGeneralTab.tifaMajesticGlamourLabel }),
    TIFA_SHINING_SPIRIT(TIFA_LOCKHART, false, tifaShiningSpiritOffset, tifaShiningSpiritBit, { bundleGeneralTab.tifaShiningSpiritLabel }),
    TIFA_MIDGAR_INFANTRY(TIFA_LOCKHART, false, tifaMidgarInfantryOffset, tifaMidgarInfantryBit, { bundleGeneralTab.tifaMidgarInfantryLabel }),
    TIFA_MIDGAR_HELMET(TIFA_LOCKHART, false, tifaMidgarHelmetOffset, tifaMidgarHelmetBit, { bundleGeneralTab.tifaMidgarHelmetLabel }),
    TIFA_WITHOUT_GLOVES(TIFA_LOCKHART, false, tifaWithoutGlovesOffset, tifaWithoutGlovesBit, { bundleGeneralTab.tifaWithoutGlovesLabel }),

    BARRET_AVALANCHE_LEADER(BARRET_WALLACE, true, barretAvalancheLeaderOffset, barretAvalancheLeaderBit, { bundleGeneralTab.barretAvalancheLeaderLabel }),
    BARRET_JUNON_NAVAL(BARRET_WALLACE, false, barretJunonNavalOffset, barretJunonNavalBit, { bundleGeneralTab.barretJunonNavalLabel }),
    BARRET_BLACK_DENIM(BARRET_WALLACE, false, barretBlackDenimOffset, barretBlackDenimBit, { bundleGeneralTab.barretBlackDenimLabel }),
    BARRET_BLACK_INJURED(BARRET_WALLACE, false, barretBlackInjuredOffset, barretBlackInjuredBit, { bundleGeneralTab.barretBlackInjuredLabel }),

    AERITH_INDEPENDENT_FLORIST(AERITH_GAINSBOROUGH, true, aerithIndependentFloristOffset, aerithIndependentFloristBit, { bundleGeneralTab.aerithIndependentFloristLabel }),
    AERITH_FLORAL_DELIGHT(AERITH_GAINSBOROUGH, false, aerithFloralDelightOffset, aerithFloralDelightBit, { bundleGeneralTab.aerithFloralDelightLabel }),
    AERITH_PINK_MERMAID(AERITH_GAINSBOROUGH, false, aerithPinkMermaidOffset, aerithPinkMermaidBit, { bundleGeneralTab.aerithPinkMermaidLabel }),
    AERITH_MIDGAR_INFANTRY(AERITH_GAINSBOROUGH, false, aerithMidgarInfantryOffset, aerithMidgarInfantryBit, { bundleGeneralTab.aerithMidgarInfantryLabel }),
    AERITH_MIDGAR_HELMET(AERITH_GAINSBOROUGH, false, aerithMidgarHelmetOffset, aerithMidgarHelmetBit, { bundleGeneralTab.aerithMidgarHelmetLabel }),

    REDXIII_LABORATORY_ESCAPEE(RED_XIII, true, redxiiiLaboratoryEscapeeOffset, redxiiiLaboratoryEscapeeBit, { bundleGeneralTab.redxiiiLaboratoryEscapeeLabel }),
    REDXIII_HELLHOUND_OUTFIT(RED_XIII, false, redxiiiHellhoundOutfitOffset, redxiiiHellhoundOutfitBit, { bundleGeneralTab.redxiiiHellhoundOutfitLabel }),
    REDXIII_MIDGAR_INFANTRY(RED_XIII, false, redxiiiMidgarInfantryOffset, redxiiiMidgarInfantryBit, { bundleGeneralTab.redxiiiMidgarInfantryLabel }),

    YUFFIE_MATERIA_HUNTER(YUFFIE_KISARAGI, true, yuffieMateriaHunterOffset, yuffieMateriaHunterBit, { bundleGeneralTab.yuffieMateriaHunterLabel }),
    YUFFIE_SUMMER_ORANGE(YUFFIE_KISARAGI, false, yuffieSummerOrangeOffset, yuffieSummerOrangeBit, { bundleGeneralTab.yuffieSummerOrangeLabel }),
    YUFFIE_MOOGLE_CAPE(YUFFIE_KISARAGI, false, yuffieMoogleCapeOffset, yuffieMoogleCapeBit, { bundleGeneralTab.yuffieMoogleCapeLabel }),
    YUFFIE_WUTAI_STAR(YUFFIE_KISARAGI, false, yuffieWutaiStarOffset, yuffieWutaiStarBit, { bundleGeneralTab.yuffieWutaiStarLabel }),

    CAIT_FORTUNE_TELLER(CAIT_SITH, true, caitFortuneTellerOffset, caitFortuneTellerBit, { bundleGeneralTab.caitFortuneTellerLabel }),
    CAIT_COURT_JESTER(CAIT_SITH, false, caitCourtJesterOffset, caitCourtJesterBit, { bundleGeneralTab.caitCourtJesterLabel }),

    ;

    override val label: String
        get() = outfitName()

}
