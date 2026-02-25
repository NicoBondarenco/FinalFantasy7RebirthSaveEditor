package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableUUIDValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyUUIDPropertyBase
import java.util.UUID
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyUUIDProperty(
    property: ReadOnlyProperty<UUID>
) : SimpleReadOnlyProperty<UUID, ObservableUUIDValue>(
    property
), ReadOnlyUUIDPropertyBase
