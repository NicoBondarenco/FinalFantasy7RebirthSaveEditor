package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableLongValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyLongPropertyBase
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyLongProperty(
    property: ReadOnlyProperty<Long>
) : SimpleReadOnlyProperty<Long, ObservableLongValue>(
    property
), ReadOnlyLongPropertyBase
