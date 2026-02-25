package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.LongProperty
import ffviirse.domain.attribute.property.base.LongPropertyBase

class SimpleLongProperty(
    value: Long,
    override val _bean: Any? = null,
    override val _name: String = "",
) : LongPropertyBase(value), SimpleProperty<Long>, LongProperty
