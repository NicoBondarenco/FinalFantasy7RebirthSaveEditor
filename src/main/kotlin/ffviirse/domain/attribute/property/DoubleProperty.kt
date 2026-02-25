package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableDoubleValue
import ffviirse.domain.attribute.readonly.ReadOnlyDoubleProperty
import ffviirse.domain.attribute.writable.WritableDoublePropertyValue
import javafx.beans.property.Property

interface DoubleProperty: BaseProperty<Double, ObservableDoubleValue>, ReadOnlyDoubleProperty, WritableDoublePropertyValue, Property<Double>
