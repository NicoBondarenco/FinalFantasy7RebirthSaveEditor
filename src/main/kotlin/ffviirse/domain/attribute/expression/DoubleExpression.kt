package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.DoubleBinder
import ffviirse.domain.attribute.binding.DoubleBinding
import ffviirse.domain.attribute.observable.ObservableDoubleValue
import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.extension.negated
import javafx.beans.value.ObservableObjectValue

interface DoubleExpression : BaseNumberExpression<Double, ObservableDoubleValue, DoubleBinding>, ObservableDoubleValue {

    companion object {

        fun longExpression(
            value: ObservableDoubleValue
        ): DoubleExpression = longExpression(value as ObservableObjectValue<Double>)

        fun longExpression(
            value: ObservableObjectValue<Double>
        ): DoubleExpression = value.takeIf {
            it is DoubleExpression
        }?.let {
            it as DoubleExpression
        } ?: DoubleBinder(value, { it }, listOf(value))

    }

    override fun negate(): DoubleBinding = DoubleBinder(this, { it.negated() }, listOf(this))

    override fun <R : ObservableNumberValue<*>> add(value: R): DoubleBinding =
        DoubleBinder(this, { it + value.value.toDouble() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> subtract(value: R): DoubleBinding =
        DoubleBinder(this, { it - value.value.toDouble() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> multiply(value: R): DoubleBinding =
        DoubleBinder(this, { it * value.value.toDouble() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> divide(value: R): DoubleBinding =
        DoubleBinder(this, { it / value.value.toDouble() }, listOf(this, value))

}
