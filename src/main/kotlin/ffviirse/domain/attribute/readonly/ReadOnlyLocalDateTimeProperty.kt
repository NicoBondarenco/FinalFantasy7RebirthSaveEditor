package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.LocalDateTimeExpression
import ffviirse.domain.attribute.observable.ObservableLocalDateTimeValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyLocalDateTimeProperty
import ffviirse.domain.extension.takeAs
import java.time.LocalDateTime
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyLocalDateTimeProperty : BaseReadOnlyProperty<LocalDateTime, ObservableLocalDateTimeValue>, LocalDateTimeExpression {

    companion object {
        fun readOnlyLocalDateTimeProperty(
            property: ReadOnlyProperty<LocalDateTime>
        ): ReadOnlyLocalDateTimeProperty = property.takeAs<ReadOnlyLocalDateTimeProperty>() ?: SimpleReadOnlyLocalDateTimeProperty(property)
    }

}
