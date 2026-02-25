package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.BigDecimalBinder
import ffviirse.domain.attribute.binding.BigDecimalBinding
import ffviirse.domain.attribute.observable.ObservableBigDecimalValue
import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.extension.negated
import ffviirse.domain.extension.toBigDecimal
import java.math.BigDecimal
import javafx.beans.value.ObservableObjectValue

interface BigDecimalExpression : BaseNumberExpression<BigDecimal, ObservableBigDecimalValue, BigDecimalBinding>, ObservableBigDecimalValue {

    companion object {

        fun bigDecimalExpression(
            value: ObservableBigDecimalValue
        ): BigDecimalExpression = bigDecimalExpression(value as ObservableObjectValue<BigDecimal>)

        fun bigDecimalExpression(
            value: ObservableObjectValue<BigDecimal>
        ): BigDecimalExpression = value.takeIf {
            it is BigDecimalExpression
        }?.let {
            it as BigDecimalExpression
        } ?: BigDecimalBinder(value, { it }, listOf(value))

    }

    override fun negate(): BigDecimalBinding = BigDecimalBinder(this, { it.negated() }, listOf(this))

    override fun <R : ObservableNumberValue<*>> add(value: R): BigDecimalBinding =
        BigDecimalBinder(this, { it.add(value.value.toBigDecimal()) }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> subtract(value: R): BigDecimalBinding =
        BigDecimalBinder(this, { it.minus(value.value.toBigDecimal()) }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> multiply(value: R): BigDecimalBinding =
        BigDecimalBinder(this, { it.multiply(value.value.toBigDecimal()) }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> divide(value: R): BigDecimalBinding =
        BigDecimalBinder(this, { it.divide(value.value.toBigDecimal()) }, listOf(this, value))

}
