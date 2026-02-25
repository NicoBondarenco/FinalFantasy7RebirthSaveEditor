package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.UUIDBinding
import java.util.UUID
import javafx.beans.value.ObservableObjectValue

class UUIDBinder<T>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> UUID,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<UUID, T>(
    observableValue, valueComputer, observableValues
), UUIDBinding
