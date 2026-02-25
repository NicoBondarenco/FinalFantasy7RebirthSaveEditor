package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableNumberValue
import ffviirse.domain.attribute.property.wrapper.BaseNumberWrapper
import kotlin.reflect.KClass

abstract class PropertyNumberBase<T : Number, V : ObservableNumberValue<T>, W : BaseNumberWrapper<T>>(
    value: T,
    klass: KClass<V>,
) : PropertyBase<T, V, W>(value, klass)

