package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.LongBinding
import javafx.beans.value.ObservableObjectValue

class LongBinder<T : Number>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> Long,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<Long, T>(
    observableValue, valueComputer, observableValues
), LongBinding
