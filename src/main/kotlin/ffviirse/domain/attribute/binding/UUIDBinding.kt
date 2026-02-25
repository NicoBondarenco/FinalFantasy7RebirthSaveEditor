package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.UUIDExpression
import java.util.UUID

interface UUIDBinding : UUIDExpression, BaseBinding<UUID>
