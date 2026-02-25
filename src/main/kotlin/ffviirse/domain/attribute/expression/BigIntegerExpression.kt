package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.BigIntegerBinder
import ffviirse.domain.attribute.binding.BigIntegerBinding
import ffviirse.domain.attribute.observable.ObservableBigIntegerValue
import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.extension.negated
import ffviirse.domain.extension.toBigInteger
import java.math.BigInteger
import javafx.beans.value.ObservableObjectValue

interface BigIntegerExpression : BaseNumberExpression<BigInteger, ObservableBigIntegerValue, BigIntegerBinding>, ObservableBigIntegerValue {

    companion object {

        fun bigIntegerExpression(
            value: ObservableBigIntegerValue
        ): BigIntegerExpression = bigIntegerExpression(value as ObservableObjectValue<BigInteger>)

        fun bigIntegerExpression(
            value: ObservableObjectValue<BigInteger>
        ): BigIntegerExpression = value.takeIf {
            it is BigIntegerExpression
        }?.let {
            it as BigIntegerExpression
        } ?: BigIntegerBinder(value, { it }, listOf(value))

    }

    override fun negate(): BigIntegerBinding = BigIntegerBinder(this, { it.negated() }, listOf(this))

    override fun <R : ObservableNumberValue<*>> add(value: R): BigIntegerBinding =
        BigIntegerBinder(this, { it.add(value.value.toBigInteger()) }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> subtract(value: R): BigIntegerBinding =
        BigIntegerBinder(this, { it.minus(value.value.toBigInteger()) }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> multiply(value: R): BigIntegerBinding =
        BigIntegerBinder(this, { it.multiply(value.value.toBigInteger()) }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> divide(value: R): BigIntegerBinding =
        BigIntegerBinder(this, { it.divide(value.value.toBigInteger()) }, listOf(this, value))

}
