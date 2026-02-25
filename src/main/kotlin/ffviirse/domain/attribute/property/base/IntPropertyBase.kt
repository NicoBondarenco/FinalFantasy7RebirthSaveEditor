package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableIntValue
import ffviirse.domain.attribute.property.wrapper.IntWrapper
import javafx.beans.value.ObservableValue

abstract class IntPropertyBase(
    value: Int
) : PropertyNumberBase<Int, ObservableIntValue, IntWrapper>(
    value,
    ObservableIntValue::class
){
    override fun wrapperOf(value: ObservableValue<out Int>): IntWrapper = IntWrapper(value)
}
