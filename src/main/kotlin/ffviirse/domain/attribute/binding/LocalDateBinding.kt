package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.LocalDateExpression
import java.time.LocalDate

interface LocalDateBinding : LocalDateExpression, BaseBinding<LocalDate>
