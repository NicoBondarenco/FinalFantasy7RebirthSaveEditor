package ffviirse.domain.model.mapper

import java.nio.ByteBuffer
import java.nio.ByteOrder.LITTLE_ENDIAN

val playTimeOffset: Int = 0x3C30

val gilBaseOffset: Int = 0x4FA70
val gilEntrySize = 0x20

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

fun ByteArray.gilsOffset(): Int {
    val buffer = ByteBuffer.wrap(this).order(LITTLE_ENDIAN)
    val tableBaseOffset = 0x4FA70
    val entrySize = 0x20

    for (i in 0 until 0x800) {
        val currentOffset = tableBaseOffset + (i * entrySize)
        if (currentOffset + 8 > this.size) break

        val id = buffer.getInt(currentOffset)
        if (id == 1) {
            return currentOffset + 4
        }
    }
    return tableBaseOffset
}
