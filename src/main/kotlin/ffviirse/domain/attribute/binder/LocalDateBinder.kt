package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.LocalDateBinding
import java.time.LocalDate
import java.time.temporal.Temporal
import javafx.beans.value.ObservableObjectValue

class LocalDateBinder<T : Temporal>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> LocalDate,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<LocalDate, T>(
    observableValue, valueComputer, observableValues
), LocalDateBinding
