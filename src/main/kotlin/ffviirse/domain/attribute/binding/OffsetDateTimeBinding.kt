package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.OffsetDateTimeExpression
import java.time.OffsetDateTime

interface OffsetDateTimeBinding : OffsetDateTimeExpression, BaseBinding<OffsetDateTime>
