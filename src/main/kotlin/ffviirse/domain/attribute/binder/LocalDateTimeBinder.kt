package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.LocalDateTimeBinding
import java.time.LocalDateTime
import java.time.temporal.Temporal
import javafx.beans.value.ObservableObjectValue

class LocalDateTimeBinder<T : Temporal>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> LocalDateTime,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<LocalDateTime, T>(
    observableValue, valueComputer, observableValues
), LocalDateTimeBinding
