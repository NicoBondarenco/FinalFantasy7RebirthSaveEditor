package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableOffsetDateTimeValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyOffsetDateTimePropertyBase
import java.time.OffsetDateTime
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyOffsetDateTimeProperty(
    property: ReadOnlyProperty<OffsetDateTime>
) : SimpleReadOnlyProperty<OffsetDateTime, ObservableOffsetDateTimeValue>(
    property
), ReadOnlyOffsetDateTimePropertyBase
