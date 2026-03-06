package ffviirse.domain.model.value

import ffviirse.domain.context.session.SessionContext.bundlePartyTab
import ffviirse.domain.functional.Labeled
import ffviirse.domain.model.mapper.amethystCollarOffset
import ffviirse.domain.model.mapper.barrageBlasterOffset
import ffviirse.domain.model.mapper.battleCryOffset
import ffviirse.domain.model.mapper.birdPreyOffset
import ffviirse.domain.model.mapper.brisingamenWeaponOffset
import ffviirse.domain.model.mapper.busterSwordOffset
import ffviirse.domain.model.mapper.busterZackOffset
import ffviirse.domain.model.mapper.calamitousBazookaOffset
import ffviirse.domain.model.mapper.ceremonialStaffOffset
import ffviirse.domain.model.mapper.crescentSickleOffset
import ffviirse.domain.model.mapper.crystalGlovesOffset
import ffviirse.domain.model.mapper.crystalMegaphoneOffset
import ffviirse.domain.model.mapper.crystalSwordOffset
import ffviirse.domain.model.mapper.crystallineCrossOffset
import ffviirse.domain.model.mapper.dragonClawsOffset
import ffviirse.domain.model.mapper.empressScepterOffset
import ffviirse.domain.model.mapper.fafnirRifleOffset
import ffviirse.domain.model.mapper.fumaShurikenOffset
import ffviirse.domain.model.mapper.gambanteinnWeaponOffset
import ffviirse.domain.model.mapper.gatlingGunOffset
import ffviirse.domain.model.mapper.gjallarhornWeaponOffset
import ffviirse.domain.model.mapper.goldenCollarOffset
import ffviirse.domain.model.mapper.goldenMegaphoneOffset
import ffviirse.domain.model.mapper.guardStickOffset
import ffviirse.domain.model.mapper.hicaliberRifleOffset
import ffviirse.domain.model.mapper.igneousSaberOffset
import ffviirse.domain.model.mapper.ironMegaphoneOffset
import ffviirse.domain.model.mapper.jarngreiprWeaponOffset
import ffviirse.domain.model.mapper.kaiserKnucklesOffset
import ffviirse.domain.model.mapper.leatherGlovesOffset
import ffviirse.domain.model.mapper.masamuneWeaponOffset
import ffviirse.domain.model.mapper.mysticCollarOffset
import ffviirse.domain.model.mapper.mythrilCollarOffset
import ffviirse.domain.model.mapper.plumoseRodOffset
import ffviirse.domain.model.mapper.pointShurikenOffset
import ffviirse.domain.model.mapper.redMegaphoneOffset
import ffviirse.domain.model.mapper.renegadesCollarOffset
import ffviirse.domain.model.mapper.resoundingMegaphoneOffset
import ffviirse.domain.model.mapper.runeBladeOffset
import ffviirse.domain.model.mapper.savageDaggerOffset
import ffviirse.domain.model.mapper.silverCollarOffset
import ffviirse.domain.model.mapper.sleekSaberOffset
import ffviirse.domain.model.mapper.slipstreamSaberOffset
import ffviirse.domain.model.mapper.sylphGlovesOffset
import ffviirse.domain.model.mapper.tigerFangsOffset
import ffviirse.domain.model.mapper.timelessRodOffset
import ffviirse.domain.model.mapper.twinViperOffset
import ffviirse.domain.model.mapper.umbralBladeOffset
import ffviirse.domain.model.mapper.vulcanCannonOffset
import ffviirse.domain.model.mapper.wizardsRodOffset
import ffviirse.domain.model.mapper.yellowMegaphoneOffset
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI

enum class MemberWeapon(
    val partyMember: PartyMember,
    val fileValue: Int,
    val displayWeapon: Boolean,
    val weaponName: () -> String
) : Labeled {

    BUSTER_SWORD(CLOUD_STRIFE, busterSwordOffset, true, { bundlePartyTab.partyMemberWeaponLabels.busterSwordLabel }),
    SLEEK_SABER(CLOUD_STRIFE, sleekSaberOffset, true, { bundlePartyTab.partyMemberWeaponLabels.sleekSaberLabel }),
    RUNE_BLADE(CLOUD_STRIFE, runeBladeOffset, true, { bundlePartyTab.partyMemberWeaponLabels.runeBladeLabel }),
    UMBRAL_BLADE(CLOUD_STRIFE, umbralBladeOffset, true, { bundlePartyTab.partyMemberWeaponLabels.umbralBladeLabel }),
    CRYSTAL_SWORD(CLOUD_STRIFE, crystalSwordOffset, true, { bundlePartyTab.partyMemberWeaponLabels.crystalSwordLabel }),
    IGNEOUS_SABER(CLOUD_STRIFE, igneousSaberOffset, true, { bundlePartyTab.partyMemberWeaponLabels.igneousSaberLabel }),
    SLIPSTREAM_SABER(CLOUD_STRIFE, slipstreamSaberOffset, true, { bundlePartyTab.partyMemberWeaponLabels.slipstreamSaberLabel }),
    GATLING_GUN(BARRET_WALLACE, gatlingGunOffset, true, { bundlePartyTab.partyMemberWeaponLabels.gatlingGunLabel }),
    HICALIBER_RIFLE(BARRET_WALLACE, hicaliberRifleOffset, true, { bundlePartyTab.partyMemberWeaponLabels.hicaliberRifleLabel }),
    BARRAGE_BLASTER(BARRET_WALLACE, barrageBlasterOffset, true, { bundlePartyTab.partyMemberWeaponLabels.barrageBlasterLabel }),
    VULCAN_CANNON(BARRET_WALLACE, vulcanCannonOffset, true, { bundlePartyTab.partyMemberWeaponLabels.vulcanCannonLabel }),
    FAFNIR_RIFLE(BARRET_WALLACE, fafnirRifleOffset, true, { bundlePartyTab.partyMemberWeaponLabels.fafnirRifleLabel }),
    CALAMITOUS_BAZOOKA(BARRET_WALLACE, calamitousBazookaOffset, true, { bundlePartyTab.partyMemberWeaponLabels.calamitousBazookaLabel }),
    BATTLE_CRY(BARRET_WALLACE, battleCryOffset, true, { bundlePartyTab.partyMemberWeaponLabels.battleCryLabel }),
    LEATHER_GLOVES(TIFA_LOCKHART, leatherGlovesOffset, true, { bundlePartyTab.partyMemberWeaponLabels.leatherGlovesLabel }),
    SYLPH_GLOVES(TIFA_LOCKHART, sylphGlovesOffset, true, { bundlePartyTab.partyMemberWeaponLabels.sylphGlovesLabel }),
    KAISER_KNUCKLES(TIFA_LOCKHART, kaiserKnucklesOffset, true, { bundlePartyTab.partyMemberWeaponLabels.kaiserKnucklesLabel }),
    DRAGON_CLAWS(TIFA_LOCKHART, dragonClawsOffset, true, { bundlePartyTab.partyMemberWeaponLabels.dragonClawsLabel }),
    TIGER_FANGS(TIFA_LOCKHART, tigerFangsOffset, true, { bundlePartyTab.partyMemberWeaponLabels.tigerFangsLabel }),
    CRYSTAL_GLOVES(TIFA_LOCKHART, crystalGlovesOffset, true, { bundlePartyTab.partyMemberWeaponLabels.crystalGlovesLabel }),
    JARNGREIPR_WEAPON(TIFA_LOCKHART, jarngreiprWeaponOffset, true, { bundlePartyTab.partyMemberWeaponLabels.jarngreiprWeaponLabel }),
    GUARD_STICK(AERITH_GAINSBOROUGH, guardStickOffset, true, { bundlePartyTab.partyMemberWeaponLabels.guardStickLabel }),
    TIMELESS_ROD(AERITH_GAINSBOROUGH, timelessRodOffset, true, { bundlePartyTab.partyMemberWeaponLabels.timelessRodLabel }),
    EMPRESS_SCEPTER(AERITH_GAINSBOROUGH, empressScepterOffset, true, { bundlePartyTab.partyMemberWeaponLabels.empressScepterLabel }),
    WIZARDS_ROD(AERITH_GAINSBOROUGH, wizardsRodOffset, true, { bundlePartyTab.partyMemberWeaponLabels.wizardsRodLabel }),
    CEREMONIAL_STAFF(AERITH_GAINSBOROUGH, ceremonialStaffOffset, true, { bundlePartyTab.partyMemberWeaponLabels.ceremonialStaffLabel }),
    PLUMOSE_ROD(AERITH_GAINSBOROUGH, plumoseRodOffset, true, { bundlePartyTab.partyMemberWeaponLabels.plumoseRodLabel }),
    GAMBANTEINN_WEAPON(AERITH_GAINSBOROUGH, gambanteinnWeaponOffset, true, { bundlePartyTab.partyMemberWeaponLabels.gambanteinnWeaponLabel }),
    MYTHRIL_COLLAR(RED_XIII, mythrilCollarOffset, true, { bundlePartyTab.partyMemberWeaponLabels.mythrilCollarLabel }),
    RENEGADES_COLLAR(RED_XIII, renegadesCollarOffset, true, { bundlePartyTab.partyMemberWeaponLabels.renegadesCollarLabel }),
    SILVER_COLLAR(RED_XIII, silverCollarOffset, true, { bundlePartyTab.partyMemberWeaponLabels.silverCollarLabel }),
    AMETHYST_COLLAR(RED_XIII, amethystCollarOffset, true, { bundlePartyTab.partyMemberWeaponLabels.amethystCollarLabel }),
    GOLDEN_COLLAR(RED_XIII, goldenCollarOffset, true, { bundlePartyTab.partyMemberWeaponLabels.goldenCollarLabel }),
    MYSTIC_COLLAR(RED_XIII, mysticCollarOffset, true, { bundlePartyTab.partyMemberWeaponLabels.mysticCollarLabel }),
    BRISINGAMEN_WEAPON(RED_XIII, brisingamenWeaponOffset, true, { bundlePartyTab.partyMemberWeaponLabels.brisingamenWeaponLabel }),
    POINT_SHURIKEN(YUFFIE_KISARAGI, pointShurikenOffset, true, { bundlePartyTab.partyMemberWeaponLabels.pointShurikenLabel }),
    SAVAGE_DAGGER(YUFFIE_KISARAGI, savageDaggerOffset, true, { bundlePartyTab.partyMemberWeaponLabels.savageDaggerLabel }),
    TWIN_VIPER(YUFFIE_KISARAGI, twinViperOffset, true, { bundlePartyTab.partyMemberWeaponLabels.twinViperLabel }),
    BIRD_PREY(YUFFIE_KISARAGI, birdPreyOffset, true, { bundlePartyTab.partyMemberWeaponLabels.birdPreyLabel }),
    CRESCENT_SICKLE(YUFFIE_KISARAGI, crescentSickleOffset, true, { bundlePartyTab.partyMemberWeaponLabels.crescentSickleLabel }),
    CRYSTALLINE_CROSS(YUFFIE_KISARAGI, crystallineCrossOffset, true, { bundlePartyTab.partyMemberWeaponLabels.crystallineCrossLabel }),
    FUMA_SHURIKEN(YUFFIE_KISARAGI, fumaShurikenOffset, true, { bundlePartyTab.partyMemberWeaponLabels.fumaShurikenLabel }),
    YELLOW_MEGAPHONE(CAIT_SITH, yellowMegaphoneOffset, true, { bundlePartyTab.partyMemberWeaponLabels.yellowMegaphoneLabel }),
    IRON_MEGAPHONE(CAIT_SITH, ironMegaphoneOffset, true, { bundlePartyTab.partyMemberWeaponLabels.ironMegaphoneLabel }),
    RED_MEGAPHONE(CAIT_SITH, redMegaphoneOffset, true, { bundlePartyTab.partyMemberWeaponLabels.redMegaphoneLabel }),
    RESOUNDING_MEGAPHONE(CAIT_SITH, resoundingMegaphoneOffset, true, { bundlePartyTab.partyMemberWeaponLabels.resoundingMegaphoneLabel }),
    CRYSTAL_MEGAPHONE(CAIT_SITH, crystalMegaphoneOffset, true, { bundlePartyTab.partyMemberWeaponLabels.crystalMegaphoneLabel }),
    GOLDEN_MEGAPHONE(CAIT_SITH, goldenMegaphoneOffset, true, { bundlePartyTab.partyMemberWeaponLabels.goldenMegaphoneLabel }),
    GJALLARHORN_WEAPON(CAIT_SITH, gjallarhornWeaponOffset, true, { bundlePartyTab.partyMemberWeaponLabels.gjallarhornWeaponLabel }),
    MASAMUNE_WEAPON(CLOUD_STRIFE, masamuneWeaponOffset, false, { bundlePartyTab.partyMemberWeaponLabels.masamuneWeaponLabel }),
    BUSTER_ZACK(CLOUD_STRIFE, busterZackOffset, false, { bundlePartyTab.partyMemberWeaponLabels.busterZackLabel });

    override val label: String
        get() = this.weaponName()

}
