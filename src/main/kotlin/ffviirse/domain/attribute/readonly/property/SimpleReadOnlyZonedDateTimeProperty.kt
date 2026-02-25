package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableZonedDateTimeValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyZonedDateTimePropertyBase
import java.time.ZonedDateTime
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyZonedDateTimeProperty(
    property: ReadOnlyProperty<ZonedDateTime>
) : SimpleReadOnlyProperty<ZonedDateTime, ObservableZonedDateTimeValue>(
    property
), ReadOnlyZonedDateTimePropertyBase
