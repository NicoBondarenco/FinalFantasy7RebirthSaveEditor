package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableTemporalValue
import ffviirse.domain.attribute.property.wrapper.BaseTemporalWrapper
import java.time.temporal.Temporal
import kotlin.reflect.KClass

abstract class PropertyTemporalBase<T : Temporal, V : ObservableTemporalValue<T>, W : BaseTemporalWrapper<T>>(
    value: T,
    klass: KClass<V>,
) : PropertyBase<T, V, W>(value, klass)
