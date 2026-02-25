package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableOffsetDateTimeValue
import ffviirse.domain.attribute.property.wrapper.OffsetDateTimeWrapper
import java.time.OffsetDateTime
import javafx.beans.value.ObservableValue

abstract class OffsetDateTimePropertyBase(
    value: OffsetDateTime
) : PropertyTemporalBase<OffsetDateTime, ObservableOffsetDateTimeValue, OffsetDateTimeWrapper>(
    value,
    ObservableOffsetDateTimeValue::class
){
    override fun wrapperOf(value: ObservableValue<out OffsetDateTime>): OffsetDateTimeWrapper = OffsetDateTimeWrapper(value)
}
