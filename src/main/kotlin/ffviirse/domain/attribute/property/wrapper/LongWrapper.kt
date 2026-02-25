package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.LongBinding
import javafx.beans.value.ObservableValue

class LongWrapper(
    observable: ObservableValue<out Long>
) : BaseNumberWrapper<Long>(observable), LongBinding
