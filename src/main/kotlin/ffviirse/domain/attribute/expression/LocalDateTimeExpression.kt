package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.LocalDateTimeBinder
import ffviirse.domain.attribute.binding.LocalDateTimeBinding
import ffviirse.domain.attribute.observable.ObservableLocalDateTimeValue
import ffviirse.domain.extension.toZoneSameInstant
import java.time.LocalDateTime
import java.time.ZoneId
import javafx.beans.value.ObservableObjectValue

interface LocalDateTimeExpression : BaseTemporalExpression<LocalDateTime, ObservableLocalDateTimeValue, LocalDateTimeBinding>, ObservableLocalDateTimeValue {

    companion object {

        fun localDateTimeExpression(
            value: ObservableLocalDateTimeValue
        ): LocalDateTimeExpression = localDateTimeExpression(value as ObservableObjectValue<LocalDateTime>)

        fun localDateTimeExpression(
            value: ObservableObjectValue<LocalDateTime>
        ): LocalDateTimeExpression = value.takeIf {
            it is LocalDateTimeExpression
        }?.let {
            it as LocalDateTimeExpression
        } ?: LocalDateTimeBinder(value, { it }, listOf(value))

    }

    override fun toZoneSameInstant(
        zone: ZoneId
    ): LocalDateTimeBinding = LocalDateTimeBinder(this, { it.toZoneSameInstant(zone) }, listOf(this))

}
