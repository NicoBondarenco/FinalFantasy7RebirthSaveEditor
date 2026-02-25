package ffviirse.domain.extension

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZoneOffset.UTC
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

private val FILE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSSSSSSSS")

fun nullZonedDateTime(): ZonedDateTime = ZonedDateTime.of(1970, 1, 1, 0, 0, 0, 0, UTC)

fun currentZonedDateTime(): ZonedDateTime = ZonedDateTime.now(UTC)

fun fileCurrentDateTime(): String = FILE_FORMATTER.format(LocalDateTime.now())

fun <T : Temporal> T.isAfterOf(temporal: Temporal): Boolean = this.asZonedDateTime().isAfter(temporal.asZonedDateTime())

fun <T : Temporal> T.isAfterOrSame(temporal: Temporal): Boolean = this.isAfterOf(temporal) || this.isSameInstant(temporal)

fun <T : Temporal> T.isBeforeOf(temporal: Temporal): Boolean = this.asZonedDateTime().isBefore(temporal.asZonedDateTime())

fun <T : Temporal> T.isBeforeOrSame(temporal: Temporal): Boolean = this.isBeforeOf(temporal) || this.isSameInstant(temporal)

fun <T : Temporal> T.isSameInstant(temporal: Temporal): Boolean = this.asZonedDateTime().isEqual(temporal.asZonedDateTime())

fun <T : Temporal, R : T> T.toZoneSameInstant(zone: ZoneId): R = when (this) {
    is LocalDateTime -> this.asZonedDateTime().withZoneSameInstant(zone).toLocalDateTime() as R
    is LocalDate -> this.asZonedDateTime().withZoneSameInstant(zone).toLocalDate() as R
    is OffsetDateTime -> this.asZonedDateTime().withZoneSameInstant(zone).toOffsetDateTime() as R
    is ZonedDateTime -> this.asZonedDateTime().withZoneSameInstant(zone) as R
    else -> throw IllegalArgumentException("Unsupported temporal type: ${this::class.simpleName}")
}

fun <T : Temporal> T.asLocalDateTime(): LocalDateTime = when (this) {
    is LocalDateTime -> this
    is LocalDate -> this.atStartOfDay()
    is OffsetDateTime -> this.toLocalDateTime()
    is ZonedDateTime -> this.toLocalDateTime()
    else -> throw IllegalArgumentException("Unsupported temporal type: ${this::class.simpleName}")
}

fun <T : Temporal> T.asLocalDate(): LocalDate = when (this) {
    is LocalDateTime -> this.toLocalDate()
    is LocalDate -> this
    is OffsetDateTime -> this.toLocalDate()
    is ZonedDateTime -> this.toLocalDate()
    else -> throw IllegalArgumentException("Unsupported temporal type: ${this::class.simpleName}")
}

fun <T : Temporal> T.asOffsetDateTime(): OffsetDateTime = when (this) {
    is LocalDateTime -> this.atZone(ZoneOffset.systemDefault()).toOffsetDateTime()
    is LocalDate -> this.atStartOfDay().asOffsetDateTime()
    is OffsetDateTime -> this
    is ZonedDateTime -> this.toOffsetDateTime()
    else -> throw IllegalArgumentException("Unsupported temporal type: ${this::class.simpleName}")
}

fun <T : Temporal> T.asZonedDateTime(): ZonedDateTime = when (this) {
    is LocalDateTime -> this.atZone(ZoneOffset.systemDefault())
    is LocalDate -> this.atStartOfDay().asZonedDateTime()
    is OffsetDateTime -> this.toZonedDateTime()
    is ZonedDateTime -> this
    else -> throw IllegalArgumentException("Unsupported temporal type: ${this::class.simpleName}")
}
