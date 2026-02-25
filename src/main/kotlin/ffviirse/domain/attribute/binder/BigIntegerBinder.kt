package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.BigIntegerBinding
import java.math.BigInteger
import javafx.beans.value.ObservableObjectValue

class BigIntegerBinder<T : Number>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> BigInteger,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<BigInteger, T>(
    observableValue, valueComputer, observableValues
), BigIntegerBinding
