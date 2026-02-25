package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.BigIntegerExpression
import java.math.BigInteger

interface BigIntegerBinding : BigIntegerExpression, BaseBinding<BigInteger>
