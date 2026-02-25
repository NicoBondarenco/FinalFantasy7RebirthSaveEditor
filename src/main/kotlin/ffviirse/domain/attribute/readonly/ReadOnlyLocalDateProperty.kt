package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.LocalDateExpression
import ffviirse.domain.attribute.observable.ObservableLocalDateValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyLocalDateProperty
import ffviirse.domain.extension.takeAs
import java.time.LocalDate
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyLocalDateProperty : BaseReadOnlyProperty<LocalDate, ObservableLocalDateValue>, LocalDateExpression {

    companion object {
        fun readOnlyLocalDateProperty(
            property: ReadOnlyProperty<LocalDate>
        ): ReadOnlyLocalDateProperty = property.takeAs<ReadOnlyLocalDateProperty>() ?: SimpleReadOnlyLocalDateProperty(property)
    }

}
