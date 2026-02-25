package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.DoubleExpression
import ffviirse.domain.attribute.observable.ObservableDoubleValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyDoubleProperty
import ffviirse.domain.extension.takeAs
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyDoubleProperty : BaseReadOnlyProperty<Double, ObservableDoubleValue>, DoubleExpression {

    companion object {
        fun readOnlyDoubleProperty(
            property: ReadOnlyProperty<Double>
        ): ReadOnlyDoubleProperty = property.takeAs<ReadOnlyDoubleProperty>() ?: SimpleReadOnlyDoubleProperty(property)
    }

}
