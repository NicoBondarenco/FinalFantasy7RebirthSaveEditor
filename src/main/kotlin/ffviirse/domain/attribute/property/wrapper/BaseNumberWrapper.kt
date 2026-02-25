package ffviirse.domain.attribute.property.wrapper

import javafx.beans.value.ObservableValue

abstract class BaseNumberWrapper<T : Number>(
    observable: ObservableValue<out T>
) : BaseWrapper<T>(observable)
