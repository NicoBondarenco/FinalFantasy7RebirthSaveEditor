package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableDoubleValue
import ffviirse.domain.attribute.property.wrapper.DoubleWrapper
import javafx.beans.value.ObservableValue

abstract class DoublePropertyBase(
    value: Double
) : PropertyNumberBase<Double, ObservableDoubleValue, DoubleWrapper>(
    value,
    ObservableDoubleValue::class
) {
    override fun wrapperOf(value: ObservableValue<out Double>): DoubleWrapper = DoubleWrapper(value)
}
