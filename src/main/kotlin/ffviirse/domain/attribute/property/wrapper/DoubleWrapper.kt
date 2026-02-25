package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.DoubleBinding
import javafx.beans.value.ObservableValue

class DoubleWrapper(
    observable: ObservableValue<out Double>
) : BaseNumberWrapper<Double>(observable), DoubleBinding
