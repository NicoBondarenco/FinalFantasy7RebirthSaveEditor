package ffviirse.domain.model.mapper

import ffviirse.domain.model.entity.GeneralData
import java.nio.ByteBuffer
import java.time.Duration

fun ByteBuffer.generalData(bytes: ByteArray): GeneralData = this.playDuration().let {
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
    )
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
