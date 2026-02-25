package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.DoubleProperty
import ffviirse.domain.attribute.property.base.DoublePropertyBase

class SimpleDoubleProperty(
    value: Double,
    override val _bean: Any? = null,
    override val _name: String = "",
) : DoublePropertyBase(value), SimpleProperty<Double>, DoubleProperty
