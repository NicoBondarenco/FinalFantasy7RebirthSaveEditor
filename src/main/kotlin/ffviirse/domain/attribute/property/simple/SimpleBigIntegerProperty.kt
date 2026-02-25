package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.BigIntegerProperty
import ffviirse.domain.attribute.property.base.BigIntegerPropertyBase
import java.math.BigInteger

class SimpleBigIntegerProperty(
    value: BigInteger,
    override val _bean: Any? = null,
    override val _name: String = "",
) : BigIntegerPropertyBase(value), SimpleProperty<BigInteger>, BigIntegerProperty
