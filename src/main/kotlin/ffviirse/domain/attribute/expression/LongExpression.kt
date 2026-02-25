package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.LongBinder
import ffviirse.domain.attribute.binding.LongBinding
import ffviirse.domain.attribute.observable.ObservableLongValue
import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.extension.negated
import javafx.beans.value.ObservableObjectValue

interface LongExpression : BaseNumberExpression<Long, ObservableLongValue, LongBinding>, ObservableLongValue {

    companion object {

        fun longExpression(
            value: ObservableLongValue
        ): LongExpression = longExpression(value as ObservableObjectValue<Long>)

        fun longExpression(
            value: ObservableObjectValue<Long>
        ): LongExpression = value.takeIf {
            it is LongExpression
        }?.let {
            it as LongExpression
        } ?: LongBinder(value, { it }, listOf(value))

    }

    override fun negate(): LongBinding = LongBinder(this, { it.negated() }, listOf(this))

    override fun <R : ObservableNumberValue<*>> add(value: R): LongBinding =
        LongBinder(this, { it + value.value.toLong() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> subtract(value: R): LongBinding =
        LongBinder(this, { it - value.value.toLong() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> multiply(value: R): LongBinding =
        LongBinder(this, { it * value.value.toLong() }, listOf(this, value))

    override fun <R : ObservableNumberValue<*>> divide(value: R): LongBinding =
        LongBinder(this, { it / value.value.toLong() }, listOf(this, value))

}
