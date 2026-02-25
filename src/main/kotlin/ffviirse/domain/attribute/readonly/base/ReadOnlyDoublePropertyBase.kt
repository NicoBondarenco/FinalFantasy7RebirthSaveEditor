package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableDoubleValue
import ffviirse.domain.attribute.readonly.ReadOnlyDoubleProperty

interface ReadOnlyDoublePropertyBase : ReadOnlyPropertyBase<Double, ObservableDoubleValue>, ReadOnlyDoubleProperty
