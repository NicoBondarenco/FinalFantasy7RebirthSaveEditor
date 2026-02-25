package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableLocalDateTimeValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyLocalDateTimePropertyBase
import java.time.LocalDateTime
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyLocalDateTimeProperty(
    property: ReadOnlyProperty<LocalDateTime>
) : SimpleReadOnlyProperty<LocalDateTime, ObservableLocalDateTimeValue>(
    property
), ReadOnlyLocalDateTimePropertyBase
