package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableUUIDValue
import ffviirse.domain.attribute.readonly.ReadOnlyUUIDProperty
import java.util.UUID

interface ReadOnlyUUIDPropertyBase : ReadOnlyPropertyBase<UUID, ObservableUUIDValue>, ReadOnlyUUIDProperty
