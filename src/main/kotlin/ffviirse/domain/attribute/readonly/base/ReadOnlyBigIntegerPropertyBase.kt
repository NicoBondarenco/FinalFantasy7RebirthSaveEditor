package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableBigIntegerValue
import ffviirse.domain.attribute.readonly.ReadOnlyBigIntegerProperty
import java.math.BigInteger

interface ReadOnlyBigIntegerPropertyBase : ReadOnlyPropertyBase<BigInteger, ObservableBigIntegerValue>, ReadOnlyBigIntegerProperty
