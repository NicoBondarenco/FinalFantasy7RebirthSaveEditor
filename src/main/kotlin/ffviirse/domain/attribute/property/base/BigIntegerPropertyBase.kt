package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableBigIntegerValue
import ffviirse.domain.attribute.property.wrapper.BigIntegerWrapper
import java.math.BigInteger
import javafx.beans.value.ObservableValue

abstract class BigIntegerPropertyBase(
    value: BigInteger
) : PropertyNumberBase<BigInteger, ObservableBigIntegerValue, BigIntegerWrapper>(
    value,
    ObservableBigIntegerValue::class
){
    override fun wrapperOf(observable: ObservableValue<out BigInteger>): BigIntegerWrapper = BigIntegerWrapper(observable)
}
