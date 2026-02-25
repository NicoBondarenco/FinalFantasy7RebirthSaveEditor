package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.BigDecimalBinding
import java.math.BigDecimal
import javafx.beans.value.ObservableObjectValue

class BigDecimalBinder<T : Number>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> BigDecimal,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<BigDecimal, T>(
    observableValue, valueComputer, observableValues
), BigDecimalBinding
