package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.ZonedDateTimeProperty
import ffviirse.domain.attribute.property.base.ZonedDateTimePropertyBase
import java.time.ZonedDateTime

class SimpleZonedDateTimeProperty(
    value: ZonedDateTime,
    override val _bean: Any? = null,
    override val _name: String = "",
) : ZonedDateTimePropertyBase(value), SimpleProperty<ZonedDateTime>, ZonedDateTimeProperty
