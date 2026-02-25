package ffviirse.domain.attribute.binding

import ffviirse.domain.attribute.expression.BigDecimalExpression
import java.math.BigDecimal

interface BigDecimalBinding : BigDecimalExpression, BaseBinding<BigDecimal>
