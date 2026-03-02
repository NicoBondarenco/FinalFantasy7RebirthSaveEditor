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

val groupExperienceOffset: Int = 0x4EEC4

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
val characterWeaponOffset: Int = 0xCC
val characterArmorOffset: Int = 0xD0
val characterSummonOffset: Int = 0xD4
val characterAccessoryOffset: Int = 0xD8
val weaponMateriaOffset: Int = 0xF4
val armorMateriaOffset: Int = 0xAC
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
