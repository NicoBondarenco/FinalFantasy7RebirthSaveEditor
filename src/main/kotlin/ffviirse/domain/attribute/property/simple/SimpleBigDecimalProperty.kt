package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.BigDecimalProperty
import ffviirse.domain.attribute.property.base.BigDecimalPropertyBase
import java.math.BigDecimal

class SimpleBigDecimalProperty(
    value: BigDecimal,
    override val _bean: Any? = null,
    override val _name: String = "",
) : BigDecimalPropertyBase(value), SimpleProperty<BigDecimal>, BigDecimalProperty
