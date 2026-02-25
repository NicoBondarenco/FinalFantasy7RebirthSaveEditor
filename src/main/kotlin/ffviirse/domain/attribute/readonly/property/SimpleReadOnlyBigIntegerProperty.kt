package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableBigIntegerValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyBigIntegerPropertyBase
import java.math.BigInteger
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyBigIntegerProperty(
    property: ReadOnlyProperty<BigInteger>
) : SimpleReadOnlyProperty<BigInteger, ObservableBigIntegerValue>(
    property
), ReadOnlyBigIntegerPropertyBase
