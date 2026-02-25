package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.LongExpression
import ffviirse.domain.attribute.observable.ObservableLongValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyLongProperty
import ffviirse.domain.extension.takeAs
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyLongProperty : BaseReadOnlyProperty<Long, ObservableLongValue>, LongExpression {

    companion object {
        fun readOnlyLongProperty(
            property: ReadOnlyProperty<Long>
        ): ReadOnlyLongProperty = property.takeAs<ReadOnlyLongProperty>() ?: SimpleReadOnlyLongProperty(property)
    }

}
