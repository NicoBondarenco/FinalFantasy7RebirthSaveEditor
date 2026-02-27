package ffviirse.domain.model.value

import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.functional.Labeled
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
    CLOUD_EX_SOLDIER(CLOUD_STRIFE, true, 0, 0, { bundleGeneralTab.cloudExSoldierLabel }),
    CLOUD_OCEAN_CHOCOBO(CLOUD_STRIFE, false, 0x44D2E, 1, { bundleGeneralTab.cloudOceanChocoboLabel }),
    CLOUD_WILD_SURF(CLOUD_STRIFE, false, 0x44D2E, 2, { bundleGeneralTab.cloudWildSurfLabel }),
    CLOUD_MIDGAR_INFANTRY(CLOUD_STRIFE, false, 0x44D30, 1, { bundleGeneralTab.cloudMidgarInfantryLabel }),
    CLOUD_MIDGAR_HELMET(CLOUD_STRIFE, false, 0x44D2E, 3, { bundleGeneralTab.cloudMidgarHelmetLabel }),
    CLOUD_MIDGAR_CAPTAIN(CLOUD_STRIFE, false, 0x44D2E, 4, { bundleGeneralTab.cloudMidgarCaptainLabel }),
    CLOUD_ALPHREID_OUTFIT(CLOUD_STRIFE, false, 0x44D35, 5, { bundleGeneralTab.cloudAlphreidOutfitLabel }),

    TIFA_SEVENTH_HEAVEN(TIFA_LOCKHART, true, 0, 0, { bundleGeneralTab.tifaSeventhHeavenLabel }),
    TIFA_MAJESTIC_GLAMOUR(TIFA_LOCKHART, false, 0x44D2E, 5, { bundleGeneralTab.tifaMajesticGlamourLabel }),
    TIFA_SHINING_SPIRIT(TIFA_LOCKHART, false, 0x44D2E, 6, { bundleGeneralTab.tifaShiningSpiritLabel }),
    TIFA_MIDGAR_INFANTRY(TIFA_LOCKHART, false, 0x44D30, 2, { bundleGeneralTab.tifaMidgarInfantryLabel }),
    TIFA_MIDGAR_HELMET(TIFA_LOCKHART, false, 0x44D2E, 7, { bundleGeneralTab.tifaMidgarHelmetLabel }),
    TIFA_WITHOUT_GLOVES(TIFA_LOCKHART, false, 0x44D37, 7, { bundleGeneralTab.tifaWithoutGlovesLabel }),

    BARRET_AVALANCHE_LEADER(BARRET_WALLACE, true, 0, 0, { bundleGeneralTab.barretAvalancheLeaderLabel }),
    BARRET_JUNON_NAVAL(BARRET_WALLACE, false, 0x44D2F, 7, { bundleGeneralTab.barretJunonNavalLabel }),
    BARRET_BLACK_DENIM(BARRET_WALLACE, false, 0x44D30, 6, { bundleGeneralTab.barretBlackDenimLabel }),
    BARRET_BLACK_INJURED(BARRET_WALLACE, false, 0x44D30, 7, { bundleGeneralTab.barretBlackInjuredLabel }),

    AERITH_INDEPENDENT_FLORIST(AERITH_GAINSBOROUGH, true, 0, 0, { bundleGeneralTab.aerithIndependentFloristLabel }),
    AERITH_FLORAL_DELIGHT(AERITH_GAINSBOROUGH, false, 0x44D2F, 0, { bundleGeneralTab.aerithFloralDelightLabel }),
    AERITH_PINK_MERMAID(AERITH_GAINSBOROUGH, false, 0x44D2F, 1, { bundleGeneralTab.aerithPinkMermaidLabel }),
    AERITH_MIDGAR_INFANTRY(AERITH_GAINSBOROUGH, false, 0x44D30, 3, { bundleGeneralTab.aerithMidgarInfantryLabel }),
    AERITH_MIDGAR_HELMET(AERITH_GAINSBOROUGH, false, 0x44D2F, 2, { bundleGeneralTab.aerithMidgarHelmetLabel }),

    REDXIII_LABORATORY_ESCAPEE(RED_XIII, true, 0, 0, { bundleGeneralTab.redxiiiLaboratoryEscapeeLabel }),
    REDXIII_HELLHOUND_OUTFIT(RED_XIII, false, 0x44D33, 3, { bundleGeneralTab.redxiiiHellhoundOutfitLabel }),
    REDXIII_MIDGAR_INFANTRY(RED_XIII, false, 0x44D33, 5, { bundleGeneralTab.redxiiiMidgarInfantryLabel }),

    YUFFIE_MATERIA_HUNTER(YUFFIE_KISARAGI, true, 0, 0, { bundleGeneralTab.yuffieMateriaHunterLabel }),
    YUFFIE_SUMMER_ORANGE(YUFFIE_KISARAGI, false, 0x44D30, 4, { bundleGeneralTab.yuffieSummerOrangeLabel }),
    YUFFIE_MOOGLE_CAPE(YUFFIE_KISARAGI, false, 0x44D30, 5, { bundleGeneralTab.yuffieMoogleCapeLabel }),
    YUFFIE_WUTAI_STAR(YUFFIE_KISARAGI, false, 0x44D37, 5, { bundleGeneralTab.yuffieWutaiStarLabel }),

    CAIT_FORTUNE_TELLER(CAIT_SITH, true, 0, 0, { bundleGeneralTab.caitFortuneTellerLabel }),
    CAIT_COURT_JESTER(CAIT_SITH, false, 0x44D33, 4, { bundleGeneralTab.caitCourtJesterLabel }),

    ;

    override val label: String
        get() = outfitName()

}
