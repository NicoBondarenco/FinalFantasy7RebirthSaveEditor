package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.LocalDateTimeExpression
import java.time.LocalDateTime

interface LocalDateTimeBinding : LocalDateTimeExpression, BaseBinding<LocalDateTime>
