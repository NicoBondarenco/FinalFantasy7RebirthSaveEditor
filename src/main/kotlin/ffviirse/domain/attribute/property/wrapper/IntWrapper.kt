package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.IntBinding
import javafx.beans.value.ObservableValue

class IntWrapper(
    observable: ObservableValue<out Int>
) : BaseNumberWrapper<Int>(observable), IntBinding
