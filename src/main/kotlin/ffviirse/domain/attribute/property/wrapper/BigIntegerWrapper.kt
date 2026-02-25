package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.BigIntegerBinding
import java.math.BigInteger
import javafx.beans.value.ObservableValue

class BigIntegerWrapper(
    observable: ObservableValue<out BigInteger>
) : BaseNumberWrapper<BigInteger>(observable), BigIntegerBinding
