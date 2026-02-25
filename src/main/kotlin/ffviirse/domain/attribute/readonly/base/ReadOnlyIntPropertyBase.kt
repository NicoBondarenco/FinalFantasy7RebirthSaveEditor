package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableIntValue
import ffviirse.domain.attribute.readonly.ReadOnlyIntProperty

interface ReadOnlyIntPropertyBase : ReadOnlyPropertyBase<Int, ObservableIntValue>, ReadOnlyIntProperty
