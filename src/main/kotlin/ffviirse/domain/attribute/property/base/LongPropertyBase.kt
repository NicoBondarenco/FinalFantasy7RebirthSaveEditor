package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableLongValue
import ffviirse.domain.attribute.property.wrapper.LongWrapper
import javafx.beans.value.ObservableValue

abstract class LongPropertyBase(
    value: Long
) : PropertyNumberBase<Long, ObservableLongValue, LongWrapper>(
    value,
    ObservableLongValue::class
){
    override fun wrapperOf(value: ObservableValue<out Long>): LongWrapper = LongWrapper(value)
}
