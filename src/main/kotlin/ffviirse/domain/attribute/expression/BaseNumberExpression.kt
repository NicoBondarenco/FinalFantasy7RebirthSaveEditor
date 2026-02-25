package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.BigDecimalBinder
import ffviirse.domain.attribute.binder.BigIntegerBinder
import ffviirse.domain.attribute.binder.DoubleBinder
import ffviirse.domain.attribute.binder.IntBinder
import ffviirse.domain.attribute.binder.LongBinder
import ffviirse.domain.attribute.binding.BaseBinding
import ffviirse.domain.attribute.binding.BigDecimalBinding
import ffviirse.domain.attribute.binding.BigIntegerBinding
import ffviirse.domain.attribute.binding.DoubleBinding
import ffviirse.domain.attribute.binding.IntBinding
import ffviirse.domain.attribute.binding.LongBinding
import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.extension.toBigDecimal
import ffviirse.domain.extension.toBigInteger
import java.math.BigDecimal
import java.math.BigInteger

interface BaseNumberExpression<T : Number, V : ObservableNumberValue<T>, E> : BaseExpression<T, V>
    where E : BaseNumberExpression<T, V, E>, E : BaseBinding<T> {

    fun negate(): E

    fun <R : ObservableNumberValue<*>> add(value: R): E

    fun add(value: BigDecimal): BigDecimalBinding = BigDecimalBinder(this, { this.value.toBigDecimal().add(value) }, listOf(this))

    fun add(value: BigInteger): BigIntegerBinding = BigIntegerBinder(this, { this.value.toBigInteger().add(value) }, listOf(this))

    fun add(value: Double): DoubleBinding = DoubleBinder(this, { this.value.toDouble() + value }, listOf(this))

    fun add(value: Int): IntBinding = IntBinder(this, { this.value.toInt() + value }, listOf(this))

    fun add(value: Long): LongBinding = LongBinder(this, { this.value.toLong() + value }, listOf(this))

    fun <R : ObservableNumberValue<*>> subtract(value: R): E

    fun subtract(value: BigDecimal): BigDecimalBinding = BigDecimalBinder(this, { this.value.toBigDecimal().minus(value) }, listOf(this))

    fun subtract(value: BigInteger): BigIntegerBinding = BigIntegerBinder(this, { this.value.toBigInteger().minus(value) }, listOf(this))

    fun subtract(value: Double): DoubleBinding = DoubleBinder(this, { this.value.toDouble() - value }, listOf(this))

    fun subtract(value: Int): IntBinding = IntBinder(this, { this.value.toInt() - value }, listOf(this))

    fun subtract(value: Long): LongBinding = LongBinder(this, { this.value.toLong() - value }, listOf(this))

    fun <R : ObservableNumberValue<*>> multiply(value: R): E

    fun multiply(value: BigDecimal): BigDecimalBinding = BigDecimalBinder(this, { this.value.toBigDecimal().multiply(value) }, listOf(this))

    fun multiply(value: BigInteger): BigIntegerBinding = BigIntegerBinder(this, { this.value.toBigInteger().multiply(value) }, listOf(this))

    fun multiply(value: Double): DoubleBinding = DoubleBinder(this, { this.value.toDouble() * value }, listOf(this))

    fun multiply(value: Int): IntBinding = IntBinder(this, { this.value.toInt() * value }, listOf(this))

    fun multiply(value: Long): LongBinding = LongBinder(this, { this.value.toLong() * value }, listOf(this))

    fun <R : ObservableNumberValue<*>> divide(value: R): E

    fun divide(value: BigDecimal): BigDecimalBinding = BigDecimalBinder(this, { this.value.toBigDecimal().divide(value) }, listOf(this))

    fun divide(value: BigInteger): BigIntegerBinding = BigIntegerBinder(this, { this.value.toBigInteger().divide(value) }, listOf(this))

    fun divide(value: Double): DoubleBinding = DoubleBinder(this, { this.value.toDouble() / value }, listOf(this))

    fun divide(value: Int): IntBinding = IntBinder(this, { this.value.toInt() / value }, listOf(this))

    fun divide(value: Long): LongBinding = LongBinder(this, { this.value.toLong() / value }, listOf(this))

}
