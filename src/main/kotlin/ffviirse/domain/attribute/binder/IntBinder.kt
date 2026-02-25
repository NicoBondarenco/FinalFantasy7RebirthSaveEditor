package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.IntBinding
import javafx.beans.value.ObservableObjectValue

class IntBinder<T : Number>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> Int,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<Int, T>(
    observableValue, valueComputer, observableValues
), IntBinding
