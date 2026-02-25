package ffviirse.domain.extension

import java.math.BigDecimal
import java.math.BigInteger

fun Int.isEven() = this % 2 == 0

fun Int.isOdd() = this % 2 != 0

fun Long.isEven() = this.mod(2) == 0

fun Long.isOdd() = this.mod(2) != 0

fun Number.toBigInteger(): BigInteger = this.takeAs<BigInteger>() ?: BigInteger.valueOf(toLong())

fun Number.toBigDecimal(): BigDecimal = this.takeAs<BigDecimal>() ?: BigDecimal.valueOf(toDouble())

fun <T : Number> T.negated(): T = when (this) {
    is Int -> -this as T
    is Long -> -this as T
    is Double -> -this as T
    is Float -> -this as T
    is Short -> -this as T
    is BigInteger -> this.negate() as T
    is BigDecimal -> this.negate() as T
    else -> throw IllegalArgumentException("Unsupported number type for negation: ${this::class.simpleName}")
}
