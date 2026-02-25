package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.UUIDExpression
import ffviirse.domain.attribute.observable.ObservableUUIDValue
import java.util.UUID

interface ReadOnlyUUIDProperty : BaseReadOnlyProperty<UUID, ObservableUUIDValue>, UUIDExpression
