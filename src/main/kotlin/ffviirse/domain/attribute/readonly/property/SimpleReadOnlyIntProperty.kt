package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableIntValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyIntPropertyBase
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyIntProperty(
    property: ReadOnlyProperty<Int>
) : SimpleReadOnlyProperty<Int, ObservableIntValue>(
    property
), ReadOnlyIntPropertyBase
