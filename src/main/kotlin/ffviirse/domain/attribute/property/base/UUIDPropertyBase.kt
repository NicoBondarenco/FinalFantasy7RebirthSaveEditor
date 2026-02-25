package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.observable.ObservableUUIDValue
import ffviirse.domain.attribute.property.wrapper.UUIDWrapper
import java.util.UUID
import javafx.beans.value.ObservableValue

abstract class UUIDPropertyBase(
    value: UUID
) : PropertyBase<UUID, ObservableUUIDValue, UUIDWrapper>(
    value,
    ObservableUUIDValue::class
) {
    override fun wrapperOf(value: ObservableValue<out UUID>): UUIDWrapper = UUIDWrapper(value)
}
