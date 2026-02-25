package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.IntExpression
import ffviirse.domain.attribute.observable.ObservableIntValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyIntProperty
import ffviirse.domain.extension.takeAs
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyIntProperty : BaseReadOnlyProperty<Int, ObservableIntValue>, IntExpression {

    companion object {
        fun readOnlyIntProperty(
            property: ReadOnlyProperty<Int>
        ): ReadOnlyIntProperty = property.takeAs<ReadOnlyIntProperty>() ?: SimpleReadOnlyIntProperty(property)
    }

}
