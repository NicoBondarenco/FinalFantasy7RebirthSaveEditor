package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.OffsetDateTimeBinder
import ffviirse.domain.attribute.binding.OffsetDateTimeBinding
import ffviirse.domain.attribute.observable.ObservableOffsetDateTimeValue
import ffviirse.domain.extension.toZoneSameInstant
import java.time.OffsetDateTime
import java.time.ZoneId
import javafx.beans.value.ObservableObjectValue

interface OffsetDateTimeExpression : BaseTemporalExpression<OffsetDateTime, ObservableOffsetDateTimeValue, OffsetDateTimeBinding>, ObservableOffsetDateTimeValue {

    companion object {

        fun offsetDateTimeExpression(
            value: ObservableOffsetDateTimeValue
        ): OffsetDateTimeExpression = offsetDateTimeExpression(value as ObservableObjectValue<OffsetDateTime>)

        fun offsetDateTimeExpression(
            value: ObservableObjectValue<OffsetDateTime>
        ): OffsetDateTimeExpression = value.takeIf {
            it is OffsetDateTimeExpression
        }?.let {
            it as OffsetDateTimeExpression
        } ?: OffsetDateTimeBinder(value, { it }, listOf(value))

    }

    override fun toZoneSameInstant(
        zone: ZoneId
    ): OffsetDateTimeBinding = OffsetDateTimeBinder(this, { it.toZoneSameInstant(zone) }, listOf(this))

}
