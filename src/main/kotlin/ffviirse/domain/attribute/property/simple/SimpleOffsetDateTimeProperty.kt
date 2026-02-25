package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.OffsetDateTimeProperty
import ffviirse.domain.attribute.property.base.OffsetDateTimePropertyBase
import java.time.OffsetDateTime

class SimpleOffsetDateTimeProperty(
    value: OffsetDateTime,
    override val _bean: Any? = null,
    override val _name: String = "",
) : OffsetDateTimePropertyBase(value), SimpleProperty<OffsetDateTime>, OffsetDateTimeProperty
