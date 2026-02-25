package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableLongValue
import ffviirse.domain.attribute.readonly.ReadOnlyLongProperty

interface ReadOnlyLongPropertyBase : ReadOnlyPropertyBase<Long, ObservableLongValue>, ReadOnlyLongProperty
