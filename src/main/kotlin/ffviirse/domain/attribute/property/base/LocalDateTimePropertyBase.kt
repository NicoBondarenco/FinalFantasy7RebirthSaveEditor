package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableLocalDateTimeValue
import ffviirse.domain.attribute.property.wrapper.LocalDateTimeWrapper
import java.time.LocalDateTime
import javafx.beans.value.ObservableValue

abstract class LocalDateTimePropertyBase(
    value: LocalDateTime
) : PropertyTemporalBase<LocalDateTime, ObservableLocalDateTimeValue, LocalDateTimeWrapper>(
    value,
    ObservableLocalDateTimeValue::class
){
    override fun wrapperOf(value: ObservableValue<out LocalDateTime>): LocalDateTimeWrapper = LocalDateTimeWrapper(value)
}
