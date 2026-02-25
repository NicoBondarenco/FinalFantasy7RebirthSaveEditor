package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableLocalDateValue
import ffviirse.domain.attribute.property.wrapper.LocalDateWrapper
import java.time.LocalDate
import javafx.beans.value.ObservableValue

abstract class LocalDatePropertyBase(
    value: LocalDate
) : PropertyTemporalBase<LocalDate, ObservableLocalDateValue, LocalDateWrapper>(
    value,
    ObservableLocalDateValue::class
){
    override fun wrapperOf(value: ObservableValue<out LocalDate>): LocalDateWrapper = LocalDateWrapper(value)
}
