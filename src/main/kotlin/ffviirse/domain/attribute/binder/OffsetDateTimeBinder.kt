package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.OffsetDateTimeBinding
import java.time.OffsetDateTime
import java.time.temporal.Temporal
import javafx.beans.value.ObservableObjectValue

class OffsetDateTimeBinder<T : Temporal>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> OffsetDateTime,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<OffsetDateTime, T>(
    observableValue, valueComputer, observableValues
), OffsetDateTimeBinding
