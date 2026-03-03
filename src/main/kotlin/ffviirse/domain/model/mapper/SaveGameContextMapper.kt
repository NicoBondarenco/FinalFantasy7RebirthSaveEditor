package ffviirse.domain.model.mapper

import ffviirse.domain.extension.format
import ffviirse.domain.extension.toDuration
import ffviirse.domain.model.context.CharacterInfoContext
import ffviirse.domain.model.context.GeneralDataContext
import ffviirse.domain.model.context.PartyInfoContext
import ffviirse.domain.model.context.SaveGameContext
import ffviirse.domain.model.entity.CharacterInfo
import ffviirse.domain.model.entity.GeneralData
import ffviirse.domain.model.entity.PartyInfo
import ffviirse.domain.model.entity.SaveGame

fun SaveGameContext.update(saveGame: SaveGame) {
    saveFile.value = saveGame.saveFile
    generalData.update(saveGame.generalData)
    partyInfo.update(saveGame.partyInfo)
}

fun GeneralDataContext.update(generalData: GeneralData) {
    playTime.value = generalData.playTime.format(3)
    playHours.value = generalData.playHours
    playMinutes.value = generalData.playMinutes
    playSeconds.value = generalData.playSeconds
    totalGil.value = generalData.totalGil
    mainMenu.value = generalData.mainMenu
    extraSettings.value = generalData.extraSettings
    playLog.value = generalData.playLog
    chapterSelection.value = generalData.chapterSelection
    chapterOne.value = generalData.chapterOne
    chapterTwo.value = generalData.chapterTwo
    chapterThree.value = generalData.chapterThree
    chapterFour.value = generalData.chapterFour
    chapterFive.value = generalData.chapterFive
    chapterSix.value = generalData.chapterSix
    chapterSeven.value = generalData.chapterSeven
    chapterEight.value = generalData.chapterEight
    chapterNine.value = generalData.chapterNine
    chapterTen.value = generalData.chapterTen
    chapterEleven.value = generalData.chapterEleven
    chapterTwelve.value = generalData.chapterTwelve
    chapterThirteen.value = generalData.chapterThirteen
    chapterFourteen.value = generalData.chapterFourteen
    groupExperience.value = generalData.groupExperience
    rancidBreath.value = generalData.rancidBreath
    plasmaDischarge.value = generalData.plasmaDischarge
    mindBlast.value = generalData.mindBlast
    gorgonShield.value = generalData.gorgonShield
    soothingBreeze.value = generalData.soothingBreeze
    selfDestruct.value = generalData.selfDestruct
    sonicBoom.value = generalData.sonicBoom
    cloudOutfit.value = generalData.cloudOutfit
    barretOutfit.value = generalData.barretOutfit
    tifaOutfit.value = generalData.tifaOutfit
    aerithOutfit.value = generalData.aerithOutfit
    redOutfit.value = generalData.redOutfit
    yuffieOutfit.value = generalData.yuffieOutfit
    caitOutfit.value = generalData.caitOutfit
}

fun PartyInfoContext.update(partyInfo: PartyInfo) {
    cloudStrife.update(partyInfo.cloudStrife)
    barretWallace.update(partyInfo.barretWallace)
    tifaLockhart.update(partyInfo.tifaLockhart)
    aerithGainsborough.update(partyInfo.aerithGainsborough)
    redXiii.update(partyInfo.redXiii)
    yuffieKisaragi.update(partyInfo.yuffieKisaragi)
    caitSith.update(partyInfo.caitSith)
}

fun CharacterInfoContext.update(characterInfo: CharacterInfo) {
    characterMember.value = characterInfo.characterMember
    characterLevel.value = characterInfo.characterLevel
    characterExperience.value = characterInfo.characterExperience
    characterRelationship.value = characterInfo.characterRelationship
    characterHpcurrent.value = characterInfo.characterHpcurrent
    characterHpmax.value = characterInfo.characterHpmax
    characterMpcurrent.value = characterInfo.characterMpcurrent
    characterMpmax.value = characterInfo.characterMpmax
    characterAttack.value = characterInfo.characterAttack
    characterMattack.value = characterInfo.characterMattack
    characterDefense.value = characterInfo.characterDefense
    characterMdefense.value = characterInfo.characterMdefense
    characterStrength.value = characterInfo.characterStrength
    characterMagic.value = characterInfo.characterMagic
    characterVitality.value = characterInfo.characterVitality
    characterSpirit.value = characterInfo.characterSpirit
    characterLuck.value = characterInfo.characterLuck
    characterSpeed.value = characterInfo.characterSpeed
    criticalHrate.value = characterInfo.criticalHrate
    weaponLevel.value = characterInfo.weaponLevel
    characterWeapon.value = characterInfo.characterWeapon
    characterArmor.value = characterInfo.characterArmor
    characterSummon.value = characterInfo.characterSummon
    characterAccessory.value = characterInfo.characterAccessory
    statBoost01.value = characterInfo.statBoost01
    statBoost02.value = characterInfo.statBoost02
    statBoost03.value = characterInfo.statBoost03
    statBoost04.value = characterInfo.statBoost04
    statBoost05.value = characterInfo.statBoost05
    statBoost06.value = characterInfo.statBoost06
    statBoost07.value = characterInfo.statBoost07
    statBoost08.value = characterInfo.statBoost08
    statBoost09.value = characterInfo.statBoost09
    statBoost10.value = characterInfo.statBoost10
    statBoost11.value = characterInfo.statBoost11
    statBoost12.value = characterInfo.statBoost12
    statBoost13.value = characterInfo.statBoost13
    statBoost14.value = characterInfo.statBoost14
    statBoost15.value = characterInfo.statBoost15
    statBoost16.value = characterInfo.statBoost16
    statBoost17.value = characterInfo.statBoost17
    statBoost18.value = characterInfo.statBoost18
    statBoost19.value = characterInfo.statBoost19
    limitBreak.value = characterInfo.limitBreak
    characterAbility01.value = characterInfo.characterAbility01
    characterAbility02.value = characterInfo.characterAbility02
    characterAbility03.value = characterInfo.characterAbility03
    characterAbility04.value = characterInfo.characterAbility04
    characterAbility05.value = characterInfo.characterAbility05
    synergySkill01.value = characterInfo.synergySkill01
    synergySkill02.value = characterInfo.synergySkill02
    synergySkill03.value = characterInfo.synergySkill03
    synergyAbility01.value = characterInfo.synergyAbility01
    synergyAbility02.value = characterInfo.synergyAbility02
    synergyAbility03.value = characterInfo.synergyAbility03
    synergyAbility04.value = characterInfo.synergyAbility04
    synergyAbility05.value = characterInfo.synergyAbility05
    synergyAbility06.value = characterInfo.synergyAbility06
    weaponMaterias.clear()
    armorMaterias.clear()
    weaponMaterias.addAll(characterInfo.weaponMaterias)
    armorMaterias.addAll(characterInfo.armorMaterias)
}

fun SaveGameContext.toSaveGame(): SaveGame = SaveGame(
    saveFile = saveFile.value!!,
    generalData = generalData.toGeneralData(),
    partyInfo = partyInfo.toPartyInfo(),
)

fun GeneralDataContext.toGeneralData(): GeneralData = GeneralData(
    playTime = playTime.value.toDuration(),
    playHours = playHours.value,
    playMinutes = playMinutes.value,
    playSeconds = playSeconds.value,
    totalGil = totalGil.value,
    mainMenu = mainMenu.value,
    extraSettings = extraSettings.value,
    playLog = playLog.value,
    chapterSelection = chapterSelection.value,
    chapterOne = chapterOne.value,
    chapterTwo = chapterTwo.value,
    chapterThree = chapterThree.value,
    chapterFour = chapterFour.value,
    chapterFive = chapterFive.value,
    chapterSix = chapterSix.value,
    chapterSeven = chapterSeven.value,
    chapterEight = chapterEight.value,
    chapterNine = chapterNine.value,
    chapterTen = chapterTen.value,
    chapterEleven = chapterEleven.value,
    chapterTwelve = chapterTwelve.value,
    chapterThirteen = chapterThirteen.value,
    chapterFourteen = chapterFourteen.value,
    groupExperience = groupExperience.value,
    rancidBreath = rancidBreath.value,
    plasmaDischarge = plasmaDischarge.value,
    mindBlast = mindBlast.value,
    gorgonShield = gorgonShield.value,
    soothingBreeze = soothingBreeze.value,
    selfDestruct = selfDestruct.value,
    sonicBoom = sonicBoom.value,
    cloudOutfit = cloudOutfit.value,
    barretOutfit = barretOutfit.value,
    tifaOutfit = tifaOutfit.value,
    aerithOutfit = aerithOutfit.value,
    redOutfit = redOutfit.value,
    yuffieOutfit = yuffieOutfit.value,
    caitOutfit = caitOutfit.value,
)

fun PartyInfoContext.toPartyInfo(): PartyInfo = PartyInfo(
    cloudStrife = cloudStrife.toCharacterInfo(),
    barretWallace = barretWallace.toCharacterInfo(),
    tifaLockhart = tifaLockhart.toCharacterInfo(),
    aerithGainsborough = aerithGainsborough.toCharacterInfo(),
    redXiii = redXiii.toCharacterInfo(),
    yuffieKisaragi = yuffieKisaragi.toCharacterInfo(),
    caitSith = caitSith.toCharacterInfo(),
)

fun CharacterInfoContext.toCharacterInfo(): CharacterInfo = CharacterInfo(
    characterMember = characterMember.value,
    characterLevel = characterLevel.value,
    characterExperience = characterExperience.value,
    characterRelationship = characterRelationship.value,
    characterHpcurrent = characterHpcurrent.value,
    characterHpmax = characterHpmax.value,
    characterMpcurrent = characterMpcurrent.value,
    characterMpmax = characterMpmax.value,
    characterAttack = characterAttack.value,
    characterMattack = characterMattack.value,
    characterDefense = characterDefense.value,
    characterMdefense = characterMdefense.value,
    characterStrength = characterStrength.value,
    characterMagic = characterMagic.value,
    characterVitality = characterVitality.value,
    characterSpirit = characterSpirit.value,
    characterLuck = characterLuck.value,
    characterSpeed = characterSpeed.value,
    criticalHrate = criticalHrate.value,
    weaponLevel = weaponLevel.value,
    characterWeapon = characterWeapon.value,
    characterArmor = characterArmor.value,
    characterSummon = characterSummon.value,
    characterAccessory = characterAccessory.value,
    statBoost01 = statBoost01.value,
    statBoost02 = statBoost02.value,
    statBoost03 = statBoost03.value,
    statBoost04 = statBoost04.value,
    statBoost05 = statBoost05.value,
    statBoost06 = statBoost06.value,
    statBoost07 = statBoost07.value,
    statBoost08 = statBoost08.value,
    statBoost09 = statBoost09.value,
    statBoost10 = statBoost10.value,
    statBoost11 = statBoost11.value,
    statBoost12 = statBoost12.value,
    statBoost13 = statBoost13.value,
    statBoost14 = statBoost14.value,
    statBoost15 = statBoost15.value,
    statBoost16 = statBoost16.value,
    statBoost17 = statBoost17.value,
    statBoost18 = statBoost18.value,
    statBoost19 = statBoost19.value,
    limitBreak = limitBreak.value,
    characterAbility01 = characterAbility01.value,
    characterAbility02 = characterAbility02.value,
    characterAbility03 = characterAbility03.value,
    characterAbility04 = characterAbility04.value,
    characterAbility05 = characterAbility05.value,
    synergySkill01 = synergySkill01.value,
    synergySkill02 = synergySkill02.value,
    synergySkill03 = synergySkill03.value,
    synergyAbility01 = synergyAbility01.value,
    synergyAbility02 = synergyAbility02.value,
    synergyAbility03 = synergyAbility03.value,
    synergyAbility04 = synergyAbility04.value,
    synergyAbility05 = synergyAbility05.value,
    synergyAbility06 = synergyAbility06.value,
    weaponMaterias = weaponMaterias.toList(),
    armorMaterias = armorMaterias.toList(),
)
