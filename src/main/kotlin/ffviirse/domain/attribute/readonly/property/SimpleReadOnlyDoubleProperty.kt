package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableDoubleValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyDoublePropertyBase
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyDoubleProperty(
    property: ReadOnlyProperty<Double>
) : SimpleReadOnlyProperty<Double, ObservableDoubleValue>(
    property
), ReadOnlyDoublePropertyBase
