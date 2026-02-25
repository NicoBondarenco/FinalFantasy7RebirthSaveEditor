package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.BigIntegerExpression
import ffviirse.domain.attribute.observable.ObservableBigIntegerValue
import ffviirse.domain.attribute.readonly.property.SimpleReadOnlyBigIntegerProperty
import ffviirse.domain.extension.takeAs
import java.math.BigInteger
import javafx.beans.property.ReadOnlyProperty

interface ReadOnlyBigIntegerProperty : BaseReadOnlyProperty<BigInteger, ObservableBigIntegerValue>, BigIntegerExpression {

    companion object {
        fun readOnlyBigIntegerProperty(
            property: ReadOnlyProperty<BigInteger>
        ): ReadOnlyBigIntegerProperty = property.takeAs<ReadOnlyBigIntegerProperty>() ?: SimpleReadOnlyBigIntegerProperty(property)
    }

}
