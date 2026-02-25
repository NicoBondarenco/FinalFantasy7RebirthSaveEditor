package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.ZonedDateTimeBinder
import ffviirse.domain.attribute.binding.ZonedDateTimeBinding
import ffviirse.domain.attribute.observable.ObservableZonedDateTimeValue
import ffviirse.domain.extension.toZoneSameInstant
import java.time.ZonedDateTime
import java.time.ZoneId
import javafx.beans.value.ObservableObjectValue

interface ZonedDateTimeExpression : BaseTemporalExpression<ZonedDateTime, ObservableZonedDateTimeValue, ZonedDateTimeBinding>, ObservableZonedDateTimeValue {

    companion object {

        fun zonedDateTimeExpression(
            value: ObservableZonedDateTimeValue
        ): ZonedDateTimeExpression = zonedDateTimeExpression(value as ObservableObjectValue<ZonedDateTime>)

        fun zonedDateTimeExpression(
            value: ObservableObjectValue<ZonedDateTime>
        ): ZonedDateTimeExpression = value.takeIf {
            it is ZonedDateTimeExpression
        }?.let {
            it as ZonedDateTimeExpression
        } ?: ZonedDateTimeBinder(value, { it }, listOf(value))

    }

    override fun toZoneSameInstant(
        zone: ZoneId
    ): ZonedDateTimeBinding = ZonedDateTimeBinder(this, { it.toZoneSameInstant(zone) }, listOf(this))

}
