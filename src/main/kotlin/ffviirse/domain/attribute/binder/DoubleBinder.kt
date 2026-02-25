package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.DoubleBinding
import javafx.beans.value.ObservableObjectValue

class DoubleBinder<T : Number>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> Double,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<Double, T>(
    observableValue, valueComputer, observableValues
), DoubleBinding
