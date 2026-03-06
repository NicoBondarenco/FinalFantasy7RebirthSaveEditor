package ffviirse.domain.model.mapper

import ffviirse.domain.model.value.PartyMember
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI
import java.nio.ByteBuffer
import java.nio.ByteOrder.LITTLE_ENDIAN

//region GENERAL OFFSET

val playTimeOffset: Int = 0x3C30

val gilBaseOffset: Int = 0x4FA70
val gilLimitOffset: Int = 0x800
val gilEntrySize: Int = 0x20

val mainMenuOffset: Int = 0x44AB1
val mainMenuBit: Int = 0
val extraSettingsOffset: Int = 0x4493A
val extraSettingsBit: Int = 2
val playLogOffset: Int = 0x4493A
val playLogBit: Int = 2

val groupExperienceOffset: Int = 0x4EEC4

fun ByteArray.gilsOffset(): Int {
    val buffer = ByteBuffer.wrap(this).order(LITTLE_ENDIAN)
    val tableBaseOffset = gilBaseOffset
    val entrySize = gilEntrySize

    for (i in 0 until gilLimitOffset) {
        val currentOffset = tableBaseOffset + (i * entrySize)
        if (currentOffset + 8 > this.size) break

        val id = buffer.getInt(currentOffset)
        if (id == 1) {
            return currentOffset + 4
        }
    }
    return tableBaseOffset
}

//endregion GENERAL OFFSET

//region OUTFIT OFFSET

val cloudExSoldierOffset: Int = 0
val cloudExSoldierBit: Int = 0
val cloudOceanChocoboOffset: Int = 0x44D2E
val cloudOceanChocoboBit: Int = 1
val cloudWildSurfOffset: Int = 0x44D2E
val cloudWildSurfBit: Int = 2
val cloudMidgarInfantryOffset: Int = 0x44D30
val cloudMidgarInfantryBit: Int = 1
val cloudMidgarHelmetOffset: Int = 0x44D2E
val cloudMidgarHelmetBit: Int = 3
val cloudMidgarCaptainOffset: Int = 0x44D2E
val cloudMidgarCaptainBit: Int = 4
val cloudAlphreidOutfitOffset: Int = 0x44D35
val cloudAlphreidOutfitBit: Int = 5
val tifaSeventhHeavenOffset: Int = 0
val tifaSeventhHeavenBit: Int = 0
val tifaMajesticGlamourOffset: Int = 0x44D2E
val tifaMajesticGlamourBit: Int = 5
val tifaShiningSpiritOffset: Int = 0x44D2E
val tifaShiningSpiritBit: Int = 6
val tifaMidgarInfantryOffset: Int = 0x44D30
val tifaMidgarInfantryBit: Int = 2
val tifaMidgarHelmetOffset: Int = 0x44D2E
val tifaMidgarHelmetBit: Int = 7
val tifaWithoutGlovesOffset: Int = 0x44D37
val tifaWithoutGlovesBit: Int = 7
val barretAvalancheLeaderOffset: Int = 0
val barretAvalancheLeaderBit: Int = 0
val barretJunonNavalOffset: Int = 0x44D2F
val barretJunonNavalBit: Int = 7
val barretBlackDenimOffset: Int = 0x44D30
val barretBlackDenimBit: Int = 6
val barretBlackInjuredOffset: Int = 0x44D30
val barretBlackInjuredBit: Int = 7
val aerithIndependentFloristOffset: Int = 0
val aerithIndependentFloristBit: Int = 0
val aerithFloralDelightOffset: Int = 0x44D2F
val aerithFloralDelightBit: Int = 0
val aerithPinkMermaidOffset: Int = 0x44D2F
val aerithPinkMermaidBit: Int = 1
val aerithMidgarInfantryOffset: Int = 0x44D30
val aerithMidgarInfantryBit: Int = 3
val aerithMidgarHelmetOffset: Int = 0x44D2F
val aerithMidgarHelmetBit: Int = 2
val redxiiiLaboratoryEscapeeOffset: Int = 0
val redxiiiLaboratoryEscapeeBit: Int = 0
val redxiiiHellhoundOutfitOffset: Int = 0x44D33
val redxiiiHellhoundOutfitBit: Int = 3
val redxiiiMidgarInfantryOffset: Int = 0x44D33
val redxiiiMidgarInfantryBit: Int = 5
val yuffieMateriaHunterOffset: Int = 0
val yuffieMateriaHunterBit: Int = 0
val yuffieSummerOrangeOffset: Int = 0x44D30
val yuffieSummerOrangeBit: Int = 4
val yuffieMoogleCapeOffset: Int = 0x44D30
val yuffieMoogleCapeBit: Int = 5
val yuffieWutaiStarOffset: Int = 0x44D37
val yuffieWutaiStarBit: Int = 5
val caitFortuneTellerOffset: Int = 0
val caitFortuneTellerBit: Int = 0
val caitCourtJesterOffset: Int = 0x44D33
val caitCourtJesterBit: Int = 4

//endregion OUTFIT OFFSET

//region CHAPTER OFFSET

val chapterSelectionOffset: Int = 0x44D2C
val chapterSelectionBit: Int = 4
val chapterOneOffset: Int = 0x448C8
val chapterOneBit: Int = 6
val chapterTwoOffset: Int = 0x448C8
val chapterTwoBit: Int = 7
val chapterThreeOffset: Int = 0x448C9
val chapterThreeBit: Int = 0
val chapterFourOffset: Int = 0x448C9
val chapterFourBit: Int = 1
val chapterFiveOffset: Int = 0x448C9
val chapterFiveBit: Int = 2
val chapterSixOffset: Int = 0x448C9
val chapterSixBit: Int = 3
val chapterSevenOffset: Int = 0x448C9
val chapterSevenBit: Int = 4
val chapterEightOffset: Int = 0x448C9
val chapterEightBit: Int = 5
val chapterNineOffset: Int = 0x448C9
val chapterNineBit: Int = 6
val chapterTenOffset: Int = 0x448C9
val chapterTenBit: Int = 7
val chapterElevenOffset: Int = 0x448CA
val chapterElevenBit: Int = 0
val chapterTwelveOffset: Int = 0x448CA
val chapterTwelveBit: Int = 1
val chapterThirteenOffset: Int = 0x448CA
val chapterThirteenBit: Int = 2
val chapterFourteenOffset: Int = 0x448CA
val chapterFourteenBit: Int = 3

//endregion CHAPTER OFFSET

//region ENEMY SKILL OFFSET

val noSkillOffset: Int = 0x00000
val rancidBreathOffset: Int = 0x3B3C0
val plasmaDischargeOffset: Int = 0x48B53
val mindBlastOffset: Int = 0x66C44
val gorgonShieldOffset: Int = 0xD31E9
val soothingBreezeOffset: Int = 0x108473
val selfDestructOffset: Int = 0x14DD84
val sonicBoomOffset: Int = 0x15C8C4
val skillSlotOne: Int = 0x4472C
val skillSlotTwo: Int = 0x44730
val skillSlotThree: Int = 0x44734
val skillSlotFour: Int = 0x44738
val skillSlotFive: Int = 0x4473C
val skillSlotSix: Int = 0x44740
val skillSlotSeven: Int = 0x44744


//endregion ENEMY SKILL OFFSET

//region CHARACTER STATUS OFFSET

val characterBaseOffset: Int = 0x100
val characterLevelOffset: Int = 0x30
val characterExperienceOffset: Int = 0x50
val characterRelationshipOffset: Int = 0xA8
val characterHpcurrentOffset: Int = 0x40
val characterHpmaxOffset: Int = 0x44
val characterMpcurrentOffset: Int = 0x48
val characterMpmaxOffset: Int = 0x4C
val characterAttackOffset: Int = 0x58
val characterMattackOffset: Int = 0x5C
val characterDefenseOffset: Int = 0x60
val characterMdefenseOffset: Int = 0x64
val characterStrengthOffset: Int = 0x70
val characterMagicOffset: Int = 0x74
val characterVitalityOffset: Int = 0x78
val characterSpiritOffset: Int = 0x7C
val characterLuckOffset: Int = 0x68
val characterSpeedOffset: Int = 0x80
val criticalHrateOffset: Int = 0x6C
val weaponLevelOffset: Int = 0xEC
val characterWeaponOffset: Int = 0xCC
val characterArmorOffset: Int = 0xD0
val characterSummonOffset: Int = 0xD4
val characterAccessoryOffset: Int = 0xD8
val weaponMateriaOffset: Int = 0xF4
val armorMateriaOffset: Int = 0xAC

//endregion CHARACTER STATUS OFFSET

//region CHARACTER SKILL ABILITY OFFSET

val cloudHpUpOffset: Int = 0x4e0c1
val cloudHpUpBit: Int = 1
val cloudMaxHpOffset: Int = 0x4e102
val cloudMaxHpBit: Int = 2
val cloudMaxMpOffset: Int = 0x4e0ac
val cloudMaxMpBit: Int = 3
val cloudWeaponDamageOffset: Int = 0x4e11e
val cloudWeaponDamageBit: Int = 3
val cloudEnhancedLimitOffset: Int = 0x4e0c7
val cloudEnhancedLimitBit: Int = 2
val cloudStaggerUpOffset: Int = 0x4e0f3
val cloudStaggerUpBit: Int = 6
val cloudAttackUpOffset: Int = 0x4e0b7
val cloudAttackUpBit: Int = 7
val cloudEnhancedAttackOffset: Int = 0x4e0e5
val cloudEnhancedAttackBit: Int = 5
val cloudEnhancedGuardOffset: Int = 0x4e0b3
val cloudEnhancedGuardBit: Int = 4
val cloudSynergyDamageOffset: Int = 0x4e0e7
val cloudSynergyDamageBit: Int = 4
val cloudLimitGuardOffset: Int = 0x4e0b6
val cloudLimitGuardBit: Int = 0
val cloudLimitStaggerOffset: Int = 0x4e115
val cloudLimitStaggerBit: Int = 4
val cloudAtbChargeOffset: Int = 0x4e099
val cloudAtbChargeBit: Int = 5
val cloudMpRecoveryOffset: Int = 0x4e134
val cloudMpRecoveryBit: Int = 3
val cloudOpeningAtbOffset: Int = 0x4e09e
val cloudOpeningAtbBit: Int = 2
val cloudAtbLimitOffset: Int = 0x4e151
val cloudAtbLimitBit: Int = 6
val cloudFormidableCounterOffset: Int = 0x4e118
val cloudFormidableCounterBit: Int = 7
val cloudPowerfulPunisherOffset: Int = 0x4e11c
val cloudPowerfulPunisherBit: Int = 7
val cloudStalwartPunisherOffset: Int = 0x4e14f
val cloudStalwartPunisherBit: Int = 3
val cloudFinishingTouchOffset: Int = 0x4e0a7
val cloudFinishingTouchBit: Int = 2
val cloudAerialOnslaughtOffset: Int = 0x4e0c0
val cloudAerialOnslaughtBit: Int = 3
val cloudWildfireAbilityOffset: Int = 0x4e0dc
val cloudWildfireAbilityBit: Int = 2
val cloudSnowFlurryOffset: Int = 0x4e155
val cloudSnowFlurryBit: Int = 4
val cloudStaticShockOffset: Int = 0x4e140
val cloudStaticShockBit: Int = 2
val cloudWindCurrentOffset: Int = 0x4e08e
val cloudWindCurrentBit: Int = 3
val cloudCounterfireAbilityOffset: Int = 0x4e084
val cloudCounterfireAbilityBit: Int = 0
val cloudMeleeBladeOffset: Int = 0x4e0ce
val cloudMeleeBladeBit: Int = 1
val cloudRangedBladeOffset: Int = 0x4e154
val cloudRangedBladeBit: Int = 6
val cloudPartnersPainOffset: Int = 0x4e172
val cloudPartnersPainBit: Int = 5
val cloudUnitedRefocusOffset: Int = 0x4e103
val cloudUnitedRefocusBit: Int = 1
val cloudRelentlessRushOffset: Int = 0x4e106
val cloudRelentlessRushBit: Int = 7
val cloudFireworkBladeOffset: Int = 0x4e0c9
val cloudFireworkBladeBit: Int = 7
val cloudMaelstromStrikeOffset: Int = 0x4e0b9
val cloudMaelstromStrikeBit: Int = 5
val cloudCuriosityEndOffset: Int = 0x4e0b3
val cloudCuriosityEndBit: Int = 7
val tifaMaxHpOffset: Int = 0x4e0b8
val tifaMaxHpBit: Int = 0
val tifaMaxMpOffset: Int = 0x4e179
val tifaMaxMpBit: Int = 4
val tifaCriticalHitOffset: Int = 0x4e174
val tifaCriticalHitBit: Int = 7
val tifaCriticalRateOffset: Int = 0x4e17c
val tifaCriticalRateBit: Int = 4
val tifaWeaponDamageOffset: Int = 0x4e173
val tifaWeaponDamageBit: Int = 1
val tifaEnhancedLimitOffset: Int = 0x4e0d6
val tifaEnhancedLimitBit: Int = 4
val tifaComboDamageOffset: Int = 0x4e0db
val tifaComboDamageBit: Int = 4
val tifaEnhancedTechniquesOffset: Int = 0x4e09c
val tifaEnhancedTechniquesBit: Int = 6
val tifaWeaponRecoveryOffset: Int = 0x4e0a9
val tifaWeaponRecoveryBit: Int = 1
val tifaLimitStaggerOffset: Int = 0x4e0c9
val tifaLimitStaggerBit: Int = 3
val tifaAtbChargeOffset: Int = 0x4e0f9
val tifaAtbChargeBit: Int = 4
val tifaMpRecoveryOffset: Int = 0x4e0bc
val tifaMpRecoveryBit: Int = 0
val tifaOpeningAtbOffset: Int = 0x4e10a
val tifaOpeningAtbBit: Int = 6
val tifaOpeningBonusOffset: Int = 0x4e126
val tifaOpeningBonusBit: Int = 3
val tifaReprieveAbilityOffset: Int = 0x4e17b
val tifaReprieveAbilityBit: Int = 0
val tifaConcentrationAbilityOffset: Int = 0x4e088
val tifaConcentrationAbilityBit: Int = 1
val tifaMartialMasteryOffset: Int = 0x4e0a1
val tifaMartialMasteryBit: Int = 5
val tifaUtterlyUnbridledOffset: Int = 0x4e0ed
val tifaUtterlyUnbridledBit: Int = 4
val tifaSteadfastConcentrationOffset: Int = 0x4e107
val tifaSteadfastConcentrationBit: Int = 0
val tifaMeteoStrikesOffset: Int = 0x4e115
val tifaMeteoStrikesBit: Int = 5
val tifaTrinityStrikeOffset: Int = 0x4e0bd
val tifaTrinityStrikeBit: Int = 0
val tifaFieryImpulseOffset: Int = 0x4e15c
val tifaFieryImpulseBit: Int = 3
val tifaIcyImpulseOffset: Int = 0x4e165
val tifaIcyImpulseBit: Int = 1
val tifaElectricImpulseOffset: Int = 0x4e0df
val tifaElectricImpulseBit: Int = 2
val tifaGaleImpulseOffset: Int = 0x4e0db
val tifaGaleImpulseBit: Int = 6
val tifaSlipSlideOffset: Int = 0x4e0a9
val tifaSlipSlideBit: Int = 7
val tifaLeapingStrikesOffset: Int = 0x4e14f
val tifaLeapingStrikesBit: Int = 2
val tifaBodyguardAbilityOffset: Int = 0x4e0c5
val tifaBodyguardAbilityBit: Int = 5
val tifaSynchroCycloneOffset: Int = 0x4e173
val tifaSynchroCycloneBit: Int = 6
val tifaUnitedBarretOffset: Int = 0x4e10a
val tifaUnitedBarretBit: Int = 3
val tifaUnitedAerithOffset: Int = 0x4e0fa
val tifaUnitedAerithBit: Int = 1
val tifaBestialBarrageOffset: Int = 0x4e0e6
val tifaBestialBarrageBit: Int = 0
val tifaUnitedYuffieOffset: Int = 0x4e140
val tifaUnitedYuffieBit: Int = 7
val tifaMoogleShotOffset: Int = 0x4e151
val tifaMoogleShotBit: Int = 5
val barretHpUpOffset: Int = 0x4e0b8
val barretHpUpBit: Int = 2
val barretMaxHpOffset: Int = 0x4e13a
val barretMaxHpBit: Int = 4
val barretUpHpOffset: Int = 0x4e11b
val barretUpHpBit: Int = 6
val barretMaxMpOffset: Int = 0x4e145
val barretMaxMpBit: Int = 2
val barretDefUpOffset: Int = 0x4e0f5
val barretDefUpBit: Int = 2
val barretWeaponDamageOffset: Int = 0x4e0c3
val barretWeaponDamageBit: Int = 1
val barretEnhancedOverchargeOffset: Int = 0x4e08c
val barretEnhancedOverchargeBit: Int = 2
val barretSelfishRecoveryOffset: Int = 0x4e0df
val barretSelfishRecoveryBit: Int = 4
val barretSelfishBoostOffset: Int = 0x4e134
val barretSelfishBoostBit: Int = 1
val barretEnhancedGuardOffset: Int = 0x4e105
val barretEnhancedGuardBit: Int = 2
val barretBuffUpOffset: Int = 0x4e146
val barretBuffUpBit: Int = 7
val barretSynergyDamageOffset: Int = 0x4e14d
val barretSynergyDamageBit: Int = 3
val barretLimitStaggerOffset: Int = 0x4e16e
val barretLimitStaggerBit: Int = 3
val barretLimitChargeOffset: Int = 0x4e0b2
val barretLimitChargeBit: Int = 3
val barretPhysicalSafeguardOffset: Int = 0x4e090
val barretPhysicalSafeguardBit: Int = 6
val barretRegenerationAbilityOffset: Int = 0x4e14e
val barretRegenerationAbilityBit: Int = 2
val barretOverloadOverchargeOffset: Int = 0x4e0ee
val barretOverloadOverchargeBit: Int = 6
val barretMassiveRechargeOffset: Int = 0x4e14a
val barretMassiveRechargeBit: Int = 4
val barretStaggeringChargeOffset: Int = 0x4e0ec
val barretStaggeringChargeBit: Int = 3
val barretSatelliteBeamOffset: Int = 0x4e0fe
val barretSatelliteBeamBit: Int = 0
val barretLifebloodCannonOffset: Int = 0x4e0d5
val barretLifebloodCannonBit: Int = 4
val barretFieryImpulseOffset: Int = 0x4e11b
val barretFieryImpulseBit: Int = 5
val barretIcyImpulseOffset: Int = 0x4e117
val barretIcyImpulseBit: Int = 4
val barretElectricImpulseOffset: Int = 0x4e167
val barretElectricImpulseBit: Int = 1
val barretGaleImpulseOffset: Int = 0x4e174
val barretGaleImpulseBit: Int = 4
val barretMadDashOffset: Int = 0x4e157
val barretMadDashBit: Int = 7
val barretIronDefenseOffset: Int = 0x4e0e2
val barretIronDefenseBit: Int = 0
val barretFriendlyFireOffset: Int = 0x4e0c6
val barretFriendlyFireBit: Int = 1
val barretUnitedCloudOffset: Int = 0x4e147
val barretUnitedCloudBit: Int = 6
val barretAvalancheTwostepOffset: Int = 0x4e091
val barretAvalancheTwostepBit: Int = 7
val barretArcaneBlastOffset: Int = 0x4e106
val barretArcaneBlastBit: Int = 2
val barretUnitedRedOffset: Int = 0x4e08c
val barretUnitedRedBit: Int = 6
val barretNinjaCarbineOffset: Int = 0x4e15a
val barretNinjaCarbineBit: Int = 4
val barretPurrfectShotOffset: Int = 0x4e0b9
val barretPurrfectShotBit: Int = 4
val aerithMpUpOffset: Int = 0x4e127
val aerithMpUpBit: Int = 3
val aerithMaxMpOffset: Int = 0x4e112
val aerithMaxMpBit: Int = 3
val aerithMaxHpOffset: Int = 0x4e139
val aerithMaxHpBit: Int = 1
val aerithMatkUpOffset: Int = 0x4e099
val aerithMatkUpBit: Int = 3
val aerithMdefUpOffset: Int = 0x4e142
val aerithMdefUpBit: Int = 2
val aerithElementalDamageOffset: Int = 0x4e160
val aerithElementalDamageBit: Int = 6
val aerithEnhancedTempestOffset: Int = 0x4e0c9
val aerithEnhancedTempestBit: Int = 0
val aerithFullpowerMagicOffset: Int = 0x4e0bf
val aerithFullpowerMagicBit: Int = 1
val aerithAltruisticBoostOffset: Int = 0x4e117
val aerithAltruisticBoostBit: Int = 3
val aerithEnhancedMagicOffset: Int = 0x4e0d3
val aerithEnhancedMagicBit: Int = 4
val aerithDebuffExtensionOffset: Int = 0x4e0fe
val aerithDebuffExtensionBit: Int = 4
val aerithSynergyDamageOffset: Int = 0x4e0be
val aerithSynergyDamageBit: Int = 7
val aerithSynergyUpOffset: Int = 0x4e115
val aerithSynergyUpBit: Int = 0
val aerithMpRecoveryOffset: Int = 0x4e16a
val aerithMpRecoveryBit: Int = 0
val aerithTradeOffOffset: Int = 0x4e0a2
val aerithTradeOffBit: Int = 4
val aerithMpLimitOffset: Int = 0x4e178
val aerithMpLimitBit: Int = 6
val aerithSpiritualHarvestOffset: Int = 0x4e108
val aerithSpiritualHarvestBit: Int = 0
val aerithFleetingFamiliarOffset: Int = 0x4e0df
val aerithFleetingFamiliarBit: Int = 5
val aerithEnduringWardOffset: Int = 0x4e148
val aerithEnduringWardBit: Int = 7
val aerithRisingFuryOffset: Int = 0x4e0a7
val aerithRisingFuryBit: Int = 1
val aerithTranscendenceAbilityOffset: Int = 0x4e0dd
val aerithTranscendenceAbilityBit: Int = 4
val aerithHeatwaveAbilityOffset: Int = 0x4e16f
val aerithHeatwaveAbilityBit: Int = 7
val aerithColdFrontOffset: Int = 0x4e165
val aerithColdFrontBit: Int = 2
val aerithRollingThunderOffset: Int = 0x4e0a0
val aerithRollingThunderBit: Int = 5
val aerithJetStreamOffset: Int = 0x4e131
val aerithJetStreamBit: Int = 4
val aerithCombatSaviorOffset: Int = 0x4e0dc
val aerithCombatSaviorBit: Int = 6
val aerithBodyguardAbilityOffset: Int = 0x4e178
val aerithBodyguardAbilityBit: Int = 5
val aerithSpellboundBlastOffset: Int = 0x4e0be
val aerithSpellboundBlastBit: Int = 1
val aerithUnitedCloudOffset: Int = 0x4e0d9
val aerithUnitedCloudBit: Int = 1
val aerithSweetSourOffset: Int = 0x4e100
val aerithSweetSourBit: Int = 3
val aerithDivinePunishmentOffset: Int = 0x4e0a4
val aerithDivinePunishmentBit: Int = 5
val aerithPlanetaryRoarOffset: Int = 0x4e170
val aerithPlanetaryRoarBit: Int = 1
val aerithUnitedYuffieOffset: Int = 0x4e0f9
val aerithUnitedYuffieBit: Int = 5
val aerithKittyCannonadeOffset: Int = 0x4e0b9
val aerithKittyCannonadeBit: Int = 2
val redHpUpOffset: Int = 0x4e0ed
val redHpUpBit: Int = 1
val redUpHpOffset: Int = 0x4e086
val redUpHpBit: Int = 6
val redMaxHpOffset: Int = 0x4e10f
val redMaxHpBit: Int = 2
val redMpUpOffset: Int = 0x4e0eb
val redMpUpBit: Int = 1
val redMaxMpOffset: Int = 0x4e123
val redMaxMpBit: Int = 1
val redMdefUpOffset: Int = 0x4e0c7
val redMdefUpBit: Int = 5
val redSpeedUpOffset: Int = 0x4e141
val redSpeedUpBit: Int = 5
val redSelfishBoostOffset: Int = 0x4e0a8
val redSelfishBoostBit: Int = 1
val redElementalDefenseOffset: Int = 0x4e13a
val redElementalDefenseBit: Int = 6
val redAfflictedDebuffOffset: Int = 0x4e17d
val redAfflictedDebuffBit: Int = 4
val redLimitGuardOffset: Int = 0x4e157
val redLimitGuardBit: Int = 6
val redMpRecoveryOffset: Int = 0x4e111
val redMpRecoveryBit: Int = 6
val redBloodsuckerAbilityOffset: Int = 0x4e0ea
val redBloodsuckerAbilityBit: Int = 6
val redSiphonFangOffset: Int = 0x4e0cb
val redSiphonFangBit: Int = 1
val redVengefulGuardianOffset: Int = 0x4e11c
val redVengefulGuardianBit: Int = 6
val redEnduringVengeanceOffset: Int = 0x4e100
val redEnduringVengeanceBit: Int = 4
val redInvigoratingVengeanceOffset: Int = 0x4e093
val redInvigoratingVengeanceBit: Int = 6
val redVengefulRevenantOffset: Int = 0x4e0f1
val redVengefulRevenantBit: Int = 6
val redEnhancedCounterspinOffset: Int = 0x4e110
val redEnhancedCounterspinBit: Int = 0
val redWrathLandOffset: Int = 0x4e126
val redWrathLandBit: Int = 2
val redRetaliationAbilityOffset: Int = 0x4e0e1
val redRetaliationAbilityBit: Int = 6
val redWildfireAbilityOffset: Int = 0x4e146
val redWildfireAbilityBit: Int = 3
val redSnowFlurryOffset: Int = 0x4e0f8
val redSnowFlurryBit: Int = 3
val redStaticShockOffset: Int = 0x4e160
val redStaticShockBit: Int = 7
val redWindCurrentOffset: Int = 0x4e0e3
val redWindCurrentBit: Int = 1
val redPhantomFangOffset: Int = 0x4e0e2
val redPhantomFangBit: Int = 1
val redWildChargeOffset: Int = 0x4e097
val redWildChargeBit: Int = 4
val redIronDefenseOffset: Int = 0x4e092
val redIronDefenseBit: Int = 5
val redSavageAssaultOffset: Int = 0x4e089
val redSavageAssaultBit: Int = 7
val redOverfangAbilityOffset: Int = 0x4e0ad
val redOverfangAbilityBit: Int = 2
val redCallWildOffset: Int = 0x4e0f3
val redCallWildBit: Int = 2
val redRingmasterAbilityOffset: Int = 0x4e11f
val redRingmasterAbilityBit: Int = 2
val redHackSlashOffset: Int = 0x4e141
val redHackSlashBit: Int = 2
val redFelineFuryOffset: Int = 0x4e0e5
val redFelineFuryBit: Int = 4
val yuffieMaxHpOffset: Int = 0x4e0f3
val yuffieMaxHpBit: Int = 1
val yuffieMaxMpOffset: Int = 0x4e0f4
val yuffieMaxMpBit: Int = 3
val yuffieLuckUpOffset: Int = 0x4e0ec
val yuffieLuckUpBit: Int = 4
val yuffieElementalDamageOffset: Int = 0x4e0b0
val yuffieElementalDamageBit: Int = 4
val yuffieElementalUpOffset: Int = 0x4e0e6
val yuffieElementalUpBit: Int = 4
val yuffieEnhancedAttackOffset: Int = 0x4e12b
val yuffieEnhancedAttackBit: Int = 2
val yuffieHuntersPrecisionOffset: Int = 0x4e141
val yuffieHuntersPrecisionBit: Int = 0
val yuffieEnhancedGuardOffset: Int = 0x4e0ce
val yuffieEnhancedGuardBit: Int = 3
val yuffieAfflictedDebuffOffset: Int = 0x4e0c2
val yuffieAfflictedDebuffBit: Int = 0
val yuffieWeaponAtbOffset: Int = 0x4e097
val yuffieWeaponAtbBit: Int = 0
val yuffieSynergyDamageOffset: Int = 0x4e166
val yuffieSynergyDamageBit: Int = 6
val yuffieSynergyUpOffset: Int = 0x4e0de
val yuffieSynergyUpBit: Int = 6
val yuffieMpRecoveryOffset: Int = 0x4e104
val yuffieMpRecoveryBit: Int = 0
val yuffieOpeningAtbOffset: Int = 0x4e0a9
val yuffieOpeningAtbBit: Int = 0
val yuffieAtbLimitOffset: Int = 0x4e0e7
val yuffieAtbLimitBit: Int = 1
val yuffieMasterThiefOffset: Int = 0x4e0c1
val yuffieMasterThiefBit: Int = 7
val yuffieFaithfulThiefOffset: Int = 0x4e102
val yuffieFaithfulThiefBit: Int = 7
val yuffiePrecisionDefenseOffset: Int = 0x4e0f7
val yuffiePrecisionDefenseBit: Int = 4
val yuffiePrecisionAtbOffset: Int = 0x4e14d
val yuffiePrecisionAtbBit: Int = 0
val yuffieDevastationAbilityOffset: Int = 0x4e168
val yuffieDevastationAbilityBit: Int = 4
val yuffieStormsFuryOffset: Int = 0x4e0d1
val yuffieStormsFuryBit: Int = 5
val yuffieWildfireAbilityOffset: Int = 0x4e0f3
val yuffieWildfireAbilityBit: Int = 4
val yuffieSnowFlurryOffset: Int = 0x4e0bd
val yuffieSnowFlurryBit: Int = 5
val yuffieStaticShockOffset: Int = 0x4e163
val yuffieStaticShockBit: Int = 5
val yuffieWindCurrentOffset: Int = 0x4e14a
val yuffieWindCurrentBit: Int = 5
val yuffieShurikenSyncOffset: Int = 0x4e16c
val yuffieShurikenSyncBit: Int = 2
val yuffieNinjaBazookaOffset: Int = 0x4e137
val yuffieNinjaBazookaBit: Int = 6
val yuffieFoxflameAbilityOffset: Int = 0x4e158
val yuffieFoxflameAbilityBit: Int = 2
val yuffieHalcyonDescentOffset: Int = 0x4e113
val yuffieHalcyonDescentBit: Int = 1
val yuffieUnitedBarretOffset: Int = 0x4e159
val yuffieUnitedBarretBit: Int = 2
val yuffieCyclonicKickOffset: Int = 0x4e0e0
val yuffieCyclonicKickBit: Int = 2
val yuffieMysticMultiplicationOffset: Int = 0x4e09c
val yuffieMysticMultiplicationBit: Int = 2
val yuffieUnitedRedOffset: Int = 0x4e091
val yuffieUnitedRedBit: Int = 1
val yuffieMooglePinwheelOffset: Int = 0x4e0e5
val yuffieMooglePinwheelBit: Int = 7
val caitMaxMpOffset: Int = 0x4e118
val caitMaxMpBit: Int = 2
val caitMaxHpOffset: Int = 0x4e130
val caitMaxHpBit: Int = 2
val caitLuckUpOffset: Int = 0x4e17d
val caitLuckUpBit: Int = 5
val caitCriticalHitOffset: Int = 0x4e0b4
val caitCriticalHitBit: Int = 4
val caitCriticalDamageOffset: Int = 0x4e120
val caitCriticalDamageBit: Int = 0
val caitWeaponDamageOffset: Int = 0x4e164
val caitWeaponDamageBit: Int = 3
val caitEnhancedLimitOffset: Int = 0x4e140
val caitEnhancedLimitBit: Int = 0
val caitEnhancedGuardOffset: Int = 0x4e0ea
val caitEnhancedGuardBit: Int = 3
val caitElementalDefenseOffset: Int = 0x4e136
val caitElementalDefenseBit: Int = 4
val caitAtbChargeOffset: Int = 0x4e160
val caitAtbChargeBit: Int = 3
val caitMpRecoveryOffset: Int = 0x4e148
val caitMpRecoveryBit: Int = 6
val caitLimitGaugeOffset: Int = 0x4e09b
val caitLimitGaugeBit: Int = 1
val caitStaggerSiphonOffset: Int = 0x4e0d2
val caitStaggerSiphonBit: Int = 1
val caitOpeningAtbOffset: Int = 0x4e0f8
val caitOpeningAtbBit: Int = 6
val caitReprieveAbilityOffset: Int = 0x4e160
val caitReprieveAbilityBit: Int = 0
val caitLuckyJockeyOffset: Int = 0x4e0e5
val caitLuckyJockeyBit: Int = 2
val caitMoogleStartOffset: Int = 0x4e17a
val caitMoogleStartBit: Int = 4
val caitMoogleVanguardOffset: Int = 0x4e0c8
val caitMoogleVanguardBit: Int = 5
val caitMoogleSentinelOffset: Int = 0x4e0cc
val caitMoogleSentinelBit: Int = 6
val caitGigaMogboxOffset: Int = 0x4e159
val caitGigaMogboxBit: Int = 5
val caitLuckySlotsOffset: Int = 0x4e093
val caitLuckySlotsBit: Int = 5
val caitHeatwaveAbilityOffset: Int = 0x4e147
val caitHeatwaveAbilityBit: Int = 1
val caitColdFrontOffset: Int = 0x4e130
val caitColdFrontBit: Int = 3
val caitRollingThunderOffset: Int = 0x4e0c8
val caitRollingThunderBit: Int = 2
val caitJetStreamOffset: Int = 0x4e142
val caitJetStreamBit: Int = 6
val caitAlloutAssaultOffset: Int = 0x4e094
val caitAlloutAssaultBit: Int = 2
val caitMagicMegaphoneOffset: Int = 0x4e0e4
val caitMagicMegaphoneBit: Int = 6
val caitBodyguardAbilityOffset: Int = 0x4e0bd
val caitBodyguardAbilityBit: Int = 1
val caitSoldierMoogleOffset: Int = 0x4e0e3
val caitSoldierMoogleBit: Int = 4
val caitMayhemRoundOffset: Int = 0x4e12b
val caitMayhemRoundBit: Int = 4
val caitUnitedTifaOffset: Int = 0x4e10f
val caitUnitedTifaBit: Int = 6
val caitMegaMoogleOffset: Int = 0x4e0fa
val caitMegaMoogleBit: Int = 7
val caitMognificentShotOffset: Int = 0x4e0de
val caitMognificentShotBit: Int = 7
val caitUnitedYuffieOffset: Int = 0x4e0f0
val caitUnitedYuffieBit: Int = 1

//endregion CHARACTER SKILL ABILITY OFFSET

//region GENERAL SKILL ABILITY OFFSET

val PartyMember.statBoost01Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudHpUpOffset
        TIFA_LOCKHART -> tifaMaxHpOffset
        BARRET_WALLACE -> barretHpUpOffset
        AERITH_GAINSBOROUGH -> aerithMpUpOffset
        RED_XIII -> redHpUpOffset
        YUFFIE_KISARAGI -> yuffieMaxHpOffset
        CAIT_SITH -> caitMaxMpOffset
    }
val PartyMember.statBoost02Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMaxHpOffset
        TIFA_LOCKHART -> tifaMaxMpOffset
        BARRET_WALLACE -> barretMaxHpOffset
        AERITH_GAINSBOROUGH -> aerithMaxMpOffset
        RED_XIII -> redUpHpOffset
        YUFFIE_KISARAGI -> yuffieMaxMpOffset
        CAIT_SITH -> caitMaxHpOffset
    }
val PartyMember.statBoost03Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMaxMpOffset
        TIFA_LOCKHART -> tifaCriticalHitOffset
        BARRET_WALLACE -> barretUpHpOffset
        AERITH_GAINSBOROUGH -> aerithMaxHpOffset
        RED_XIII -> redMaxHpOffset
        YUFFIE_KISARAGI -> yuffieLuckUpOffset
        CAIT_SITH -> caitLuckUpOffset
    }
val PartyMember.statBoost04Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudWeaponDamageOffset
        TIFA_LOCKHART -> tifaCriticalRateOffset
        BARRET_WALLACE -> barretMaxMpOffset
        AERITH_GAINSBOROUGH -> aerithMatkUpOffset
        RED_XIII -> redMpUpOffset
        YUFFIE_KISARAGI -> yuffieElementalDamageOffset
        CAIT_SITH -> caitCriticalHitOffset
    }
val PartyMember.statBoost05Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudEnhancedLimitOffset
        TIFA_LOCKHART -> tifaWeaponDamageOffset
        BARRET_WALLACE -> barretDefUpOffset
        AERITH_GAINSBOROUGH -> aerithMdefUpOffset
        RED_XIII -> redMaxMpOffset
        YUFFIE_KISARAGI -> yuffieElementalUpOffset
        CAIT_SITH -> caitCriticalDamageOffset
    }
val PartyMember.statBoost06Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudStaggerUpOffset
        TIFA_LOCKHART -> tifaEnhancedLimitOffset
        BARRET_WALLACE -> barretWeaponDamageOffset
        AERITH_GAINSBOROUGH -> aerithElementalDamageOffset
        RED_XIII -> redMdefUpOffset
        YUFFIE_KISARAGI -> yuffieEnhancedAttackOffset
        CAIT_SITH -> caitWeaponDamageOffset
    }
val PartyMember.statBoost07Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAttackUpOffset
        TIFA_LOCKHART -> tifaComboDamageOffset
        BARRET_WALLACE -> barretEnhancedOverchargeOffset
        AERITH_GAINSBOROUGH -> aerithEnhancedTempestOffset
        RED_XIII -> redSpeedUpOffset
        YUFFIE_KISARAGI -> yuffieHuntersPrecisionOffset
        CAIT_SITH -> caitEnhancedLimitOffset
    }
val PartyMember.statBoost08Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudEnhancedAttackOffset
        TIFA_LOCKHART -> tifaEnhancedTechniquesOffset
        BARRET_WALLACE -> barretSelfishRecoveryOffset
        AERITH_GAINSBOROUGH -> aerithFullpowerMagicOffset
        RED_XIII -> redSelfishBoostOffset
        YUFFIE_KISARAGI -> yuffieEnhancedGuardOffset
        CAIT_SITH -> caitEnhancedGuardOffset
    }
val PartyMember.statBoost09Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudEnhancedGuardOffset
        TIFA_LOCKHART -> tifaWeaponRecoveryOffset
        BARRET_WALLACE -> barretSelfishBoostOffset
        AERITH_GAINSBOROUGH -> aerithAltruisticBoostOffset
        RED_XIII -> redElementalDefenseOffset
        YUFFIE_KISARAGI -> yuffieAfflictedDebuffOffset
        CAIT_SITH -> caitElementalDefenseOffset
    }
val PartyMember.statBoost10Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudSynergyDamageOffset
        TIFA_LOCKHART -> tifaLimitStaggerOffset
        BARRET_WALLACE -> barretEnhancedGuardOffset
        AERITH_GAINSBOROUGH -> aerithEnhancedMagicOffset
        RED_XIII -> redAfflictedDebuffOffset
        YUFFIE_KISARAGI -> yuffieWeaponAtbOffset
        CAIT_SITH -> caitAtbChargeOffset
    }
val PartyMember.statBoost11Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudLimitGuardOffset
        TIFA_LOCKHART -> tifaAtbChargeOffset
        BARRET_WALLACE -> barretBuffUpOffset
        AERITH_GAINSBOROUGH -> aerithDebuffExtensionOffset
        RED_XIII -> redLimitGuardOffset
        YUFFIE_KISARAGI -> yuffieSynergyDamageOffset
        CAIT_SITH -> caitMpRecoveryOffset
    }
val PartyMember.statBoost12Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudLimitStaggerOffset
        TIFA_LOCKHART -> tifaMpRecoveryOffset
        BARRET_WALLACE -> barretSynergyDamageOffset
        AERITH_GAINSBOROUGH -> aerithSynergyDamageOffset
        RED_XIII -> redMpRecoveryOffset
        YUFFIE_KISARAGI -> yuffieSynergyUpOffset
        CAIT_SITH -> caitLimitGaugeOffset
    }
val PartyMember.statBoost13Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAtbChargeOffset
        TIFA_LOCKHART -> tifaOpeningAtbOffset
        BARRET_WALLACE -> barretLimitStaggerOffset
        AERITH_GAINSBOROUGH -> aerithSynergyUpOffset
        RED_XIII -> redBloodsuckerAbilityOffset
        YUFFIE_KISARAGI -> yuffieMpRecoveryOffset
        CAIT_SITH -> caitStaggerSiphonOffset
    }
val PartyMember.statBoost14Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMpRecoveryOffset
        TIFA_LOCKHART -> tifaOpeningBonusOffset
        BARRET_WALLACE -> barretLimitChargeOffset
        AERITH_GAINSBOROUGH -> aerithMpRecoveryOffset
        RED_XIII -> redSiphonFangOffset
        YUFFIE_KISARAGI -> yuffieOpeningAtbOffset
        CAIT_SITH -> caitOpeningAtbOffset
    }
val PartyMember.statBoost15Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudOpeningAtbOffset
        TIFA_LOCKHART -> tifaReprieveAbilityOffset
        BARRET_WALLACE -> barretPhysicalSafeguardOffset
        AERITH_GAINSBOROUGH -> aerithTradeOffOffset
        RED_XIII -> redVengefulGuardianOffset
        YUFFIE_KISARAGI -> yuffieAtbLimitOffset
        CAIT_SITH -> caitReprieveAbilityOffset
    }
val PartyMember.statBoost16Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAtbLimitOffset
        TIFA_LOCKHART -> tifaConcentrationAbilityOffset
        BARRET_WALLACE -> barretRegenerationAbilityOffset
        AERITH_GAINSBOROUGH -> aerithMpLimitOffset
        RED_XIII -> redEnduringVengeanceOffset
        YUFFIE_KISARAGI -> yuffieMasterThiefOffset
        CAIT_SITH -> caitLuckyJockeyOffset
    }
val PartyMember.statBoost17Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudFormidableCounterOffset
        TIFA_LOCKHART -> tifaMartialMasteryOffset
        BARRET_WALLACE -> barretOverloadOverchargeOffset
        AERITH_GAINSBOROUGH -> aerithSpiritualHarvestOffset
        RED_XIII -> redInvigoratingVengeanceOffset
        YUFFIE_KISARAGI -> yuffieFaithfulThiefOffset
        CAIT_SITH -> caitMoogleStartOffset
    }
val PartyMember.statBoost18Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudPowerfulPunisherOffset
        TIFA_LOCKHART -> tifaUtterlyUnbridledOffset
        BARRET_WALLACE -> barretMassiveRechargeOffset
        AERITH_GAINSBOROUGH -> aerithFleetingFamiliarOffset
        RED_XIII -> redVengefulRevenantOffset
        YUFFIE_KISARAGI -> yuffiePrecisionDefenseOffset
        CAIT_SITH -> caitMoogleVanguardOffset
    }
val PartyMember.statBoost19Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudStalwartPunisherOffset
        TIFA_LOCKHART -> tifaSteadfastConcentrationOffset
        BARRET_WALLACE -> barretStaggeringChargeOffset
        AERITH_GAINSBOROUGH -> aerithEnduringWardOffset
        RED_XIII -> redEnhancedCounterspinOffset
        YUFFIE_KISARAGI -> yuffiePrecisionAtbOffset
        CAIT_SITH -> caitMoogleSentinelOffset
    }
val PartyMember.limitBreakOffset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudFinishingTouchOffset
        TIFA_LOCKHART -> tifaMeteoStrikesOffset
        BARRET_WALLACE -> barretSatelliteBeamOffset
        AERITH_GAINSBOROUGH -> aerithRisingFuryOffset
        RED_XIII -> redWrathLandOffset
        YUFFIE_KISARAGI -> yuffieDevastationAbilityOffset
        CAIT_SITH -> caitGigaMogboxOffset
    }
val PartyMember.characterAbility01Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAerialOnslaughtOffset
        TIFA_LOCKHART -> tifaTrinityStrikeOffset
        BARRET_WALLACE -> barretLifebloodCannonOffset
        AERITH_GAINSBOROUGH -> aerithTranscendenceAbilityOffset
        RED_XIII -> redRetaliationAbilityOffset
        YUFFIE_KISARAGI -> yuffieStormsFuryOffset
        CAIT_SITH -> caitLuckySlotsOffset
    }
val PartyMember.characterAbility02Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudWildfireAbilityOffset
        TIFA_LOCKHART -> tifaFieryImpulseOffset
        BARRET_WALLACE -> barretFieryImpulseOffset
        AERITH_GAINSBOROUGH -> aerithHeatwaveAbilityOffset
        RED_XIII -> redWildfireAbilityOffset
        YUFFIE_KISARAGI -> yuffieWildfireAbilityOffset
        CAIT_SITH -> caitHeatwaveAbilityOffset
    }
val PartyMember.characterAbility03Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudSnowFlurryOffset
        TIFA_LOCKHART -> tifaIcyImpulseOffset
        BARRET_WALLACE -> barretIcyImpulseOffset
        AERITH_GAINSBOROUGH -> aerithColdFrontOffset
        RED_XIII -> redSnowFlurryOffset
        YUFFIE_KISARAGI -> yuffieSnowFlurryOffset
        CAIT_SITH -> caitColdFrontOffset
    }
val PartyMember.characterAbility04Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudStaticShockOffset
        TIFA_LOCKHART -> tifaElectricImpulseOffset
        BARRET_WALLACE -> barretElectricImpulseOffset
        AERITH_GAINSBOROUGH -> aerithRollingThunderOffset
        RED_XIII -> redStaticShockOffset
        YUFFIE_KISARAGI -> yuffieStaticShockOffset
        CAIT_SITH -> caitRollingThunderOffset
    }
val PartyMember.characterAbility05Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudWindCurrentOffset
        TIFA_LOCKHART -> tifaGaleImpulseOffset
        BARRET_WALLACE -> barretGaleImpulseOffset
        AERITH_GAINSBOROUGH -> aerithJetStreamOffset
        RED_XIII -> redWindCurrentOffset
        YUFFIE_KISARAGI -> yuffieWindCurrentOffset
        CAIT_SITH -> caitJetStreamOffset
    }
val PartyMember.synergySkill01Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudCounterfireAbilityOffset
        TIFA_LOCKHART -> tifaSlipSlideOffset
        BARRET_WALLACE -> barretMadDashOffset
        AERITH_GAINSBOROUGH -> aerithCombatSaviorOffset
        RED_XIII -> redPhantomFangOffset
        YUFFIE_KISARAGI -> yuffieShurikenSyncOffset
        CAIT_SITH -> caitAlloutAssaultOffset
    }
val PartyMember.synergySkill02Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMeleeBladeOffset
        TIFA_LOCKHART -> tifaLeapingStrikesOffset
        BARRET_WALLACE -> barretIronDefenseOffset
        AERITH_GAINSBOROUGH -> aerithBodyguardAbilityOffset
        RED_XIII -> redWildChargeOffset
        YUFFIE_KISARAGI -> yuffieNinjaBazookaOffset
        CAIT_SITH -> caitMagicMegaphoneOffset
    }
val PartyMember.synergySkill03Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudRangedBladeOffset
        TIFA_LOCKHART -> tifaBodyguardAbilityOffset
        BARRET_WALLACE -> barretFriendlyFireOffset
        AERITH_GAINSBOROUGH -> aerithSpellboundBlastOffset
        RED_XIII -> redIronDefenseOffset
        YUFFIE_KISARAGI -> yuffieFoxflameAbilityOffset
        CAIT_SITH -> caitBodyguardAbilityOffset
    }
val PartyMember.synergyAbility01Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudPartnersPainOffset
        TIFA_LOCKHART -> tifaSynchroCycloneOffset
        BARRET_WALLACE -> barretUnitedCloudOffset
        AERITH_GAINSBOROUGH -> aerithUnitedCloudOffset
        RED_XIII -> redSavageAssaultOffset
        YUFFIE_KISARAGI -> yuffieHalcyonDescentOffset
        CAIT_SITH -> caitSoldierMoogleOffset
    }
val PartyMember.synergyAbility02Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudUnitedRefocusOffset
        TIFA_LOCKHART -> tifaUnitedBarretOffset
        BARRET_WALLACE -> barretAvalancheTwostepOffset
        AERITH_GAINSBOROUGH -> aerithSweetSourOffset
        RED_XIII -> redOverfangAbilityOffset
        YUFFIE_KISARAGI -> yuffieUnitedBarretOffset
        CAIT_SITH -> caitMayhemRoundOffset
    }
val PartyMember.synergyAbility03Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudRelentlessRushOffset
        TIFA_LOCKHART -> tifaUnitedAerithOffset
        BARRET_WALLACE -> barretArcaneBlastOffset
        AERITH_GAINSBOROUGH -> aerithDivinePunishmentOffset
        RED_XIII -> redCallWildOffset
        YUFFIE_KISARAGI -> yuffieCyclonicKickOffset
        CAIT_SITH -> caitUnitedTifaOffset
    }
val PartyMember.synergyAbility04Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudFireworkBladeOffset
        TIFA_LOCKHART -> tifaBestialBarrageOffset
        BARRET_WALLACE -> barretUnitedRedOffset
        AERITH_GAINSBOROUGH -> aerithPlanetaryRoarOffset
        RED_XIII -> redRingmasterAbilityOffset
        YUFFIE_KISARAGI -> yuffieMysticMultiplicationOffset
        CAIT_SITH -> caitMegaMoogleOffset
    }
val PartyMember.synergyAbility05Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMaelstromStrikeOffset
        TIFA_LOCKHART -> tifaUnitedYuffieOffset
        BARRET_WALLACE -> barretNinjaCarbineOffset
        AERITH_GAINSBOROUGH -> aerithUnitedYuffieOffset
        RED_XIII -> redHackSlashOffset
        YUFFIE_KISARAGI -> yuffieUnitedRedOffset
        CAIT_SITH -> caitMognificentShotOffset
    }
val PartyMember.synergyAbility06Offset: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudCuriosityEndOffset
        TIFA_LOCKHART -> tifaMoogleShotOffset
        BARRET_WALLACE -> barretPurrfectShotOffset
        AERITH_GAINSBOROUGH -> aerithKittyCannonadeOffset
        RED_XIII -> redFelineFuryOffset
        YUFFIE_KISARAGI -> yuffieMooglePinwheelOffset
        CAIT_SITH -> caitUnitedYuffieOffset
    }
val PartyMember.statBoost01Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudHpUpBit
        TIFA_LOCKHART -> tifaMaxHpBit
        BARRET_WALLACE -> barretHpUpBit
        AERITH_GAINSBOROUGH -> aerithMpUpBit
        RED_XIII -> redHpUpBit
        YUFFIE_KISARAGI -> yuffieMaxHpBit
        CAIT_SITH -> caitMaxMpBit
    }
val PartyMember.statBoost02Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMaxHpBit
        TIFA_LOCKHART -> tifaMaxMpBit
        BARRET_WALLACE -> barretMaxHpBit
        AERITH_GAINSBOROUGH -> aerithMaxMpBit
        RED_XIII -> redUpHpBit
        YUFFIE_KISARAGI -> yuffieMaxMpBit
        CAIT_SITH -> caitMaxHpBit
    }
val PartyMember.statBoost03Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMaxMpBit
        TIFA_LOCKHART -> tifaCriticalHitBit
        BARRET_WALLACE -> barretUpHpBit
        AERITH_GAINSBOROUGH -> aerithMaxHpBit
        RED_XIII -> redMaxHpBit
        YUFFIE_KISARAGI -> yuffieLuckUpBit
        CAIT_SITH -> caitLuckUpBit
    }
val PartyMember.statBoost04Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudWeaponDamageBit
        TIFA_LOCKHART -> tifaCriticalRateBit
        BARRET_WALLACE -> barretMaxMpBit
        AERITH_GAINSBOROUGH -> aerithMatkUpBit
        RED_XIII -> redMpUpBit
        YUFFIE_KISARAGI -> yuffieElementalDamageBit
        CAIT_SITH -> caitCriticalHitBit
    }
val PartyMember.statBoost05Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudEnhancedLimitBit
        TIFA_LOCKHART -> tifaWeaponDamageBit
        BARRET_WALLACE -> barretDefUpBit
        AERITH_GAINSBOROUGH -> aerithMdefUpBit
        RED_XIII -> redMaxMpBit
        YUFFIE_KISARAGI -> yuffieElementalUpBit
        CAIT_SITH -> caitCriticalDamageBit
    }
val PartyMember.statBoost06Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudStaggerUpBit
        TIFA_LOCKHART -> tifaEnhancedLimitBit
        BARRET_WALLACE -> barretWeaponDamageBit
        AERITH_GAINSBOROUGH -> aerithElementalDamageBit
        RED_XIII -> redMdefUpBit
        YUFFIE_KISARAGI -> yuffieEnhancedAttackBit
        CAIT_SITH -> caitWeaponDamageBit
    }
val PartyMember.statBoost07Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAttackUpBit
        TIFA_LOCKHART -> tifaComboDamageBit
        BARRET_WALLACE -> barretEnhancedOverchargeBit
        AERITH_GAINSBOROUGH -> aerithEnhancedTempestBit
        RED_XIII -> redSpeedUpBit
        YUFFIE_KISARAGI -> yuffieHuntersPrecisionBit
        CAIT_SITH -> caitEnhancedLimitBit
    }
val PartyMember.statBoost08Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudEnhancedAttackBit
        TIFA_LOCKHART -> tifaEnhancedTechniquesBit
        BARRET_WALLACE -> barretSelfishRecoveryBit
        AERITH_GAINSBOROUGH -> aerithFullpowerMagicBit
        RED_XIII -> redSelfishBoostBit
        YUFFIE_KISARAGI -> yuffieEnhancedGuardBit
        CAIT_SITH -> caitEnhancedGuardBit
    }
val PartyMember.statBoost09Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudEnhancedGuardBit
        TIFA_LOCKHART -> tifaWeaponRecoveryBit
        BARRET_WALLACE -> barretSelfishBoostBit
        AERITH_GAINSBOROUGH -> aerithAltruisticBoostBit
        RED_XIII -> redElementalDefenseBit
        YUFFIE_KISARAGI -> yuffieAfflictedDebuffBit
        CAIT_SITH -> caitElementalDefenseBit
    }
val PartyMember.statBoost10Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudSynergyDamageBit
        TIFA_LOCKHART -> tifaLimitStaggerBit
        BARRET_WALLACE -> barretEnhancedGuardBit
        AERITH_GAINSBOROUGH -> aerithEnhancedMagicBit
        RED_XIII -> redAfflictedDebuffBit
        YUFFIE_KISARAGI -> yuffieWeaponAtbBit
        CAIT_SITH -> caitAtbChargeBit
    }
val PartyMember.statBoost11Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudLimitGuardBit
        TIFA_LOCKHART -> tifaAtbChargeBit
        BARRET_WALLACE -> barretBuffUpBit
        AERITH_GAINSBOROUGH -> aerithDebuffExtensionBit
        RED_XIII -> redLimitGuardBit
        YUFFIE_KISARAGI -> yuffieSynergyDamageBit
        CAIT_SITH -> caitMpRecoveryBit
    }
val PartyMember.statBoost12Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudLimitStaggerBit
        TIFA_LOCKHART -> tifaMpRecoveryBit
        BARRET_WALLACE -> barretSynergyDamageBit
        AERITH_GAINSBOROUGH -> aerithSynergyDamageBit
        RED_XIII -> redMpRecoveryBit
        YUFFIE_KISARAGI -> yuffieSynergyUpBit
        CAIT_SITH -> caitLimitGaugeBit
    }
val PartyMember.statBoost13Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAtbChargeBit
        TIFA_LOCKHART -> tifaOpeningAtbBit
        BARRET_WALLACE -> barretLimitStaggerBit
        AERITH_GAINSBOROUGH -> aerithSynergyUpBit
        RED_XIII -> redBloodsuckerAbilityBit
        YUFFIE_KISARAGI -> yuffieMpRecoveryBit
        CAIT_SITH -> caitStaggerSiphonBit
    }
val PartyMember.statBoost14Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMpRecoveryBit
        TIFA_LOCKHART -> tifaOpeningBonusBit
        BARRET_WALLACE -> barretLimitChargeBit
        AERITH_GAINSBOROUGH -> aerithMpRecoveryBit
        RED_XIII -> redSiphonFangBit
        YUFFIE_KISARAGI -> yuffieOpeningAtbBit
        CAIT_SITH -> caitOpeningAtbBit
    }
val PartyMember.statBoost15Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudOpeningAtbBit
        TIFA_LOCKHART -> tifaReprieveAbilityBit
        BARRET_WALLACE -> barretPhysicalSafeguardBit
        AERITH_GAINSBOROUGH -> aerithTradeOffBit
        RED_XIII -> redVengefulGuardianBit
        YUFFIE_KISARAGI -> yuffieAtbLimitBit
        CAIT_SITH -> caitReprieveAbilityBit
    }
val PartyMember.statBoost16Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAtbLimitBit
        TIFA_LOCKHART -> tifaConcentrationAbilityBit
        BARRET_WALLACE -> barretRegenerationAbilityBit
        AERITH_GAINSBOROUGH -> aerithMpLimitBit
        RED_XIII -> redEnduringVengeanceBit
        YUFFIE_KISARAGI -> yuffieMasterThiefBit
        CAIT_SITH -> caitLuckyJockeyBit
    }
val PartyMember.statBoost17Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudFormidableCounterBit
        TIFA_LOCKHART -> tifaMartialMasteryBit
        BARRET_WALLACE -> barretOverloadOverchargeBit
        AERITH_GAINSBOROUGH -> aerithSpiritualHarvestBit
        RED_XIII -> redInvigoratingVengeanceBit
        YUFFIE_KISARAGI -> yuffieFaithfulThiefBit
        CAIT_SITH -> caitMoogleStartBit
    }
val PartyMember.statBoost18Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudPowerfulPunisherBit
        TIFA_LOCKHART -> tifaUtterlyUnbridledBit
        BARRET_WALLACE -> barretMassiveRechargeBit
        AERITH_GAINSBOROUGH -> aerithFleetingFamiliarBit
        RED_XIII -> redVengefulRevenantBit
        YUFFIE_KISARAGI -> yuffiePrecisionDefenseBit
        CAIT_SITH -> caitMoogleVanguardBit
    }
val PartyMember.statBoost19Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudStalwartPunisherBit
        TIFA_LOCKHART -> tifaSteadfastConcentrationBit
        BARRET_WALLACE -> barretStaggeringChargeBit
        AERITH_GAINSBOROUGH -> aerithEnduringWardBit
        RED_XIII -> redEnhancedCounterspinBit
        YUFFIE_KISARAGI -> yuffiePrecisionAtbBit
        CAIT_SITH -> caitMoogleSentinelBit
    }
val PartyMember.limitBreakBit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudFinishingTouchBit
        TIFA_LOCKHART -> tifaMeteoStrikesBit
        BARRET_WALLACE -> barretSatelliteBeamBit
        AERITH_GAINSBOROUGH -> aerithRisingFuryBit
        RED_XIII -> redWrathLandBit
        YUFFIE_KISARAGI -> yuffieDevastationAbilityBit
        CAIT_SITH -> caitGigaMogboxBit
    }
val PartyMember.characterAbility01Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudAerialOnslaughtBit
        TIFA_LOCKHART -> tifaTrinityStrikeBit
        BARRET_WALLACE -> barretLifebloodCannonBit
        AERITH_GAINSBOROUGH -> aerithTranscendenceAbilityBit
        RED_XIII -> redRetaliationAbilityBit
        YUFFIE_KISARAGI -> yuffieStormsFuryBit
        CAIT_SITH -> caitLuckySlotsBit
    }
val PartyMember.characterAbility02Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudWildfireAbilityBit
        TIFA_LOCKHART -> tifaFieryImpulseBit
        BARRET_WALLACE -> barretFieryImpulseBit
        AERITH_GAINSBOROUGH -> aerithHeatwaveAbilityBit
        RED_XIII -> redWildfireAbilityBit
        YUFFIE_KISARAGI -> yuffieWildfireAbilityBit
        CAIT_SITH -> caitHeatwaveAbilityBit
    }
val PartyMember.characterAbility03Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudSnowFlurryBit
        TIFA_LOCKHART -> tifaIcyImpulseBit
        BARRET_WALLACE -> barretIcyImpulseBit
        AERITH_GAINSBOROUGH -> aerithColdFrontBit
        RED_XIII -> redSnowFlurryBit
        YUFFIE_KISARAGI -> yuffieSnowFlurryBit
        CAIT_SITH -> caitColdFrontBit
    }
val PartyMember.characterAbility04Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudStaticShockBit
        TIFA_LOCKHART -> tifaElectricImpulseBit
        BARRET_WALLACE -> barretElectricImpulseBit
        AERITH_GAINSBOROUGH -> aerithRollingThunderBit
        RED_XIII -> redStaticShockBit
        YUFFIE_KISARAGI -> yuffieStaticShockBit
        CAIT_SITH -> caitRollingThunderBit
    }
val PartyMember.characterAbility05Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudWindCurrentBit
        TIFA_LOCKHART -> tifaGaleImpulseBit
        BARRET_WALLACE -> barretGaleImpulseBit
        AERITH_GAINSBOROUGH -> aerithJetStreamBit
        RED_XIII -> redWindCurrentBit
        YUFFIE_KISARAGI -> yuffieWindCurrentBit
        CAIT_SITH -> caitJetStreamBit
    }
val PartyMember.synergySkill01Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudCounterfireAbilityBit
        TIFA_LOCKHART -> tifaSlipSlideBit
        BARRET_WALLACE -> barretMadDashBit
        AERITH_GAINSBOROUGH -> aerithCombatSaviorBit
        RED_XIII -> redPhantomFangBit
        YUFFIE_KISARAGI -> yuffieShurikenSyncBit
        CAIT_SITH -> caitAlloutAssaultBit
    }
val PartyMember.synergySkill02Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMeleeBladeBit
        TIFA_LOCKHART -> tifaLeapingStrikesBit
        BARRET_WALLACE -> barretIronDefenseBit
        AERITH_GAINSBOROUGH -> aerithBodyguardAbilityBit
        RED_XIII -> redWildChargeBit
        YUFFIE_KISARAGI -> yuffieNinjaBazookaBit
        CAIT_SITH -> caitMagicMegaphoneBit
    }
val PartyMember.synergySkill03Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudRangedBladeBit
        TIFA_LOCKHART -> tifaBodyguardAbilityBit
        BARRET_WALLACE -> barretFriendlyFireBit
        AERITH_GAINSBOROUGH -> aerithSpellboundBlastBit
        RED_XIII -> redIronDefenseBit
        YUFFIE_KISARAGI -> yuffieFoxflameAbilityBit
        CAIT_SITH -> caitBodyguardAbilityBit
    }
val PartyMember.synergyAbility01Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudPartnersPainBit
        TIFA_LOCKHART -> tifaSynchroCycloneBit
        BARRET_WALLACE -> barretUnitedCloudBit
        AERITH_GAINSBOROUGH -> aerithUnitedCloudBit
        RED_XIII -> redSavageAssaultBit
        YUFFIE_KISARAGI -> yuffieHalcyonDescentBit
        CAIT_SITH -> caitSoldierMoogleBit
    }
val PartyMember.synergyAbility02Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudUnitedRefocusBit
        TIFA_LOCKHART -> tifaUnitedBarretBit
        BARRET_WALLACE -> barretAvalancheTwostepBit
        AERITH_GAINSBOROUGH -> aerithSweetSourBit
        RED_XIII -> redOverfangAbilityBit
        YUFFIE_KISARAGI -> yuffieUnitedBarretBit
        CAIT_SITH -> caitMayhemRoundBit
    }
val PartyMember.synergyAbility03Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudRelentlessRushBit
        TIFA_LOCKHART -> tifaUnitedAerithBit
        BARRET_WALLACE -> barretArcaneBlastBit
        AERITH_GAINSBOROUGH -> aerithDivinePunishmentBit
        RED_XIII -> redCallWildBit
        YUFFIE_KISARAGI -> yuffieCyclonicKickBit
        CAIT_SITH -> caitUnitedTifaBit
    }
val PartyMember.synergyAbility04Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudFireworkBladeBit
        TIFA_LOCKHART -> tifaBestialBarrageBit
        BARRET_WALLACE -> barretUnitedRedBit
        AERITH_GAINSBOROUGH -> aerithPlanetaryRoarBit
        RED_XIII -> redRingmasterAbilityBit
        YUFFIE_KISARAGI -> yuffieMysticMultiplicationBit
        CAIT_SITH -> caitMegaMoogleBit
    }
val PartyMember.synergyAbility05Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudMaelstromStrikeBit
        TIFA_LOCKHART -> tifaUnitedYuffieBit
        BARRET_WALLACE -> barretNinjaCarbineBit
        AERITH_GAINSBOROUGH -> aerithUnitedYuffieBit
        RED_XIII -> redHackSlashBit
        YUFFIE_KISARAGI -> yuffieUnitedRedBit
        CAIT_SITH -> caitMognificentShotBit
    }
val PartyMember.synergyAbility06Bit: Int
    get() = when (this) {
        CLOUD_STRIFE -> cloudCuriosityEndBit
        TIFA_LOCKHART -> tifaMoogleShotBit
        BARRET_WALLACE -> barretPurrfectShotBit
        AERITH_GAINSBOROUGH -> aerithKittyCannonadeBit
        RED_XIII -> redFelineFuryBit
        YUFFIE_KISARAGI -> yuffieMooglePinwheelBit
        CAIT_SITH -> caitUnitedYuffieBit
    }

//endregion GENERAL SKILL ABILITY OFFSET

//region WEAPON OFFSET

val busterSwordOffset: Int = 0x3e9
val sleekSaberOffset: Int = 0x3ea
val runeBladeOffset: Int = 0x3eb
val umbralBladeOffset: Int = 0x3ec
val crystalSwordOffset: Int = 0x3ed
val igneousSaberOffset: Int = 0x3ee
val slipstreamSaberOffset: Int = 0x3ef
val gatlingGunOffset: Int = 0x3f0
val hicaliberRifleOffset: Int = 0x3f1
val barrageBlasterOffset: Int = 0x3f2
val vulcanCannonOffset: Int = 0x3f3
val fafnirRifleOffset: Int = 0x3f4
val calamitousBazookaOffset: Int = 0x3f5
val battleCryOffset: Int = 0x3f6
val leatherGlovesOffset: Int = 0x3f7
val sylphGlovesOffset: Int = 0x3f8
val kaiserKnucklesOffset: Int = 0x3f9
val dragonClawsOffset: Int = 0x3fa
val tigerFangsOffset: Int = 0x3fb
val crystalGlovesOffset: Int = 0x3fc
val jarngreiprWeaponOffset: Int = 0x3fd
val guardStickOffset: Int = 0x3fe
val timelessRodOffset: Int = 0x3ff
val empressScepterOffset: Int = 0x400
val wizardsRodOffset: Int = 0x401
val ceremonialStaffOffset: Int = 0x402
val plumoseRodOffset: Int = 0x403
val gambanteinnWeaponOffset: Int = 0x404
val mythrilCollarOffset: Int = 0x405
val renegadesCollarOffset: Int = 0x406
val silverCollarOffset: Int = 0x407
val amethystCollarOffset: Int = 0x408
val goldenCollarOffset: Int = 0x409
val mysticCollarOffset: Int = 0x40a
val brisingamenWeaponOffset: Int = 0x40b
val pointShurikenOffset: Int = 0x40c
val savageDaggerOffset: Int = 0x40d
val twinViperOffset: Int = 0x40e
val birdPreyOffset: Int = 0x40f
val crescentSickleOffset: Int = 0x410
val crystallineCrossOffset: Int = 0x411
val fumaShurikenOffset: Int = 0x412
val yellowMegaphoneOffset: Int = 0x413
val ironMegaphoneOffset: Int = 0x414
val redMegaphoneOffset: Int = 0x415
val resoundingMegaphoneOffset: Int = 0x416
val crystalMegaphoneOffset: Int = 0x417
val goldenMegaphoneOffset: Int = 0x418
val gjallarhornWeaponOffset: Int = 0x419
val masamuneWeaponOffset: Int = 0x41a
val busterZackOffset: Int = 0x41b

//endregion WEAPON OFFSET

//region ITEM TYPE OFFSET

val allTypeOffset: Int = -1
val itemCommonOffset: Int = 0x0
val transmmuterMaterialOffset: Int = 0x1
val keyItemsOffset: Int = 0x2
val memberWeaponOffset: Int = 0x3
val memberArmorOffset: Int = 0x4
val memberAccessoryOffset: Int = 0x5
val materiaItemOffset: Int = 0x6
val tradingTokenOffset: Int = 0x8
val memberOutfitOffset: Int = 0x9
val transmuterChipOffset: Int = 0xa
val folioManuscriptOffset: Int = 0xb
val chocoboGearOffset: Int = 0xc
val qbCardOffset: Int = 0xd
val treasureTroveOffset: Int = 0xe

//endregion ITEM TYPE OFFSET

//region INVENTORY ITEM OFFSET

val gilMoneyDataItemOffset:Int = 0x1
val moogleMedalMinigameTokenOffset:Int = 0x2
val goldenPlumeChocoboTokenOffset:Int = 0x3
val grasslandsAreaDataPointsOffset:Int = 0x4
val junonRegionDataPointsOffset:Int = 0x5
val corelRegionDataPointsOffset:Int = 0x6
val gongagaRegionDataPointsOffset:Int = 0x7
val cosmoRegionDataPointsOffset:Int = 0x8
val nibelRegionDataPointsOffset:Int = 0x9
val meridianOceanDataPointsOffset:Int = 0xa
val goldSaucerAreaPointOffset:Int = 0xb
val potionHpCommonItemOffset:Int = 0x64
val hiPotionCommonItemOffset:Int = 0x65
val megaPotionCommonItemOffset:Int = 0x66
val gigaPotionCommonItemOffset:Int = 0x67
val xPotionCommonItemOffset:Int = 0x68
val mixedPotionCommonItemOffset:Int = 0x69
val mixedHiPotionItemOffset:Int = 0x6a
val mistPotionCommonItemOffset:Int = 0x6b
val mistHiPotionItemOffset:Int = 0x6c
val mistMegaPotionItemOffset:Int = 0x6d
val mistGigaPotionItemOffset:Int = 0x6e
val etherMpCommonItemOffset:Int = 0x6f
val hiEtherCommonItemOffset:Int = 0x70
val dryEtherCommonItemOffset:Int = 0x71
val turboEtherCommonItemOffset:Int = 0x72
val elixirAllCommonItemOffset:Int = 0x73
val phoenixDownCommonItemOffset:Int = 0x74
val phoenixDraftCommonItemOffset:Int = 0x75
val maidensKissCommonItemOffset:Int = 0x76
val antidoteStatusCommonItemOffset:Int = 0x77
val smellingSaltsCommonItemOffset:Int = 0x78
val echoMistCommonItemOffset:Int = 0x79
val goldNeedleCommonItemOffset:Int = 0x7a
val adrenalineStatusCommonItemOffset:Int = 0x7b
val sedativeStatusCommonItemOffset:Int = 0x7c
val remedyStatusCommonItemOffset:Int = 0x7d
val celerisStatusCommonItemOffset:Int = 0x7e
val grenadeAttackUsableItemOffset:Int = 0x7f
val armorPiercingGrenadeItemOffset:Int = 0x80
val hazardousMaterialCommonItemOffset:Int = 0x81
val spiderwebStatusCommonItemOffset:Int = 0x82
val molotovCocktailCommonItemOffset:Int = 0x84
val orbGravityCommonItemOffset:Int = 0x85
val cushionRestCommonItemOffset:Int = 0x89
val sageMaterialTransmmuterItemOffset:Int = 0x12c
val oreganoMaterialTransmmuterItemOffset:Int = 0x12d
val saintLucheLeafMaterialOffset:Int = 0x12e
val pearlGingerRootMaterialOffset:Int = 0x12f
val marjoramMaterialTransmmuterItemOffset:Int = 0x130
val ironOreMaterialTransmmuterOffset:Int = 0x141
val zincOreMaterialTransmmuterOffset:Int = 0x142
val chromiteOreMaterialTransmmuterOffset:Int = 0x143
val leaTitaniumMaterialTransmmuterOffset:Int = 0x144
val tourmalineMaterialTransmmuterItemOffset:Int = 0x145
val amethystMaterialTransmmuterItemOffset:Int = 0x146
val mossAgateMaterialTransmmuterOffset:Int = 0x147
val crimsoniteCrystalMaterialTransmmuterOffset:Int = 0x148
val moonstoneMaterialTransmmuterItemOffset:Int = 0x149
val mythrilOreMaterialTransmmuterOffset:Int = 0x14a
val numinousAshesMaterialTransmmuterOffset:Int = 0x14b
val cosmotiteOreMaterialTransmmuterOffset:Int = 0x14c
val goldDustMaterialTransmmuterOffset:Int = 0x14d
val timberMaterialTransmmuterItemOffset:Int = 0x155
val ancientBarkMaterialTransmmuterOffset:Int = 0x156
val divineHeartwoodMaterialTransmmuterOffset:Int = 0x157
val mellowOakMaterialTransmmuterOffset:Int = 0x158
val condorCedarMaterialTransmmuterOffset:Int = 0x159
val sycamoreWoodMaterialTransmmuterOffset:Int = 0x15a
val gongagaPineMaterialTransmmuterOffset:Int = 0x15b
val baobabWoodMaterialTransmmuterOffset:Int = 0x15c
val ashWoodMaterialTransmmuterOffset:Int = 0x15d
val laurelMaterialTransmmuterItemOffset:Int = 0x15e
val mistSeedsMaterialTransmmuterOffset:Int = 0x15f
val beastPeltMaterialTransmmuterOffset:Int = 0x169
val exquisiteBeastHideMaterialOffset:Int = 0x16a
val beastBoneMaterialTransmmuterOffset:Int = 0x17d
val exquisiteBeastSpineMaterialOffset:Int = 0x17e
val planetsBlessingMaterialTransmmuterOffset:Int = 0x191
val planetsFavorMaterialTransmmuterOffset:Int = 0x192
val planetsBenisonMaterialTransmmuterOffset:Int = 0x193
val planetsSplendorMaterialTransmmuterOffset:Int = 0x194
val etherOnionMaterialTransmmuterOffset:Int = 0x195
val planetsMercyMaterialTransmmuterOffset:Int = 0x196
val planetsSpiritMaterialTransmmuterOffset:Int = 0x197
val rubyMaterialTransmmuterItemOffset:Int = 0x1a5
val emeraldMaterialTransmmuterItemOffset:Int = 0x1a6
val sapphireMaterialTransmmuterItemOffset:Int = 0x1a7
val beastTalonMaterialTransmmuterOffset:Int = 0x1af
val astralRemnantMaterialTransmmuterOffset:Int = 0x1b0
val slimyMalboroTendrilTransmmuterOffset:Int = 0x1b1
val heavyJabberwockHornTransmmuterOffset:Int = 0x1b2
val argentKingZuFeatherOffset:Int = 0x1b3
val quetzalcoatlTalonMaterialTransmmuterOffset:Int = 0x1eb
val mindflayerCrownMaterialTransmmuterOffset:Int = 0x1ec
val tonberryKingsRobeTransmmuterOffset:Int = 0x1ed
val greatMalboroTendrilTransmmuterOffset:Int = 0x1ee
val jabberwockHornMaterialTransmmuterOffset:Int = 0x1ef
val kingZuFeatherTransmmuterOffset:Int = 0x1f0
val sinisterQuetzalcoatlTalonTransmmuterOffset:Int = 0x1f1
val vileMindlayerCrownTransmmuterOffset:Int = 0x1f2
val tonberryKingsWretchedRobeOffset:Int = 0x1f3
val goldTalonMaterialTransmmuterOffset:Int = 0x1f4
val burnishedCrownMaterialTransmmuterOffset:Int = 0x1f5
val resplendentRobeMaterialTransmmuterOffset:Int = 0x1f6
val gildedTentacleMaterialTransmmuterOffset:Int = 0x1f7
val aureateHornMaterialTransmmuterOffset:Int = 0x1f8
val lustrousFeatherMaterialTransmmuterOffset:Int = 0x1f9
val darkMatterMaterialTransmmuterOffset:Int = 0x1fa
val pirateRelicAlphaTransmmuterOffset:Int = 0x1fb
val pirateRelicBetaTransmmuterOffset:Int = 0x1fc
val pirateRelicGammaTransmmuterOffset:Int = 0x1fd
val pirateRelicDeltaTransmmuterOffset:Int = 0x1fe
val pirateJetsamMaterialTransmmuterOffset:Int = 0x1ff
val metalBracerMemberArmorOffset:Int = 0x7d0
val leatherBangleMemberArmorOffset:Int = 0x7d1
val copperBracerMemberArmorOffset:Int = 0x7d4
val huntersBangleMemberArmorOffset:Int = 0x7d5
val boneBraceletMemberArmorOffset:Int = 0x7d6
val woodspriteArmletMemberArmorOffset:Int = 0x7d7
val enhancedCopperBracerArmorOffset:Int = 0x7d8
val enhancedHuntersBangleArmorOffset:Int = 0x7d9
val enhancedBoneBraceletArmorOffset:Int = 0x7da
val enhancedWoodspriteArmletArmorOffset:Int = 0x7db
val owlBracerMemberArmorOffset:Int = 0x7dd
val beastmanArmbandMemberArmorOffset:Int = 0x7de
val sailorsBracerMemberArmorOffset:Int = 0x7e4
val elphadunkBangleMemberArmorOffset:Int = 0x7e5
val wisefoxBraceletMemberArmorOffset:Int = 0x7e6
val goldCoralArmletArmorOffset:Int = 0x7e7
val enhancedSailorsBracerArmorOffset:Int = 0x7e8
val enhancedElphadunkBangleArmorOffset:Int = 0x7e9
val enhancedWisefoxBraceletArmorOffset:Int = 0x7ea
val enhancedGoldCoralArmletOffset:Int = 0x7eb
val queensguardBangleMemberArmorOffset:Int = 0x7ed
val warmagesArmbandMemberArmorOffset:Int = 0x7ee
val fortressBracerMemberArmorOffset:Int = 0x7f4
val abyssalBangleMemberArmorOffset:Int = 0x7f5
val oldebeastBraceletMemberArmorOffset:Int = 0x7f6
val beguilingArmletMemberArmorOffset:Int = 0x7f7
val enhancedFortressBracerArmorOffset:Int = 0x7f8
val enhancedAbyssalBangleArmorOffset:Int = 0x7f9
val enhancedOldebeastBraceletArmorOffset:Int = 0x7fa
val enhancedBeguilingArmletArmorOffset:Int = 0x7fb
val swallowsongBracerMemberArmorOffset:Int = 0x7fe
val illusionistsArmbandMemberArmorOffset:Int = 0x7ff
val crucibleBracerMemberArmorOffset:Int = 0x804
val outlawBangleMemberArmorOffset:Int = 0x805
val crocodileBraceletMemberArmorOffset:Int = 0x806
val witchsArmletMemberArmorOffset:Int = 0x807
val enhancedCrucibleBracerArmorOffset:Int = 0x808
val enhancedOutlawBangleArmorOffset:Int = 0x809
val enhancedCrocodileBraceletArmorOffset:Int = 0x80a
val enhancedWitchsArmletArmorOffset:Int = 0x80b
val sageArmbandMemberArmorOffset:Int = 0x80c
val bigHornBraceletArmorOffset:Int = 0x80d
val commandersBracerMemberArmorOffset:Int = 0x814
val roadWarriorBangleArmorOffset:Int = 0x815
val snailshellBraceletMemberArmorOffset:Int = 0x816
val spirithoundArmletMemberArmorOffset:Int = 0x817
val enhancedCommandersBracerArmorOffset:Int = 0x818
val enhancedRoadWarriorBangleOffset:Int = 0x819
val enhancedSnailshellBraceletArmorOffset:Int = 0x81a
val enhancedSpirithoundArmletArmorOffset:Int = 0x81b
val backboneBraceletMemberArmorOffset:Int = 0x81d
val celestialBangleMemberArmorOffset:Int = 0x81e
val resplendentBracerMemberArmorOffset:Int = 0x824
val garmBangleMemberArmorOffset:Int = 0x825
val varvadosBraceletMemberArmorOffset:Int = 0x826
val yggdrasilArmletMemberArmorOffset:Int = 0x827
val enhancedResplendentBracerArmorOffset:Int = 0x828
val enhancedGarmBangleArmorOffset:Int = 0x829
val enhancedVarvadosBraceletArmorOffset:Int = 0x82a
val enhancedYggdrasilArmletArmorOffset:Int = 0x82b
val valkyrianBangleMemberArmorOffset:Int = 0x82d
val hadesArmletMemberArmorOffset:Int = 0x82e
val cetranBracerMemberArmorOffset:Int = 0x834
val cetranBangleMemberArmorOffset:Int = 0x835
val cetranArmbandMemberArmorOffset:Int = 0x836
val cetranArmletMemberArmorOffset:Int = 0x837
val chocoboArmbandMemberArmorOffset:Int = 0x838
val midgarBangleMkIiOffset:Int = 0x839
val orchidBraceletMemberArmorOffset:Int = 0x83a
val shinraBangleMkIiOffset:Int = 0x83b
val itemTransmuterKeyItemOffset:Int = 0xbb9
val chadModuleKeyItemOffset:Int = 0xbba
val itemChocowhistleKeyItemOffset:Int = 0xbbb
val majesticGlamourMemberOutfitOffset:Int = 0xbbc
val shiningSpiritMemberOutfitOffset:Int = 0xbbd
val pinkMermaidMemberOutfitOffset:Int = 0xbbe
val oceanChocoboMemberOutfitOffset:Int = 0xbbf
val wildSurfMemberOutfitOffset:Int = 0xbc0
val floralDelightMemberOutfitOffset:Int = 0xbc1
val rentBirdMembershipKeyOffset:Int = 0xbc2
val companionCardForCloudOffset:Int = 0xbc3
val companionCardForAerithOffset:Int = 0xbc4
val companionCardForTifaOffset:Int = 0xbc5
val ticketDelAmor7Offset:Int = 0xbc6
val ticketDelAmor77Offset:Int = 0xbc7
val gysahlGreensKeyItemOffset:Int = 0xbcc
val grapplingHookKeyItemOffset:Int = 0xbcd
val sylkisGreensKeyItemOffset:Int = 0xbce
val cliffSideKeyItemOffset:Int = 0xbcf
val grapplingGunKeyItemOffset:Int = 0xbd0
val cloudStrigeFolioItemOffset:Int = 0xbd1
val barretWallaceFolioItemOffset:Int = 0xbd2
val tifaLockhartFolioItemOffset:Int = 0xbd3
val aerithGainsboroughFolioItemOffset:Int = 0xbd4
val redXiiiFolioItemOffset:Int = 0xbd5
val yuffieKisaragiFolioItemOffset:Int = 0xbd6
val caitSithFolioItemOffset:Int = 0xbd7
val storeHouseKeyItemOffset:Int = 0xbd8
val shinra8TournamentTrophyOffset:Int = 0xbd9
val summerOrangeMemberOutfitOffset:Int = 0xbda
val goldenPassportKeyItemOffset:Int = 0xbdb
val murasakiEmployeeIdCardOffset:Int = 0xbdc
val unknownKeyItem01Offset:Int = 0xbe0
val unknownKeyItem02Offset:Int = 0xbe1
val refurbishmentMaterialKeyItemOffset:Int = 0xbe2
val boilerValveKeyItemOffset:Int = 0xbe3
val marredCrownKeyItemOffset:Int = 0xbe4
val uvaFlashlightKeyItemOffset:Int = 0xbe5
val birdTrapKeyItemOffset:Int = 0xbe6
val conchShellKeyItemOffset:Int = 0xbe7
val scallopShellKeyItemOffset:Int = 0xbe8
val gigantopodShellKeyItemOffset:Int = 0xbe9
val pristineCrownKeyItemOffset:Int = 0xbea
val premiumTicketKeyItemOffset:Int = 0xbeb
val keyOffLimitsBeachOffset:Int = 0xbec
val legendaryBaitKeyItemOffset:Int = 0xbed
val junonNavalUniformOutfitOffset:Int = 0xbee
val caperCompassKeyItemOffset:Int = 0xbef
val tropicalMeatKeyItemOffset:Int = 0xbf0
val caperCameraKeyItemOffset:Int = 0xbf1
val courtJesterMemberOutfitOffset:Int = 0xbf2
val hellHoundMemberOutfitOffset:Int = 0xbf3
val chocoGrassKeyItemOffset:Int = 0xbf4
val mainwrightsNoteKeyItemOffset:Int = 0xbf5
val driedDriftwoodKeyItemOffset:Int = 0xbf6
val carriageWheelKeyItemOffset:Int = 0xbf7
val carriageBedKeyItemOffset:Int = 0xbf8
val carriageBraceKeyItemOffset:Int = 0xbf9
val peculiarGreensKeyItemOffset:Int = 0xbfa
val monsterFleshKeyItemOffset:Int = 0xbfb
val bovineMeatKeyItemOffset:Int = 0xbfc
val ransomNoteKeyItemOffset:Int = 0xbfd
val storageShedKeyItemOffset:Int = 0xbfe
val draconiteMapKeyItemOffset:Int = 0xbff
val draconiteOreKeyItemOffset:Int = 0xc00
val torgansVegetablesKeyItemOffset:Int = 0xc01
val plumpMagongaMushroomKeyOffset:Int = 0xc02
val pureGongagaRockSaltOffset:Int = 0xc03
val feedClangerKeyItemOffset:Int = 0xc04
val cissneisBinocularsKeyItemOffset:Int = 0xc05
val instantCameraKeyItemOffset:Int = 0xc06
val celestioGraphKeyItemOffset:Int = 0xc0a
val phenomenaReportsKeyItemOffset:Int = 0xc0b
val celestialPhenomenaChocoboKeyOffset:Int = 0xc0c
val celestialPhenomenaMoogleKeyOffset:Int = 0xc0d
val celestialPhenomenaBahamutKeyOffset:Int = 0xc0e
val photographOfAerithPrayingOffset:Int = 0xc0f
val photographOfCloudAerithOffset:Int = 0xc10
val makoMeterKeyItemOffset:Int = 0xc11
val firstLifespringFieldReportOffset:Int = 0xc12
val secondLifespringFieldReportOffset:Int = 0xc13
val fourthLifespringFieldReportOffset:Int = 0xc14
val fifthLifespringFieldReportOffset:Int = 0xc15
val sixthLifespringFieldReportOffset:Int = 0xc16
val vibroDetectorKeyItemOffset:Int = 0xc17
val catFoodKeyItemOffset:Int = 0xc18
val sheetMusicOurWayOffset:Int = 0xc19
val sheetMusicTifaThemeOffset:Int = 0xc1a
val sheetMusicBarretThemeOffset:Int = 0xc1b
val sheetMusicCincoChocoboOffset:Int = 0xc1c
val securityCardKeyItemOffset:Int = 0xc1d
val upaChallengeKeyItemOffset:Int = 0xc1e
val rhondasMoneyKeyItemOffset:Int = 0xc1f
val blurryCondorPhotographKeyOffset:Int = 0xc20
val niceCondorPhotographKeyOffset:Int = 0xc21
val wellComposedCondorPhotographOffset:Int = 0xc22
val sheetMusicTwoLegsOffset:Int = 0xc23
val sheetMusicAerithThemeOffset:Int = 0xc24
val sheetMusicBattlesBeginOffset:Int = 0xc25
val swindlerChallengeKeyItemOffset:Int = 0xc26
val birdhouseLocationsKeyItemOffset:Int = 0xc27
val buggyKeyFobItemOffset:Int = 0xc28
val photographOfAerithSmilingOffset:Int = 0xc29
val photographOfAerithBeamingOffset:Int = 0xc2a
val photographOfAerithGlaringOffset:Int = 0xc2b
val loveliestOfLadiesKeyOffset:Int = 0xc2c
val celestialPhenomenaChocobo01Offset:Int = 0xc2d
val celestialPhenomenaChocobo02Offset:Int = 0xc2e
val celestialPhenomenaMoogle01Offset:Int = 0xc2f
val celestialPhenomenaMoogle02Offset:Int = 0xc30
val celestialPhenomenaBahamut01Offset:Int = 0xc31
val celestialPhenomenaBahamut02Offset:Int = 0xc32
val resolveKeyItem01Offset:Int = 0xc3a
val resolveKeyItem02Offset:Int = 0xc3b
val resolveKeyItem03Offset:Int = 0xc3c
val sufferingKeyItem01Offset:Int = 0xc3d
val sufferingKeyItem02Offset:Int = 0xc3e
val sufferingKeyItem03Offset:Int = 0xc3f
val odysseyKeyItem01Offset:Int = 0xc40
val odysseyKeyItem02Offset:Int = 0xc41
val odysseyKeyItem03Offset:Int = 0xc42
val flowerCrownDoodleKeyOffset:Int = 0xdad
val daisiesFlowerKeyItemOffset:Int = 0xdae
val calendulasFlowerKeyItemOffset:Int = 0xdaf
val redGerberaKeyItemOffset:Int = 0xdb0
val forgetMeNotsKeyOffset:Int = 0xdb1
val foxTailsKeyItemOffset:Int = 0xdb2
val chocoboMoogleCardKeyOffset:Int = 0xdb3
val kyriesMaintenanceNotesKeyOffset:Int = 0xdb4
val windmillGearKeyItemOffset:Int = 0xdb6
val gongagaRockSaltSketchOffset:Int = 0xdb7
val brokenMagongaMushroomKeyOffset:Int = 0xdb8
val magongaMushroomKeyItemOffset:Int = 0xdb9
val impureRockSaltKeyOffset:Int = 0xdba
val gongagaRockSaltKeyOffset:Int = 0xdbb
val rustedSheetMetalKeyOffset:Int = 0xdbc
val corrodedNailKeyItemOffset:Int = 0xdbd
val sheetMusicOnewingedAngelOffset:Int = 0xdbe
val playArtsStarFighterOffset:Int = 0xe75
val spacerangerPlayArtsFigureOffset:Int = 0xe76
val diosAutographKeyItemOffset:Int = 0xe77
val playArtsGBikeOffset:Int = 0xe78
val queensBloodGameboardKeyOffset:Int = 0xe79
val brawlerCloudFigurine3dOffset:Int = 0xe7a
val masamuneReplicaKeyItemOffset:Int = 0xe7b
val lovelessPosterKeyItemOffset:Int = 0xe7c
val rufusShinraCutoutKeyOffset:Int = 0xe7d
val saveCrystalKeyItemOffset:Int = 0xe7e
val playArtsBuggyFigureOffset:Int = 0xe7f
val playArtsTinyBroncoOffset:Int = 0xe80
val playArtsTinyWheelieOffset:Int = 0xe81
val stuffedChocoboKeyItemOffset:Int = 0xe82
val stuffedMoogleKeyItemOffset:Int = 0xe83
val stuffedCactuarKeyItemOffset:Int = 0xe84
val stuffedBombKeyItemOffset:Int = 0xe85
val stuffedFatChocoboKeyOffset:Int = 0xe86
val stuffedStampKeyItemOffset:Int = 0xe87
val stuffedTonberryKeyItemOffset:Int = 0xe88
val stuffedFatMoogleKeyOffset:Int = 0xe89
val playArtsSweeperFigureOffset:Int = 0xe8b
val brawlerPugilistFigurine3dOffset:Int = 0xe8c
val brawlerMoogleFigurine3dOffset:Int = 0xe8d
val brawlerDioFigurine3dOffset:Int = 0xe8e
val brawlerShivaFigurine3dOffset:Int = 0xe8f
val brawlerIfritFigurine3dOffset:Int = 0xe90
val playArtsShinraBoxOffset:Int = 0xe91
val playArtsRestSpotOffset:Int = 0xe92
val fledglingChocoboJockeyItemOffset:Int = 0xe93
val soaringChocoboJockeyItemOffset:Int = 0xe94
val salientianSealOfMasteryOffset:Int = 0xe95
val peerlessPolliowogTreasureTroveOffset:Int = 0xe96
val dolphinStuntmanTreasureTroveOffset:Int = 0xe97
val prideOfCondorCavalryOffset:Int = 0xe98
val awardForOutstandingPerformanceOffset:Int = 0xe99
val presidentialCommendationTreasureTroveOffset:Int = 0xe9a
val qbTournamentChampionTreasureOffset:Int = 0xe9b
val buccaneerBlasterTreasureTroveOffset:Int = 0xe9c
val pirateKingsMarksmanTreasureOffset:Int = 0xe9d
val legendaryCardCollectorTreasureOffset:Int = 0xe9e
val bloodyBrilliantCardSharpOffset:Int = 0xe9f
val neophyteQbStrategianTreasureOffset:Int = 0xea0
val kingOfTheJungleOffset:Int = 0xea1
val redBoltXiiiTreasureOffset:Int = 0xea2
val abFabTreasureTroveOffset:Int = 0xea3
val speedyMotorcyclistTreasureTroveOffset:Int = 0xea4
val crazyMotorcyclistTreasureTroveOffset:Int = 0xea5
val welterweightBrawlerTreasureTroveOffset:Int = 0xea6
val heavyweightBrawlerTreasureTroveOffset:Int = 0xea7
val superHeavyweightBrawlerTreasureOffset:Int = 0xea8
val rookieRangerTreasureTroveOffset:Int = 0xea9
val soldierGalaxyClassTreasureOffset:Int = 0xeaa
val chocoboWhispererTreasureTroveOffset:Int = 0xeab
val fleetFootedJocketTreasureOffset:Int = 0xeac
val chocoboBugBoyTreasureOffset:Int = 0xead
val chocoboJockeyTreasureTroveOffset:Int = 0xeae
val cardWhizTreasureTroveOffset:Int = 0xeaf
val cardSavantTreasureTroveOffset:Int = 0xeb0
val cardSlayerTreasureTroveOffset:Int = 0xeb1
val muscleheadWarriorsTreasureTroveOffset:Int = 0xeb2
val twinMuscleheadsTreasureTroveOffset:Int = 0xeb3
val theSixMuscKeteersOffset:Int = 0xeb4
val twinTeamTitansTreasureOffset:Int = 0xeb5
val bestSupportingActorBarretOffset:Int = 0xeb6
val bestActressTifaTreasureOffset:Int = 0xeb7
val bestActressAerithTreasureOffset:Int = 0xeb8
val bestSupportingRedXiiiOffset:Int = 0xeb9
val bestActressYuffieTreasureOffset:Int = 0xeba
val bestFelineNarrationCaitOffset:Int = 0xebb
val bestActorCloudTreasureOffset:Int = 0xebc
val dustbowlSmasherTreasureTroveOffset:Int = 0xebd
val dustbowlDemolisherTreasureTroveOffset:Int = 0xebe
val sylkisCupChampionTreasureOffset:Int = 0xebf
val prisonTourneyChampionTreasureOffset:Int = 0xec0
val wutaiPopStarTreasureOffset:Int = 0xec1
val bellesOfTheBallOffset:Int = 0xec2
val tenThousandNeedlePincushionOffset:Int = 0xec3
val oneThousandNeedlePincushionOffset:Int = 0xec4
val gambitTechnicianTreasureTroveOffset:Int = 0xec5
val somewhatIntriguingSpecimenTreasureOffset:Int = 0xec6
val adequatelyFunctionalSpecimenTreasureOffset:Int = 0xec7
val trueUltimatePartyAnimalOffset:Int = 0xec9
val peerlessPianistTreasureTroveOffset:Int = 0xeca
val shutterbugSupremeTreasureTroveOffset:Int = 0xecb
val bloodChampionTreasureTroveOffset:Int = 0xecc
val maiParticipationAwardTreasureOffset:Int = 0xecd
val maiGoldStarTreasureOffset:Int = 0xece
val madderMachinatorTreasureTroveOffset:Int = 0xecf
val midgarInfantryUniformCloudOffset:Int = 0xed0
val midgarInfantryUniformTifaOffset:Int = 0xed1
val midgarInfantryUniformAerithOffset:Int = 0xed2
val moogleHatCapeTreasureOffset:Int = 0xed3
val keyBeckBadassesHideoutOffset:Int = 0xed9
val beckProtorelicTreasureTroveOffset:Int = 0xeda
val theCaptainProtorelicTreasureOffset:Int = 0xedb
val kidGProtorelicTreasureOffset:Int = 0xedc
val theTurkProtorelicTreasureOffset:Int = 0xedd
val lifestreamFontsProtorelicTreasureOffset:Int = 0xede
val blackRobesProtorelicTreasureOffset:Int = 0xedf
val unknownKeyItem03Offset:Int = 0xee0
val unknownKeyItem04Offset:Int = 0xee1
val unknownKeyItem05Offset:Int = 0xee2
val unknownKeyItem06Offset:Int = 0xee3
val unknownKeyItem07Offset:Int = 0xee4
val unknownKeyItem08Offset:Int = 0xee5
val unknownKeyItem09Offset:Int = 0xee6
val unknownKeyItem10Offset:Int = 0xee7
val unknownKeyItem11Offset:Int = 0xee8
val unknownKeyItem12Offset:Int = 0xee9
val unknownKeyItem13Offset:Int = 0xeea
val unknownKeyItem14Offset:Int = 0xeeb
val unknownKeyItem15Offset:Int = 0xeec
val unknownKeyItem16Offset:Int = 0xeed
val unknownKeyItem17Offset:Int = 0xeee
val unknownKeyItem18Offset:Int = 0xeef
val unknownKeyItem19Offset:Int = 0xef0
val unknownKeyItem20Offset:Int = 0xef1
val cactuarStatueITreasureOffset:Int = 0xef5
val cactuarStatueIiTreasureOffset:Int = 0xef6
val cactuarStatueIiiTreasureOffset:Int = 0xef7
val cactuarStatueIvTreasureOffset:Int = 0xef8
val treasureSandsFragmentAlphaOffset:Int = 0xef9
val treasureSandsFragmentBetaOffset:Int = 0xefa
val treasureSandsFragmentGammaOffset:Int = 0xefb
val protorelicFragmentAlphaTreasureOffset:Int = 0xefd
val protorelicFragmentBetaTreasureOffset:Int = 0xefe
val protorelicFragmentGammaTreasureOffset:Int = 0xeff
val protorelicFragmentDeltaTreasureOffset:Int = 0xf00
val protorelicFragmentEpsilonTreasureOffset:Int = 0xf01
val pirateRelicTreasureMapOffset:Int = 0xf3c
val photoAlbumKeyItemOffset:Int = 0xf3d
val artSwordplayVolIOffset:Int = 0xf64
val artSwordplayVolIiOffset:Int = 0xf65
val artSwordplayVolIiiOffset:Int = 0xf66
val artSwordplayVolIvOffset:Int = 0xf67
val artSwordplayVolVOffset:Int = 0xf68
val artSwordplayVolViOffset:Int = 0xf69
val artSwordplayVolViiOffset:Int = 0xf6a
val artSwordplayVolViiiOffset:Int = 0xf6b
val artSwordplayVolIxOffset:Int = 0xf6c
val artSwordplayVolXOffset:Int = 0xf6d
val artSwordplayVolXiOffset:Int = 0xf6e
val artSwordplayVolXiiOffset:Int = 0xf6f
val artSwordplayVolXiiiOffset:Int = 0xf70
val artSwordplayVolXivOffset:Int = 0xf71
val artSwordplayVolXvOffset:Int = 0xf72
val artSwordplayVolXviOffset:Int = 0xf73
val sharpshooterCompanionVolIOffset:Int = 0xf74
val sharpshooterCompanionVolIiOffset:Int = 0xf75
val sharpshooterCompanionVolIiiOffset:Int = 0xf76
val sharpshooterCompanionVolIvOffset:Int = 0xf77
val sharpshooterCompanionVolVOffset:Int = 0xf78
val sharpshooterCompanionVolViOffset:Int = 0xf79
val sharpshooterCompanionVolViiOffset:Int = 0xf7a
val sharpshooterCompanionVolViiiOffset:Int = 0xf7b
val sharpshooterCompanionVolIxOffset:Int = 0xf7c
val sharpshooterCompanionVolXOffset:Int = 0xf7d
val sharpshooterCompanionVolXiOffset:Int = 0xf7e
val sharpshooterCompanionVolXiiOffset:Int = 0xf7f
val sharpshooterCompanionVolXiiiOffset:Int = 0xf80
val sharpshooterCompanionVolXivOffset:Int = 0xf81
val sharpshooterCompanionVolXvOffset:Int = 0xf82
val sharpshooterCompanionVolXviOffset:Int = 0xf83
val wayFistVolIOffset:Int = 0xf84
val wayFistVolIiOffset:Int = 0xf85
val wayFistVolIiiOffset:Int = 0xf86
val wayFistVolIvOffset:Int = 0xf87
val wayFistVolVOffset:Int = 0xf88
val wayFistVolViOffset:Int = 0xf89
val wayFistVolViiOffset:Int = 0xf8a
val wayFistVolViiiOffset:Int = 0xf8b
val wayFistVolIxOffset:Int = 0xf8c
val wayFistVolXOffset:Int = 0xf8d
val wayFistVolXiOffset:Int = 0xf8e
val wayFistVolXiiOffset:Int = 0xf8f
val wayFistVolXiiiOffset:Int = 0xf90
val wayFistVolXivOffset:Int = 0xf91
val wayFistVolXvOffset:Int = 0xf92
val wayFistVolXviOffset:Int = 0xf93
val telluricScripturesVolIOffset:Int = 0xf94
val telluricScripturesVolIiOffset:Int = 0xf95
val telluricScripturesVolIiiOffset:Int = 0xf96
val telluricScripturesVolIvOffset:Int = 0xf97
val telluricScripturesVolVOffset:Int = 0xf98
val telluricScripturesVolViOffset:Int = 0xf99
val telluricScripturesVolViiOffset:Int = 0xf9a
val telluricScripturesVolViiiOffset:Int = 0xf9b
val telluricScripturesVolIxOffset:Int = 0xf9c
val telluricScripturesVolXOffset:Int = 0xf9d
val telluricScripturesVolXiOffset:Int = 0xf9e
val telluricScripturesVolXiiOffset:Int = 0xf9f
val telluricScripturesVolXiiiOffset:Int = 0xfa0
val telluricScripturesVolXivOffset:Int = 0xfa1
val telluricScripturesVolXvOffset:Int = 0xfa2
val telluricScripturesVolXviOffset:Int = 0xfa3
val taleRedVolIOffset:Int = 0xfa4
val taleRedVolIiOffset:Int = 0xfa5
val taleRedVolIiiOffset:Int = 0xfa6
val taleRedVolIvOffset:Int = 0xfa7
val taleRedVolVOffset:Int = 0xfa8
val taleRedVolViOffset:Int = 0xfa9
val taleRedVolViiOffset:Int = 0xfaa
val taleRedVolViiiOffset:Int = 0xfab
val taleRedVolIxOffset:Int = 0xfac
val taleRedVolXOffset:Int = 0xfad
val taleRedVolXiOffset:Int = 0xfae
val taleRedVolXiiOffset:Int = 0xfaf
val taleRedVolXiiiOffset:Int = 0xfb0
val taleRedVolXivOffset:Int = 0xfb1
val taleRedVolXvOffset:Int = 0xfb2
val taleRedVolXviOffset:Int = 0xfb3
val secretsNinjaVolIOffset:Int = 0xfb4
val secretsNinjaVolIiOffset:Int = 0xfb5
val secretsNinjaVolIiiOffset:Int = 0xfb6
val secretsNinjaVolIvOffset:Int = 0xfb7
val secretsNinjaVolVOffset:Int = 0xfb8
val secretsNinjaVolViOffset:Int = 0xfb9
val secretsNinjaVolViiOffset:Int = 0xfba
val secretsNinjaVolViiiOffset:Int = 0xfbb
val secretsNinjaVolIxOffset:Int = 0xfbc
val secretsNinjaVolXOffset:Int = 0xfbd
val secretsNinjaVolXiOffset:Int = 0xfbe
val secretsNinjaVolXiiOffset:Int = 0xfbf
val secretsNinjaVolXiiiOffset:Int = 0xfc0
val secretsNinjaVolXivOffset:Int = 0xfc1
val secretsNinjaVolXvOffset:Int = 0xfc2
val secretsNinjaVolXviOffset:Int = 0xfc3
val fortunesUntoldVolIOffset:Int = 0xfc4
val fortunesUntoldVolIiOffset:Int = 0xfc5
val fortunesUntoldVolIiiOffset:Int = 0xfc6
val fortunesUntoldVolIvOffset:Int = 0xfc7
val fortunesUntoldVolVOffset:Int = 0xfc8
val fortunesUntoldVolViOffset:Int = 0xfc9
val fortunesUntoldVolViiOffset:Int = 0xfca
val fortunesUntoldVolViiiOffset:Int = 0xfcb
val fortunesUntoldVolIxOffset:Int = 0xfcc
val fortunesUntoldVolXOffset:Int = 0xfcd
val fortunesUntoldVolXiOffset:Int = 0xfce
val fortunesUntoldVolXiiOffset:Int = 0xfcf
val fortunesUntoldVolXiiiOffset:Int = 0xfd0
val fortunesUntoldVolXivOffset:Int = 0xfd1
val fortunesUntoldVolXvOffset:Int = 0xfd2
val fortunesUntoldVolXviOffset:Int = 0xfd3
val powerWristguardsMemberAccessoryOffset:Int = 0x2339
val bulletproofVestMemberAccessoryOffset:Int = 0x233a
val earringsEquipmentMemberAccessoryOffset:Int = 0x233b
val talismanEquipmentMemberAccessoryOffset:Int = 0x233c
val headbandEquipmentMemberAccessoryOffset:Int = 0x233d
val starPendantMemberAccessoryOffset:Int = 0x233e
val furyRingMemberAccessoryOffset:Int = 0x233f
val revivalEarringsMemberAccessoryOffset:Int = 0x2340
val whistlewindScarfMemberAccessoryOffset:Int = 0x2341
val mythicalAmuletMemberAccessoryOffset:Int = 0x2342
val healingCarcanetMemberAccessoryOffset:Int = 0x2343
val transferenceModuleMemberAccessoryOffset:Int = 0x2345
val spectralCogwheelMemberAccessoryOffset:Int = 0x2346
val moogleAmuletMemberAccessoryOffset:Int = 0x2347
val enfeeblementRingMemberAccessoryOffset:Int = 0x2348
val crescentMoonCharmAccessoryOffset:Int = 0x2349
val championBeltMemberAccessoryOffset:Int = 0x234a
val protectiveBootsMemberAccessoryOffset:Int = 0x234b
val circletEquipmentMemberAccessoryOffset:Int = 0x234c
val tarotCardsMemberAccessoryOffset:Int = 0x234d
val otherwordlyCrystalMemberAccessoryOffset:Int = 0x234e
val salvationBadgeMemberAccessoryOffset:Int = 0x234f
val enchantedRingMemberAccessoryOffset:Int = 0x2350
val supernaturalWristguardsMemberAccessoryOffset:Int = 0x2351
val survivalVestMemberAccessoryOffset:Int = 0x2352
val platinumEarringsMemberAccessoryOffset:Int = 0x2353
val timewornTalismanMemberAccessoryOffset:Int = 0x2354
val gotterdammerungEquipmentMemberAccessoryOffset:Int = 0x2355
val ribbonEquipmentMemberAccessoryOffset:Int = 0x2359
val hiPowerWristguardsAccessoryOffset:Int = 0x2365
val bulletproofVestMkIiOffset:Int = 0x2366
val magicalEarringsMemberAccessoryOffset:Int = 0x2367
val talismanFocusMemberAccessoryOffset:Int = 0x2368
val fullThrottleWristguardsAccessoryOffset:Int = 0x2369
val riotVestMemberAccessoryOffset:Int = 0x236a
val sorcerersEarringsMemberAccessoryOffset:Int = 0x236b
val cetraTalismanMemberAccessoryOffset:Int = 0x236c
val jeweledRingMemberAccessoryOffset:Int = 0x236d
val whiteCapMemberAccessoryOffset:Int = 0x236e
val genjiGlovesMemberAccessoryOffset:Int = 0x236f
val aureatePinionMemberAccessoryOffset:Int = 0x2370
val luckyAmuletMemberAccessoryOffset:Int = 0x2371
val fortitudeRingMemberAccessoryOffset:Int = 0x2372
val safetyBitMemberAccessoryOffset:Int = 0x2373
val nobleThiefsGlovesAccessoryOffset:Int = 0x2374
val karmicCowlMemberAccessoryOffset:Int = 0x2375
val expeditionaryMedalMemberAccessoryOffset:Int = 0x2376
val psychicCharmMemberAccessoryOffset:Int = 0x2377
val draconicRingMemberAccessoryOffset:Int = 0x2378
val malboroOrbMemberAccessoryOffset:Int = 0x2379
val speedDemonKeychainAccessoryOffset:Int = 0x237a
val pedometerPinMemberAccessoryOffset:Int = 0x237b
val giWarriorCharmAccessoryOffset:Int = 0x237c
val camaraderieEarringsMemberAccessoryOffset:Int = 0x237d
val genjiEarringsMemberAccessoryOffset:Int = 0x237e
val genjiRingMemberAccessoryOffset:Int = 0x237f
val silverBrawlerGlovesAccessoryOffset:Int = 0x2380
val goldenBrawlerGlovesAccessoryOffset:Int = 0x2381
val spaceRangerServiceMedalOffset:Int = 0x2382
val spaceRangerMedalHonorOffset:Int = 0x2383
val hermesShoesMemberAccessoryOffset:Int = 0x2384
val chocokingCapeMemberAccessoryOffset:Int = 0x2385
val beastkillerBadgeMemberAccessoryOffset:Int = 0x2386
val boxcrusherKeychainMemberAccessoryOffset:Int = 0x2387
val assessMateriaEarringsAccessoryOffset:Int = 0x2388
val revivalMateriaEarringsAccessoryOffset:Int = 0x2389
val hpUpMateriaEarringsOffset:Int = 0x238a
val limitBoosterMemberAccessoryOffset:Int = 0x2391
val chakraMateriaEarringsAccessoryOffset:Int = 0x2394
val prayerMateriaEarringsAccessoryOffset:Int = 0x2395
val mpUpMateriaEarringsOffset:Int = 0x2396
val luckUpMateriaEarringsOffset:Int = 0x2397
val steadfastBlockMateriaEarringsOffset:Int = 0x2398
val itemMasterMateriaEarringsOffset:Int = 0x2399
val precisionDefenseFocusEarringsOffset:Int = 0x239a
val fireMateriaEarringsAccessoryOffset:Int = 0x239b
val iceMateriaEarringsAccessoryOffset:Int = 0x239c
val lightningMateriaEarringsAccessoryOffset:Int = 0x239d
val windMateriaEarringsAccessoryOffset:Int = 0x239e
val healingMateriaEarringsAccessoryOffset:Int = 0x239f
val cleansingMateriaEarringsAccessoryOffset:Int = 0x23a0
val poisonMateriaEarringsAccessoryOffset:Int = 0x23a1
val bindingMateriaEarringsAccessoryOffset:Int = 0x23a2
val timeMateriaEarringsAccessoryOffset:Int = 0x23a3
val barrierMateriaEarringsAccessoryOffset:Int = 0x23a4
val subversionMateriaEarringsAccessoryOffset:Int = 0x23a5
val empowermentMateriaEarringsAccessoryOffset:Int = 0x23a6
val fortificationMateriaEarringsAccessoryOffset:Int = 0x23a7
val disempowermentMateriaEarringsAccessoryOffset:Int = 0x23a8
val enervationMateriaEarringsAccessoryOffset:Int = 0x23a9
val enhancedCamaraderieEarringsAccessoryOffset:Int = 0x23aa
val enhancedPsychicCharmAccessoryOffset:Int = 0x23ab
val enhancedKarmicCowlAccessoryOffset:Int = 0x23ac
val enhancedMalboroOrbAccessoryOffset:Int = 0x23ad
val enhancedDraconicRingAccessoryOffset:Int = 0x23ae
val enhancedExpeditionaryMedalAccessoryOffset:Int = 0x23af
val corsairCompassMemberAccessoryOffset:Int = 0x23b0
val kupoCharmMemberAccessoryOffset:Int = 0x23b1
val reclaimantChokerMemberAccessoryOffset:Int = 0x23b2
val transmuterChipArmor1Offset:Int = 0x4e20
val transmuterChipArmor2Offset:Int = 0x4e21
val transmuterChipArmor3Offset:Int = 0x4e22
val transmuterChipArmor4Offset:Int = 0x4e23
val transmuterChipArmor5Offset:Int = 0x4e24
val transmuterChipArmor6Offset:Int = 0x4e25
val transmuterChipArmor7Offset:Int = 0x4e26
val transmuterChipArmor8Offset:Int = 0x4e27
val transmuterChipArmor9Offset:Int = 0x4e28
val transmuterChipArmor10Offset:Int = 0x4e29
val transmuterChipArmor11Offset:Int = 0x4e2a
val transmuterChipArmor12Offset:Int = 0x4e2b
val transmuterChipBasicAccessoriesOffset:Int = 0x4e2c
val transmuterChipAdvancedAccessoriesOffset:Int = 0x4e2d
val transmuterChipAdvancedItemsOffset:Int = 0x4e2f
val transmuterChipCamaraderieEarringsOffset:Int = 0x4e30
val transmuterChipPsychicCharmOffset:Int = 0x4e31
val transmuterChipKarmicCowlOffset:Int = 0x4e32
val transmuterChipMalboroOrbOffset:Int = 0x4e33
val transmuterChipDraconicRingOffset:Int = 0x4e34
val transmuterChipExpeditionaryMedalOffset:Int = 0x4e35
val transmuterChipCushionChipOffset:Int = 0x4e36
val transmuterChipWindmillGearOffset:Int = 0x4e37
val transmuterChipBoilerValveOffset:Int = 0x4e38
val transmuterChipBirdTrapOffset:Int = 0x4e39
val transmuterChipLegendaryBaitOffset:Int = 0x4e3a
val transmuterChipSupremeAccessoriesOffset:Int = 0x4e3b
val transmuterChipImmunityAccessoriesOffset:Int = 0x4e3c
val transmuterChipHealingCarcanetOffset:Int = 0x4e3d
val transmuterChipSaferyBitOffset:Int = 0x4e3e
val transmuterChipGenjiArmamentsOffset:Int = 0x4e3f
val transmuterChipUltimateAccessoriesOffset:Int = 0x4e40
val transmuterChipCorsairCompassOffset:Int = 0x4e41
val shinraAvianHelmetGearOffset:Int = 0x5209
val shinraAvianBreastplateGearOffset:Int = 0x520a
val shinraAvianGreavesGearOffset:Int = 0x520b
val scorpionHelmetChocoboGearOffset:Int = 0x520c
val scorpionBreastplateChocoboGearOffset:Int = 0x520d
val scorpionGreavesChocoboGearOffset:Int = 0x520e
val rodeoHatChocoboGearOffset:Int = 0x520f
val rodeoPonchoChocoboGearOffset:Int = 0x5210
val rodeoLegwrapsChocoboGearOffset:Int = 0x5211
val treasureHunterVisorGearOffset:Int = 0x5212
val treasureHunterSaddleGearOffset:Int = 0x5213
val treasureHunterGaitersGearOffset:Int = 0x5214
val mysticalHeaddressChocoboGearOffset:Int = 0x5215
val mysticalNeckwrapChocoboGearOffset:Int = 0x5216
val mysticalAnkletsChocoboGearOffset:Int = 0x5217
val saurianHelmChocoboGearOffset:Int = 0x5218
val saurianArmorChocoboGearOffset:Int = 0x5219
val saurianGreavesChocoboGearOffset:Int = 0x521a
val debonairHatChocoboGearOffset:Int = 0x521b
val debonairWaistcoatChocoboGearOffset:Int = 0x521c
val debonairAnkletsChocoboGearOffset:Int = 0x521d
val giHeaddressChocoboGearOffset:Int = 0x521e
val giCloakChocoboGearOffset:Int = 0x521f
val giLegwrapsChocoboGearOffset:Int = 0x5220
val hyperionHelmChocoboGearOffset:Int = 0x5221
val hyperionArmorChocoboGearOffset:Int = 0x5222
val hyperionShinChocoboGearOffset:Int = 0x5223
val tropicalVisorChocoboGearOffset:Int = 0x5224
val tropicalShawlChocoboGearOffset:Int = 0x5225
val tropicalAnkletsChocoboGearOffset:Int = 0x5226
val mercCapChocoboGearOffset:Int = 0x5227
val mercOverallsChocoboGearOffset:Int = 0x5228
val mercLegwrapsChocoboGearOffset:Int = 0x5229
val card001SecurityOfficerOffset:Int = 0x55f1
val card002RiotTrooperOffset:Int = 0x55f2
val card005QueenBeeOffset:Int = 0x55f3
val card016DevilRiderOffset:Int = 0x55f4
val card004JunitSweeperOffset:Int = 0x55f5
val card006ToxiratQbOffset:Int = 0x55f6
val card007LevikronQbOffset:Int = 0x55f7
val card008GrasslandsWolfOffset:Int = 0x55f8
val card009MuQbOffset:Int = 0x55f9
val card010MandragoraQbOffset:Int = 0x55fa
val card011ElphadunkQbOffset:Int = 0x55fb
val card014QuetzalcoatlQbOffset:Int = 0x55fc
val card018FlanQbOffset:Int = 0x55fd
val card012CactuarQbOffset:Int = 0x55fe
val card012CrystallineCrabOffset:Int = 0x55ff
val card017ScreamerQbOffset:Int = 0x5600
val card003GrenadierQbOffset:Int = 0x5601
val card015ZuQbOffset:Int = 0x5602
val card019CrawlerQbOffset:Int = 0x5603
val card020ArchdragonQbOffset:Int = 0x5604
val card021OgreQbOffset:Int = 0x5605
val card114MythrilGolemOffset:Int = 0x5606
val card024ZemzelettQbOffset:Int = 0x5607
val card025IgniliskQbOffset:Int = 0x5608
val card023FleetwingQbOffset:Int = 0x5609
val card026CapparwireQbOffset:Int = 0x560a
val card029HellriderIiOffset:Int = 0x560b
val card027MindflayerQbOffset:Int = 0x560c
val card022DeathwheelQbOffset:Int = 0x560d
val card028ScrutineyeQbOffset:Int = 0x560e
val card115TerrorDeepOffset:Int = 0x560f
val card030FlametrooperQbOffset:Int = 0x5610
val card033ShoalopodQbOffset:Int = 0x5611
val card034CrownLanceOffset:Int = 0x5612
val card031SpearhawkQbOffset:Int = 0x5613
val card032SeaDevilOffset:Int = 0x5614
val card035TonberryKingOffset:Int = 0x5615
val card040HeatseekerQbOffset:Int = 0x5616
val card037BloatfloatQbOffset:Int = 0x5617
val card038BagnadranaQbOffset:Int = 0x5618
val card039CockatriceQbOffset:Int = 0x5619
val card041BombQbOffset:Int = 0x561a
val card036SandhogPieOffset:Int = 0x561b
val card117CustomValkyrieOffset:Int = 0x561c
val card118GigatriceQbOffset:Int = 0x561d
val card042ThugQbOffset:Int = 0x561e
val card043DeathClawOffset:Int = 0x561f
val card044LandwormQbOffset:Int = 0x5620
val card045SandspitterQbOffset:Int = 0x5621
val card046ChimeraQbOffset:Int = 0x5622
val card047JokerQbOffset:Int = 0x5623
val card054GrandhornQbOffset:Int = 0x5624
val card050GagighandiQbOffset:Int = 0x5625
val card048AmphidexQbOffset:Int = 0x5626
val card049FrightflowerQbOffset:Int = 0x5627
val card056GrangalanQbOffset:Int = 0x5628
val card051InsectoidChimeraOffset:Int = 0x5629
val card052GigantoadQbOffset:Int = 0x562a
val card053MalocerosQbOffset:Int = 0x562b
val card055GreatMalboroOffset:Int = 0x562c
val card057AmalgamQbOffset:Int = 0x562d
val card121SpecimenH1024Offset:Int = 0x562e
val card058SkeeskeeQbOffset:Int = 0x562f
val card059GriffonQbOffset:Int = 0x5630
val card065StoneGolemOffset:Int = 0x5631
val card060BasiliskQbOffset:Int = 0x5632
val card063DesertSahaginOffset:Int = 0x5633
val card061ReapertailQbOffset:Int = 0x5634
val card062JabberwockQbOffset:Int = 0x5635
val card064CavestalkerQbOffset:Int = 0x5636
val card067GiSpecterOffset:Int = 0x5637
val card066TwoFaceOffset:Int = 0x5638
val card068ValronQbOffset:Int = 0x5639
val card069DisgorgonQbOffset:Int = 0x563a
val card071TwinBrainOffset:Int = 0x563b
val card070DragonQbOffset:Int = 0x563c
val card077DiabolicVariantOffset:Int = 0x563d
val card073BahbaVelamyuOffset:Int = 0x563e
val card074RictusQbOffset:Int = 0x563f
val card072BlackBatOffset:Int = 0x5640
val card076YinYangOffset:Int = 0x5641
val card075AdjudicatorQbOffset:Int = 0x5642
val card124ForgottenSpecimenOffset:Int = 0x5643
val card078SpecialForcesOffset:Int = 0x5644
val card0792cSoldierOffset:Int = 0x5645
val card080KelzmelzerQbOffset:Int = 0x5646
val card081PantheraProtectorOffset:Int = 0x5648
val card082HecteyesQbOffset:Int = 0x5649
val card085MossgrownAdamantoiseOffset:Int = 0x564a
val card084IroncladQbOffset:Int = 0x564b
val card083FloatingDeathOffset:Int = 0x564c
val card126RedDragonOffset:Int = 0x564d
val card127DemonGateOffset:Int = 0x564e
val card086CloudQbOffset:Int = 0x5655
val card087BarretQbOffset:Int = 0x5656
val card088TifaQbOffset:Int = 0x5657
val card089AerithQbOffset:Int = 0x5658
val card090RedXiiiOffset:Int = 0x5659
val card091YuffieQbOffset:Int = 0x565a
val card092CaitSithOffset:Int = 0x565b
val card093CidQbOffset:Int = 0x565c
val card094VincentQbOffset:Int = 0x565d
val card095IfritQbOffset:Int = 0x565f
val card096ShivaQbOffset:Int = 0x5660
val card107ChocoboMoogleOffset:Int = 0x5661
val card108FatChocoboOffset:Int = 0x5662
val card102LeviathanQbOffset:Int = 0x5663
val card104BahamutQbOffset:Int = 0x5664
val card109PoshChocoboOffset:Int = 0x5665
val card111MagicPotOffset:Int = 0x5666
val card110MoogleTrioOffset:Int = 0x5667
val card097RamuhQbOffset:Int = 0x5668
val card098TitanQbOffset:Int = 0x5669
val card099KujataQbOffset:Int = 0x566a
val card100OdinQbOffset:Int = 0x566b
val card101PhoenixQbOffset:Int = 0x566c
val card103AlexanderQbOffset:Int = 0x566d
val card105BahamutArisenOffset:Int = 0x566e
val card106GilgameshQbOffset:Int = 0x566f
val card143SephirothQbOffset:Int = 0x5670
val card128RenoQbOffset:Int = 0x5671
val card129RudeQbOffset:Int = 0x5672
val card130ElenaQbOffset:Int = 0x5673
val card131TsengQbOffset:Int = 0x5674
val card132RufusQbOffset:Int = 0x5675
val card116GrasptropodQbOffset:Int = 0x5676
val card120AnuranSuppressorOffset:Int = 0x5677
val card122CrimsonMkiiOffset:Int = 0x5678
val card125DonCorneoOffset:Int = 0x5679
val card119DyneQbOffset:Int = 0x567e
val card123GiNattakOffset:Int = 0x567f
val card112MateriaGuardianOffset:Int = 0x5681
val card113MidgardsomrQbOffset:Int = 0x5682
val card133RocheQbOffset:Int = 0x5683
val card134JSquadOffset:Int = 0x5684
val card144EmeraldWitchOffset:Int = 0x5685
val card145ShadowbloodQueenOffset:Int = 0x5687
val card135ChocoboJockeyOffset:Int = 0x5688
val card136SpaceRangerOffset:Int = 0x5689
val card137HauntedHotelOffset:Int = 0x568a
val card141DioQbOffset:Int = 0x568b
val card138SkywheelQbOffset:Int = 0x568c
val card139LovelessQbOffset:Int = 0x568d
val card140SaucerSquadOffset:Int = 0x568e
val card142UltimateAnimalOffset:Int = 0x568f
val qbBoosterSuppressiveStrikersOffset:Int = 0x569c
val qbBoosterRuffiansPackOffset:Int = 0x569d
val qbBoosterWeirdWickedOffset:Int = 0x569e
val qbBoosterShutupDriveOffset:Int = 0x569f
val qbBoosterHighseasHorrorOffset:Int = 0x56a0
val qbBoosterUncannyTerrorsOffset:Int = 0x56a1
val qbBoosterHeavyHittersOffset:Int = 0x56a2
val qbBoosterJungleArcanumOffset:Int = 0x56a3
val qbBoosterChimericalCreaturesOffset:Int = 0x56a4
val qbBoosterStrangerFictionOffset:Int = 0x56a5
val qbBoosterPrehistoricBeastsOffset:Int = 0x56a6
val qbBoosterCarnivalCarnageOffset:Int = 0x56a7
val qbBoosterAncientStewardsOffset:Int = 0x56a8
val qbBoosterChtonicSentinelsOffset:Int = 0x56a9
val qbBoosterTheTurksOffset:Int = 0x56aa
val qbBoosterEndgameBaddiesOffset:Int = 0x56ac

//endregion INVENTORY ITEM OFFSET
