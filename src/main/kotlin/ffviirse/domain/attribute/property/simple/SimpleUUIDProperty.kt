package ffviirse.domain.attribute.property.simple

import ffviirse.domain.attribute.property.UUIDProperty
import ffviirse.domain.attribute.property.base.UUIDPropertyBase
import java.util.UUID

class SimpleUUIDProperty(
    value: UUID,
    override val _bean: Any? = null,
    override val _name: String = "",
) : UUIDPropertyBase(value), SimpleProperty<UUID>, UUIDProperty
