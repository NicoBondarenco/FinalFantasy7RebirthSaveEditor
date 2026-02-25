package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableLocalDateValue
import ffviirse.domain.attribute.readonly.ReadOnlyLocalDateProperty
import ffviirse.domain.attribute.writable.WritableLocalDatePropertyValue
import java.time.LocalDate
import javafx.beans.property.Property

interface LocalDateProperty: BaseProperty<LocalDate, ObservableLocalDateValue>, ReadOnlyLocalDateProperty, WritableLocalDatePropertyValue, Property<LocalDate>
