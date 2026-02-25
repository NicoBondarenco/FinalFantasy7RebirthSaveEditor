package ffviirse.domain.model.entity

import java.time.Duration

data class GeneralData(
    val playTime: Duration = Duration.ZERO,
    val playHours: Long = 0,
    val playMinutes: Long = 0,
    val playSeconds: Long = 0,
    val totalGil: Int = 0,
)
