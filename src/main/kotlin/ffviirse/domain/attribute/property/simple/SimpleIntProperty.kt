package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.IntProperty
import ffviirse.domain.attribute.property.base.IntPropertyBase

class SimpleIntProperty(
    value: Int,
    override val _bean: Any? = null,
    override val _name: String = "",
) : IntPropertyBase(value), SimpleProperty<Int>, IntProperty
