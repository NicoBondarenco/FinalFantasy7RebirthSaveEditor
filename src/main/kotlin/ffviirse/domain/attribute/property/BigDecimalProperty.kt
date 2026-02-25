package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableBigDecimalValue
import ffviirse.domain.attribute.readonly.ReadOnlyBigDecimalProperty
import ffviirse.domain.attribute.writable.WritableBigDecimalPropertyValue
import java.math.BigDecimal
import javafx.beans.property.Property

interface BigDecimalProperty: BaseProperty<BigDecimal, ObservableBigDecimalValue>, ReadOnlyBigDecimalProperty, WritableBigDecimalPropertyValue, Property<BigDecimal>
