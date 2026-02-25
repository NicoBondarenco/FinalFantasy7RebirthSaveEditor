package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.LocalDateTimeProperty
import ffviirse.domain.attribute.property.base.LocalDateTimePropertyBase
import java.time.LocalDateTime

class SimpleLocalDateTimeProperty(
    value: LocalDateTime,
    override val _bean: Any? = null,
    override val _name: String = "",
) : LocalDateTimePropertyBase(value), SimpleProperty<LocalDateTime>, LocalDateTimeProperty
