package ffviirse.domain.model.mapper

import ffviirse.domain.model.entity.GeneralData
import ffviirse.domain.model.value.EnemySkill
import ffviirse.domain.model.value.EnemySkill.GORGON_SHIELD
import ffviirse.domain.model.value.EnemySkill.MIND_BLAST
import ffviirse.domain.model.value.EnemySkill.PLASMA_DISCHARGE
import ffviirse.domain.model.value.EnemySkill.RANCID_BREATH
import ffviirse.domain.model.value.EnemySkill.SELF_DESTRUCT
import ffviirse.domain.model.value.EnemySkill.SONIC_BOOM
import ffviirse.domain.model.value.EnemySkill.SOOTHING_BREEZE
import ffviirse.domain.model.value.MemberOutfit
import ffviirse.domain.model.value.PartyMember
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI
import java.nio.ByteBuffer
import java.time.Duration

fun ByteBuffer.generalData(bytes: ByteArray): GeneralData = this.let {
    val enemySkills = this.enemySkillSet()
    val playDuration = this.playDuration()
    GeneralData(
        playTime = playDuration,
        playHours = playDuration.toHours(),
        playMinutes = playDuration.toMinutes(),
        playSeconds = playDuration.toSeconds(),
        totalGil = this.gils(bytes),
        mainMenu = bytes.unlockedMenu(mainMenuOffset, mainMenuBit),
        extraSettings = bytes.unlockedMenu(extraSettingsOffset, extraSettingsBit),
        playLog = bytes.unlockedMenu(playLogOffset, playLogBit),
        chapterSelection = bytes.unlockedMenu(chapterSelectionOffset, chapterSelectionBit),
        chapterOne = bytes.unlockedMenu(chapterOneOffset, chapterOneBit),
        chapterTwo = bytes.unlockedMenu(chapterTwoOffset, chapterTwoBit),
        chapterThree = bytes.unlockedMenu(chapterThreeOffset, chapterThreeBit),
        chapterFour = bytes.unlockedMenu(chapterFourOffset, chapterFourBit),
        chapterFive = bytes.unlockedMenu(chapterFiveOffset, chapterFiveBit),
        chapterSix = bytes.unlockedMenu(chapterSixOffset, chapterSixBit),
        chapterSeven = bytes.unlockedMenu(chapterSevenOffset, chapterSevenBit),
        chapterEight = bytes.unlockedMenu(chapterEightOffset, chapterEightBit),
        chapterNine = bytes.unlockedMenu(chapterNineOffset, chapterNineBit),
        chapterTen = bytes.unlockedMenu(chapterTenOffset, chapterTenBit),
        chapterEleven = bytes.unlockedMenu(chapterElevenOffset, chapterElevenBit),
        chapterTwelve = bytes.unlockedMenu(chapterTwelveOffset, chapterTwelveBit),
        chapterThirteen = bytes.unlockedMenu(chapterThirteenOffset, chapterThirteenBit),
        chapterFourteen = bytes.unlockedMenu(chapterFourteenOffset, chapterFourteenBit),
        groupExperience = this.getInt(groupExperienceOffset),
        rancidBreath = enemySkills.contains(RANCID_BREATH),
        plasmaDischarge = enemySkills.contains(PLASMA_DISCHARGE),
        mindBlast = enemySkills.contains(MIND_BLAST),
        gorgonShield = enemySkills.contains(GORGON_SHIELD),
        soothingBreeze = enemySkills.contains(SOOTHING_BREEZE),
        selfDestruct = enemySkills.contains(SELF_DESTRUCT),
        sonicBoom = enemySkills.contains(SONIC_BOOM),
        cloudOutfit = bytes.memberOutfit(CLOUD_STRIFE),
        barretOutfit = bytes.memberOutfit(BARRET_WALLACE),
        tifaOutfit = bytes.memberOutfit(TIFA_LOCKHART),
        aerithOutfit = bytes.memberOutfit(AERITH_GAINSBOROUGH),
        redOutfit = bytes.memberOutfit(RED_XIII),
        yuffieOutfit = bytes.memberOutfit(YUFFIE_KISARAGI),
        caitOutfit = bytes.memberOutfit(CAIT_SITH),
    )
}

private fun ByteArray.memberOutfit(member: PartyMember): MemberOutfit = MemberOutfit.entries.filter {
    it.partyMember == member && !it.defaultOutfit
}.firstOrNull {
    val byte = this[it.fileValue].toInt() and 0xFF
    (byte and (1 shl it.fileBit)) != 0
} ?: MemberOutfit.entries.first {
    it.partyMember == member && it.defaultOutfit
}

private fun ByteBuffer.enemySkillSet(): Set<EnemySkill> = this.let { buffer ->
    listOf(skillSlotOne, skillSlotTwo, skillSlotThree, skillSlotFour, skillSlotFive, skillSlotSix, skillSlotSeven).map {
        EnemySkill.byFileValue(buffer.getInt(it))
    }.distinct().toSet()
}

private fun ByteBuffer.playDuration(): Duration = Duration.ofSeconds(this.getLong(playTimeOffset) and 0xFFFFFFFFL)

private fun ByteBuffer.gils(bytes: ByteArray): Int = this.getInt(bytes.gilsOffset())

private fun ByteArray.unlockedMenu(offset: Int, bit: Int): Boolean {
    val byte = this[offset].toInt() and 0xFF
    return (byte and (1 shl bit)) != 0
}
