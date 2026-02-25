package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableZonedDateTimeValue
import ffviirse.domain.attribute.property.wrapper.ZonedDateTimeWrapper
import java.time.ZonedDateTime
import javafx.beans.value.ObservableValue

abstract class ZonedDateTimePropertyBase(
    value: ZonedDateTime
) : PropertyTemporalBase<ZonedDateTime, ObservableZonedDateTimeValue, ZonedDateTimeWrapper>(
    value,
    ObservableZonedDateTimeValue::class
){
    override fun wrapperOf(value: ObservableValue<out ZonedDateTime>): ZonedDateTimeWrapper = ZonedDateTimeWrapper(value)
}
