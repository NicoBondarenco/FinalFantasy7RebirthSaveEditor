package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.BigDecimalBinding
import java.math.BigDecimal
import javafx.beans.value.ObservableValue

class BigDecimalWrapper(
    observable: ObservableValue<out BigDecimal>
) : BaseNumberWrapper<BigDecimal>(observable), BigDecimalBinding
