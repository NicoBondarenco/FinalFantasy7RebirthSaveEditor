package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableBigDecimalValue
import ffviirse.domain.attribute.readonly.ReadOnlyBigDecimalProperty
import java.math.BigDecimal

interface ReadOnlyBigDecimalPropertyBase : ReadOnlyPropertyBase<BigDecimal, ObservableBigDecimalValue>, ReadOnlyBigDecimalProperty
