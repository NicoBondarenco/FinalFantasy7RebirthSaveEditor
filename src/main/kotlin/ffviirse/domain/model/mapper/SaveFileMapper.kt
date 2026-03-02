package ffviirse.domain.model.mapper

import ffviirse.domain.model.entity.CharacterInfo
import ffviirse.domain.model.entity.GeneralData
import ffviirse.domain.model.entity.PartyInfo
import ffviirse.domain.model.entity.SaveGame
import ffviirse.domain.model.value.EnemySkill.GORGON_SHIELD
import ffviirse.domain.model.value.EnemySkill.MIND_BLAST
import ffviirse.domain.model.value.EnemySkill.NO_SKILL
import ffviirse.domain.model.value.EnemySkill.PLASMA_DISCHARGE
import ffviirse.domain.model.value.EnemySkill.RANCID_BREATH
import ffviirse.domain.model.value.EnemySkill.SELF_DESTRUCT
import ffviirse.domain.model.value.EnemySkill.SONIC_BOOM
import ffviirse.domain.model.value.EnemySkill.SOOTHING_BREEZE
import ffviirse.domain.model.value.MemberOutfit
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI
import java.nio.ByteBuffer
import java.nio.ByteOrder.LITTLE_ENDIAN

private val enemySkillMap = mapOf(
    GeneralData::rancidBreath to RANCID_BREATH,
    GeneralData::plasmaDischarge to PLASMA_DISCHARGE,
    GeneralData::mindBlast to MIND_BLAST,
    GeneralData::gorgonShield to GORGON_SHIELD,
    GeneralData::soothingBreeze to SOOTHING_BREEZE,
    GeneralData::selfDestruct to SELF_DESTRUCT,
    GeneralData::sonicBoom to SONIC_BOOM,
)

private val enemySkillSlot = mapOf(
    1 to skillSlotOne,
    2 to skillSlotTwo,
    3 to skillSlotThree,
    4 to skillSlotFour,
    5 to skillSlotFive,
    6 to skillSlotSix,
    7 to skillSlotSeven,
)

private val memberOutfitMap = mapOf(
    CLOUD_STRIFE to GeneralData::cloudOutfit,
    BARRET_WALLACE to GeneralData::barretOutfit,
    TIFA_LOCKHART to GeneralData::tifaOutfit,
    AERITH_GAINSBOROUGH to GeneralData::aerithOutfit,
    RED_XIII to GeneralData::redOutfit,
    YUFFIE_KISARAGI to GeneralData::yuffieOutfit,
    CAIT_SITH to GeneralData::caitOutfit,
)

fun SaveGame.writeSaveFile(): ByteArray = this.saveFile.readBytes().also { bytes ->
    bytes.writeGeneralData(this.generalData)
    bytes.writePartyInfo(this.partyInfo)
}

fun ByteArray.writePartyInfo(partyInfo: PartyInfo): ByteArray = this.also {
    writeCharacterInfo(partyInfo.cloudStrife)
    writeCharacterInfo(partyInfo.barretWallace)
    writeCharacterInfo(partyInfo.tifaLockhart)
    writeCharacterInfo(partyInfo.aerithGainsborough)
    writeCharacterInfo(partyInfo.redXiii)
    writeCharacterInfo(partyInfo.yuffieKisaragi)
    writeCharacterInfo(partyInfo.caitSith)
}

fun ByteArray.writeCharacterInfo(characterInfo: CharacterInfo): ByteArray = this.also { byteArray ->
    val characterBase = characterInfo.characterMember.fileIndex * characterBaseOffset
    writeByte(characterBase + characterLevelOffset, characterInfo.characterLevel)
    writeInt32(characterBase + characterExperienceOffset, characterInfo.characterExperience)
    writeInt32(characterBase + characterHpcurrentOffset, characterInfo.characterHpcurrent)
    writeInt32(characterBase + characterMpcurrentOffset, characterInfo.characterMpcurrent)
    writeInt32(characterBase + characterSummonOffset, characterInfo.characterSummon)
    writeInt32(characterBase + characterWeaponOffset, characterInfo.characterWeapon)
    writeInt32(characterBase + characterArmorOffset, characterInfo.characterArmor)
    writeInt32(characterBase + characterAccessoryOffset, characterInfo.characterAccessory)
    characterInfo.weaponMaterias.forEachIndexed { index, materia ->
        writeInt32(characterBase + weaponMateriaOffset + (index * 4), materia)
    }
    characterInfo.armorMaterias.forEachIndexed { index, materia ->
        writeInt32(characterBase + armorMateriaOffset + (index * 4), materia)
    }
    if (characterInfo.characterMember.hasRelationship) {
        writeInt32(characterBase + characterRelationshipOffset, characterInfo.characterRelationship)
    }
    setBit(characterInfo.characterMember.statBoost01Offset, characterInfo.characterMember.statBoost01Bit, characterInfo.statBoost01)
    setBit(characterInfo.characterMember.statBoost02Offset, characterInfo.characterMember.statBoost02Bit, characterInfo.statBoost02)
    setBit(characterInfo.characterMember.statBoost03Offset, characterInfo.characterMember.statBoost03Bit, characterInfo.statBoost03)
    setBit(characterInfo.characterMember.statBoost04Offset, characterInfo.characterMember.statBoost04Bit, characterInfo.statBoost04)
    setBit(characterInfo.characterMember.statBoost05Offset, characterInfo.characterMember.statBoost05Bit, characterInfo.statBoost05)
    setBit(characterInfo.characterMember.statBoost06Offset, characterInfo.characterMember.statBoost06Bit, characterInfo.statBoost06)
    setBit(characterInfo.characterMember.statBoost07Offset, characterInfo.characterMember.statBoost07Bit, characterInfo.statBoost07)
    setBit(characterInfo.characterMember.statBoost08Offset, characterInfo.characterMember.statBoost08Bit, characterInfo.statBoost08)
    setBit(characterInfo.characterMember.statBoost09Offset, characterInfo.characterMember.statBoost09Bit, characterInfo.statBoost09)
    setBit(characterInfo.characterMember.statBoost10Offset, characterInfo.characterMember.statBoost10Bit, characterInfo.statBoost10)
    setBit(characterInfo.characterMember.statBoost11Offset, characterInfo.characterMember.statBoost11Bit, characterInfo.statBoost11)
    setBit(characterInfo.characterMember.statBoost12Offset, characterInfo.characterMember.statBoost12Bit, characterInfo.statBoost12)
    setBit(characterInfo.characterMember.statBoost13Offset, characterInfo.characterMember.statBoost13Bit, characterInfo.statBoost13)
    setBit(characterInfo.characterMember.statBoost14Offset, characterInfo.characterMember.statBoost14Bit, characterInfo.statBoost14)
    setBit(characterInfo.characterMember.statBoost15Offset, characterInfo.characterMember.statBoost15Bit, characterInfo.statBoost15)
    setBit(characterInfo.characterMember.statBoost16Offset, characterInfo.characterMember.statBoost16Bit, characterInfo.statBoost16)
    setBit(characterInfo.characterMember.statBoost17Offset, characterInfo.characterMember.statBoost17Bit, characterInfo.statBoost17)
    setBit(characterInfo.characterMember.statBoost18Offset, characterInfo.characterMember.statBoost18Bit, characterInfo.statBoost18)
    setBit(characterInfo.characterMember.statBoost19Offset, characterInfo.characterMember.statBoost19Bit, characterInfo.statBoost19)
    setBit(characterInfo.characterMember.limitBreakOffset, characterInfo.characterMember.limitBreakBit, characterInfo.limitBreak)
    setBit(characterInfo.characterMember.characterAbility01Offset, characterInfo.characterMember.characterAbility01Bit, characterInfo.characterAbility01)
    setBit(characterInfo.characterMember.characterAbility02Offset, characterInfo.characterMember.characterAbility02Bit, characterInfo.characterAbility02)
    setBit(characterInfo.characterMember.characterAbility03Offset, characterInfo.characterMember.characterAbility03Bit, characterInfo.characterAbility03)
    setBit(characterInfo.characterMember.characterAbility04Offset, characterInfo.characterMember.characterAbility04Bit, characterInfo.characterAbility04)
    setBit(characterInfo.characterMember.characterAbility05Offset, characterInfo.characterMember.characterAbility05Bit, characterInfo.characterAbility05)
    setBit(characterInfo.characterMember.synergySkill01Offset, characterInfo.characterMember.synergySkill01Bit, characterInfo.synergySkill01)
    setBit(characterInfo.characterMember.synergySkill02Offset, characterInfo.characterMember.synergySkill02Bit, characterInfo.synergySkill02)
    setBit(characterInfo.characterMember.synergySkill03Offset, characterInfo.characterMember.synergySkill03Bit, characterInfo.synergySkill03)
    setBit(characterInfo.characterMember.synergyAbility01Offset, characterInfo.characterMember.synergyAbility01Bit, characterInfo.synergyAbility01)
    setBit(characterInfo.characterMember.synergyAbility02Offset, characterInfo.characterMember.synergyAbility02Bit, characterInfo.synergyAbility02)
    setBit(characterInfo.characterMember.synergyAbility03Offset, characterInfo.characterMember.synergyAbility03Bit, characterInfo.synergyAbility03)
    setBit(characterInfo.characterMember.synergyAbility04Offset, characterInfo.characterMember.synergyAbility04Bit, characterInfo.synergyAbility04)
    setBit(characterInfo.characterMember.synergyAbility05Offset, characterInfo.characterMember.synergyAbility05Bit, characterInfo.synergyAbility05)
    setBit(characterInfo.characterMember.synergyAbility06Offset, characterInfo.characterMember.synergyAbility06Bit, characterInfo.synergyAbility06)
}

fun ByteArray.writeGeneralData(generalData: GeneralData): ByteArray = this.also { bytes ->

    bytes.writeInt32(playTimeOffset, generalData.playTime.toSeconds().toInt())
    bytes.writeInt32(bytes.gilsOffset(), generalData.totalGil)

    bytes.setBit(mainMenuOffset, mainMenuBit, generalData.mainMenu)
    bytes.setBit(extraSettingsOffset, extraSettingsBit, generalData.extraSettings)
    bytes.setBit(playLogOffset, playLogBit, generalData.playLog)
    bytes.setBit(chapterSelectionOffset, chapterSelectionBit, generalData.chapterSelection)

    bytes.setBit(chapterOneOffset, chapterOneBit, generalData.chapterOne)
    bytes.setBit(chapterTwoOffset, chapterTwoBit, generalData.chapterTwo)
    bytes.setBit(chapterThreeOffset, chapterThreeBit, generalData.chapterThree)
    bytes.setBit(chapterFourOffset, chapterFourBit, generalData.chapterFour)
    bytes.setBit(chapterFiveOffset, chapterFiveBit, generalData.chapterFive)
    bytes.setBit(chapterSixOffset, chapterSixBit, generalData.chapterSix)
    bytes.setBit(chapterSevenOffset, chapterSevenBit, generalData.chapterSeven)
    bytes.setBit(chapterEightOffset, chapterEightBit, generalData.chapterEight)
    bytes.setBit(chapterNineOffset, chapterNineBit, generalData.chapterNine)
    bytes.setBit(chapterTenOffset, chapterTenBit, generalData.chapterTen)
    bytes.setBit(chapterElevenOffset, chapterElevenBit, generalData.chapterEleven)
    bytes.setBit(chapterTwelveOffset, chapterTwelveBit, generalData.chapterTwelve)
    bytes.setBit(chapterThirteenOffset, chapterThirteenBit, generalData.chapterThirteen)
    bytes.setBit(chapterFourteenOffset, chapterFourteenBit, generalData.chapterFourteen)

    bytes.writeInt32(groupExperienceOffset, generalData.groupExperience)

    enemySkillMap.entries.map { (key, value) ->
        value.takeIf { key.get(generalData) } ?: NO_SKILL
    }.filter { it != NO_SKILL }.sortedBy { it.skillOrder }.let { skills ->
        enemySkillSlot.forEach { (key, value) ->
            bytes.writeInt32(value, skills.getOrNull(key)?.fileValue ?: NO_SKILL.fileValue)
        }
    }

    memberOutfitMap.entries.forEach { (member, outfitGetter) ->
        MemberOutfit.entries.filter { it.partyMember == member && !it.defaultOutfit }.forEach { outfit ->
            bytes.setBit(outfit.fileValue, outfit.fileBit, outfit == outfitGetter.get(generalData))
        }
    }

}

fun ByteArray.writeInt32(offset: Int, value: Int) {
    val buffer = ByteBuffer.allocate(4).order(LITTLE_ENDIAN)
    buffer.putInt(value)
    buffer.array().copyInto(this, offset)
}

fun ByteArray.writeByte(offset: Int, value: Int) {
    this[offset] = value.toByte()
}

fun ByteArray.setBit(offset: Int, bit: Int, value: Boolean) {
    val current = this[offset].toInt() and 0xFF
    this[offset] = if (value) {
        (current or (1 shl bit)).toByte()
    } else {
        (current and (1 shl bit).inv()).toByte()
    }
}
