package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableIntValue
import ffviirse.domain.attribute.readonly.ReadOnlyIntProperty
import ffviirse.domain.attribute.writable.WritableIntPropertyValue
import javafx.beans.property.Property

interface IntProperty: BaseProperty<Int, ObservableIntValue>, ReadOnlyIntProperty, WritableIntPropertyValue, Property<Int>
