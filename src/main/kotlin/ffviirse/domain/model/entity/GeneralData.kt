package ffviirse.domain.model.entity

import java.time.Duration

data class GeneralData(
    val playTime: Duration = Duration.ZERO,
    val playHours: Long = 0,
    val playMinutes: Long = 0,
    val playSeconds: Long = 0,
    val totalGil: Int = 0,
    val mainMenu: Boolean = false,
    val extraSettings: Boolean = false,
    val playLog: Boolean = false,
    val chapterSelection: Boolean = false,
    val chapterOne: Boolean = false,
    val chapterTwo: Boolean = false,
    val chapterThree: Boolean = false,
    val chapterFour: Boolean = false,
    val chapterFive: Boolean = false,
    val chapterSix: Boolean = false,
    val chapterSeven: Boolean = false,
    val chapterEight: Boolean = false,
    val chapterNine: Boolean = false,
    val chapterTen: Boolean = false,
    val chapterEleven: Boolean = false,
    val chapterTwelve: Boolean = false,
    val chapterThirteen: Boolean = false,
    val chapterFourteen: Boolean = false,
)
