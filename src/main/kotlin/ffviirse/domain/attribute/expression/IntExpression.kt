package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.IntBinder
import ffviirse.domain.attribute.binding.IntBinding
import ffviirse.domain.attribute.observable.ObservableIntValue
import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.extension.negated
import javafx.beans.value.ObservableObjectValue

interface IntExpression : BaseNumberExpression<Int, ObservableIntValue, IntBinding>, ObservableIntValue {

    companion object {

        fun intExpression(
            value: ObservableIntValue
        ): IntExpression = intExpression(value as ObservableObjectValue<Int>)

        fun intExpression(
            value: ObservableObjectValue<Int>
        ): IntExpression = value.takeIf {
            it is IntExpression
        }?.let {
            it as IntExpression
        } ?: IntBinder(value, { it }, listOf(value))

    }

    override fun negate(): IntBinding = IntBinder(this, { it.negated() }, listOf(this))

    override fun <R : ObservableNumberValue<*>> add(value: R): IntBinding =
        IntBinder(this, { it + value.value.toInt() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> subtract(value: R): IntBinding =
        IntBinder(this, { it - value.value.toInt() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> multiply(value: R): IntBinding =
        IntBinder(this, { it * value.value.toInt() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> divide(value: R): IntBinding =
        IntBinder(this, { it / value.value.toInt() }, listOf(this, value))

}
