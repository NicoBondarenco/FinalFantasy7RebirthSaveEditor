package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.ZonedDateTimeExpression
import java.time.ZonedDateTime

interface ZonedDateTimeBinding : ZonedDateTimeExpression, BaseBinding<ZonedDateTime>
