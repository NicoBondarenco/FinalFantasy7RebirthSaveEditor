package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.ZonedDateTimeExpression
import ffviirse.domain.attribute.observable.ObservableZonedDateTimeValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyZonedDateTimeProperty
import ffviirse.domain.extension.takeAs
import java.time.ZonedDateTime
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyZonedDateTimeProperty : BaseReadOnlyProperty<ZonedDateTime, ObservableZonedDateTimeValue>, ZonedDateTimeExpression {

    companion object {
        fun readOnlyZonedDateTimeProperty(
            property: ReadOnlyProperty<ZonedDateTime>
        ): ReadOnlyZonedDateTimeProperty = property.takeAs<ReadOnlyZonedDateTimeProperty>() ?: SimpleReadOnlyZonedDateTimeProperty(property)
    }

}
