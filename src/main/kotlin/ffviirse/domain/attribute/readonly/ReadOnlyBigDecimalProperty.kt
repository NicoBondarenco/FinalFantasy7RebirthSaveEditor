package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.BigDecimalExpression
import ffviirse.domain.attribute.observable.ObservableBigDecimalValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyBigDecimalProperty
import ffviirse.domain.extension.takeAs
import java.math.BigDecimal
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyBigDecimalProperty : BaseReadOnlyProperty<BigDecimal, ObservableBigDecimalValue>, BigDecimalExpression {

    companion object {
        fun readOnlyBigDecimalProperty(
            property: ReadOnlyProperty<BigDecimal>
        ): ReadOnlyBigDecimalProperty = property.takeAs<ReadOnlyBigDecimalProperty>() ?: SimpleReadOnlyBigDecimalProperty(property)
    }

}
