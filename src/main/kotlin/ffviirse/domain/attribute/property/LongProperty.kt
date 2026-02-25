package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableLongValue
import ffviirse.domain.attribute.readonly.ReadOnlyLongProperty
import ffviirse.domain.attribute.writable.WritableLongPropertyValue
import javafx.beans.property.Property

interface LongProperty: BaseProperty<Long, ObservableLongValue>, ReadOnlyLongProperty, WritableLongPropertyValue, Property<Long>
