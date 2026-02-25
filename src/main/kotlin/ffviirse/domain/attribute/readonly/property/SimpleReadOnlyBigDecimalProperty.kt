package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.observable.ObservableBigDecimalValue
import ffviirse.domain.attribute.readonly.base.ReadOnlyBigDecimalPropertyBase
import java.math.BigDecimal
import javafx.beans.property.ReadOnlyProperty

class SimpleReadOnlyBigDecimalProperty(
    property: ReadOnlyProperty<BigDecimal>
) : SimpleReadOnlyProperty<BigDecimal, ObservableBigDecimalValue>(
    property
), ReadOnlyBigDecimalPropertyBase
