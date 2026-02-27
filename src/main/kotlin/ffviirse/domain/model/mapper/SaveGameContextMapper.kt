package ffviirse.domain.model.mapper

import ffviirse.domain.extension.format
import ffviirse.domain.extension.toDuration
import ffviirse.domain.model.context.GeneralDataContext
import ffviirse.domain.model.context.SaveGameContext
import ffviirse.domain.model.entity.GeneralData
import ffviirse.domain.model.entity.SaveGame

fun SaveGameContext.update(saveGame: SaveGame) {
    saveFile.value = saveGame.saveFile
    generalData.update(saveGame.generalData)
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
}

fun SaveGameContext.toSaveGame(): SaveGame = SaveGame(
    saveFile = saveFile.value!!,
    generalData = generalData.toGeneralData(),
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
)
