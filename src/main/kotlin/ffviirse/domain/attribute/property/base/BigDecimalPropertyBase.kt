package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableBigDecimalValue
import ffviirse.domain.attribute.property.wrapper.BigDecimalWrapper
import java.math.BigDecimal
import javafx.beans.value.ObservableValue

abstract class BigDecimalPropertyBase(
    value: BigDecimal
) : PropertyNumberBase<BigDecimal, ObservableBigDecimalValue, BigDecimalWrapper>(
    value,
    ObservableBigDecimalValue::class
) {
    override fun wrapperOf(value: ObservableValue<out BigDecimal>): BigDecimalWrapper = BigDecimalWrapper(value)
}
