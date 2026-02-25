package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.OffsetDateTimeExpression
import ffviirse.domain.attribute.observable.ObservableOffsetDateTimeValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyOffsetDateTimeProperty
import ffviirse.domain.extension.takeAs
import java.time.OffsetDateTime
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyOffsetDateTimeProperty : BaseReadOnlyProperty<OffsetDateTime, ObservableOffsetDateTimeValue>, OffsetDateTimeExpression {

    companion object {
        fun readOnlyOffsetDateTimeProperty(
            property: ReadOnlyProperty<OffsetDateTime>
        ): ReadOnlyOffsetDateTimeProperty = property.takeAs<ReadOnlyOffsetDateTimeProperty>() ?: SimpleReadOnlyOffsetDateTimeProperty(property)
    }

}
