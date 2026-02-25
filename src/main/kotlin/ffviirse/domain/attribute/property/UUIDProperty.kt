package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableUUIDValue
import ffviirse.domain.attribute.readonly.ReadOnlyUUIDProperty
import ffviirse.domain.attribute.writable.WritableUUIDPropertyValue
import java.util.UUID
import javafx.beans.property.Property

interface UUIDProperty: BaseProperty<UUID, ObservableUUIDValue>,ReadOnlyUUIDProperty, WritableUUIDPropertyValue, Property<UUID>
