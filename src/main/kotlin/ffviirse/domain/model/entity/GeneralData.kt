package ffviirse.domain.model.entity

import java.time.Duration

data class GeneralData(
    val playTime: Duration,
    val playHours: Long,
    val playMinutes: Long,
    val playSeconds: Long,
    val totalGil: Int,
)
