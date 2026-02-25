package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.LocalDateProperty
import ffviirse.domain.attribute.property.base.LocalDatePropertyBase
import java.time.LocalDate

class SimpleLocalDateProperty(
    value: LocalDate,
    override val _bean: Any? = null,
    override val _name: String = "",
) : LocalDatePropertyBase(value), SimpleProperty<LocalDate>, LocalDateProperty
