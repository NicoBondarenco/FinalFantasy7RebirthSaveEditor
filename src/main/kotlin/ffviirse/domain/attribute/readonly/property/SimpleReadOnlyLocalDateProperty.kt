package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableLocalDateValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyLocalDatePropertyBase
import java.time.LocalDate
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyLocalDateProperty(
    property: ReadOnlyProperty<LocalDate>
) : SimpleReadOnlyProperty<LocalDate, ObservableLocalDateValue>(
    property
), ReadOnlyLocalDatePropertyBase
