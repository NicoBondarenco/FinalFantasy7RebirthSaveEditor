package ffviirse.domain.model.mapper

import ffviirse.domain.model.entity.GeneralData
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

    bytes.writeInt32(playTimeOffset, this.generalData.playTime.toSeconds().toInt())
    bytes.writeInt32(bytes.gilsOffset(), this.generalData.totalGil)

    bytes.setBit(mainMenuOffset, mainMenuBit, this.generalData.mainMenu)
    bytes.setBit(extraSettingsOffset, extraSettingsBit, this.generalData.extraSettings)
    bytes.setBit(playLogOffset, playLogBit, this.generalData.playLog)
    bytes.setBit(chapterSelectionOffset, chapterSelectionBit, this.generalData.chapterSelection)

    bytes.setBit(chapterOneOffset, chapterOneBit, this.generalData.chapterOne)
    bytes.setBit(chapterTwoOffset, chapterTwoBit, this.generalData.chapterTwo)
    bytes.setBit(chapterThreeOffset, chapterThreeBit, this.generalData.chapterThree)
    bytes.setBit(chapterFourOffset, chapterFourBit, this.generalData.chapterFour)
    bytes.setBit(chapterFiveOffset, chapterFiveBit, this.generalData.chapterFive)
    bytes.setBit(chapterSixOffset, chapterSixBit, this.generalData.chapterSix)
    bytes.setBit(chapterSevenOffset, chapterSevenBit, this.generalData.chapterSeven)
    bytes.setBit(chapterEightOffset, chapterEightBit, this.generalData.chapterEight)
    bytes.setBit(chapterNineOffset, chapterNineBit, this.generalData.chapterNine)
    bytes.setBit(chapterTenOffset, chapterTenBit, this.generalData.chapterTen)
    bytes.setBit(chapterElevenOffset, chapterElevenBit, this.generalData.chapterEleven)
    bytes.setBit(chapterTwelveOffset, chapterTwelveBit, this.generalData.chapterTwelve)
    bytes.setBit(chapterThirteenOffset, chapterThirteenBit, this.generalData.chapterThirteen)
    bytes.setBit(chapterFourteenOffset, chapterFourteenBit, this.generalData.chapterFourteen)

    bytes.writeInt32(groupExperienceOffset, this.generalData.groupExperience)

    enemySkillMap.entries.map { (key, value) ->
        value.takeIf { key.get(this.generalData) } ?: NO_SKILL
    }.filter { it != NO_SKILL }.sortedBy { it.skillOrder }.let { skills ->
        enemySkillSlot.forEach { (key, value) ->
            bytes.writeInt32(value, skills.getOrNull(key)?.fileValue ?: NO_SKILL.fileValue)
        }
    }

    memberOutfitMap.entries.forEach { (member, outfitGetter) ->
        MemberOutfit.entries.filter { it.partyMember == member && !it.defaultOutfit }.forEach { outfit ->
            bytes.setBit(outfit.fileValue, outfit.fileBit, outfit == outfitGetter.get(this.generalData))
        }
    }

}

fun ByteArray.writeInt32(offset: Int, value: Int) {
    val buffer = ByteBuffer.allocate(4).order(LITTLE_ENDIAN)
    buffer.putInt(value)
    buffer.array().copyInto(this, offset)
}

fun ByteArray.setBit(offset: Int, bit: Int, value: Boolean) {
    val current = this[offset].toInt() and 0xFF
    this[offset] = if (value) {
        (current or (1 shl bit)).toByte()
    } else {
        (current and (1 shl bit).inv()).toByte()
    }
}
