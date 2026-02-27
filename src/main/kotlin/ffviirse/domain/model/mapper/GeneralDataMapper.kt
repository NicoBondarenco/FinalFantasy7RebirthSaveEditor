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

fun ByteBuffer.generalData(bytes: ByteArray): GeneralData = this.playDuration().let {
    val enemySkills = this.enemySkillSet()
    GeneralData(
        playTime = it,
        playHours = it.toHours(),
        playMinutes = it.toMinutes(),
        playSeconds = it.toSeconds(),
        totalGil = this.gils(bytes),
        mainMenu = bytes.unlockedMenu(0x44AB1, 0),
        extraSettings = bytes.unlockedMenu(0x4493A, 2),
        playLog = bytes.unlockedMenu(0x4493A, 2),
        chapterSelection = bytes.unlockedMenu(0x44D2C, 4),
        chapterOne = bytes.unlockedMenu(0x448C8, 6),
        chapterTwo = bytes.unlockedMenu(0x448C8, 7),
        chapterThree = bytes.unlockedMenu(0x448C9, 0),
        chapterFour = bytes.unlockedMenu(0x448C9, 1),
        chapterFive = bytes.unlockedMenu(0x448C9, 2),
        chapterSix = bytes.unlockedMenu(0x448C9, 3),
        chapterSeven = bytes.unlockedMenu(0x448C9, 4),
        chapterEight = bytes.unlockedMenu(0x448C9, 5),
        chapterNine = bytes.unlockedMenu(0x448C9, 6),
        chapterTen = bytes.unlockedMenu(0x448C9, 7),
        chapterEleven = bytes.unlockedMenu(0x448CA, 0),
        chapterTwelve = bytes.unlockedMenu(0x448CA, 1),
        chapterThirteen = bytes.unlockedMenu(0x448CA, 2),
        chapterFourteen = bytes.unlockedMenu(0x448CA, 3),
        groupExperience = this.getInt(0x4EEC4),
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
    listOf(0x4472C, 0x44730, 0x44734, 0x44738, 0x4473C, 0x44740, 0x44744).map {
        EnemySkill.byFileValue(buffer.getInt(it))
    }.distinct().toSet()
}

private fun ByteBuffer.playDuration(): Duration = Duration.ofSeconds(this.getLong(0x3C30) and 0xFFFFFFFFL)

private fun ByteBuffer.gils(bytes: ByteArray): Int {
    val tableBaseOffset = 0x4FA70
    val entrySize = 0x20
    var gil = 0

    for (i in 0 until 0x800) {
        val currentOffset = tableBaseOffset + (i * entrySize)
        if (currentOffset + 8 > bytes.size) break

        val id = this.getInt(currentOffset)
        if (id == 1) {
            gil = this.getInt(currentOffset + 4)
            break
        }
    }
    return gil
}

private fun ByteArray.unlockedMenu(offset: Int, bit: Int): Boolean {
    val byte = this[offset].toInt() and 0xFF
    return (byte and (1 shl bit)) != 0
}
