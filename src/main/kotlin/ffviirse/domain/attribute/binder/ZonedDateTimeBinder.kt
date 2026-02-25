package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.ZonedDateTimeBinding
import java.time.ZonedDateTime
import java.time.temporal.Temporal
import javafx.beans.value.ObservableObjectValue

class ZonedDateTimeBinder<T : Temporal>(
    observableValue: ObservableObjectValue<T>,
    valueComputer: (T) -> ZonedDateTime,
    observableValues: List<ObservableObjectValue<*>>
) : BaseBinder<ZonedDateTime, T>(
    observableValue, valueComputer, observableValues
), ZonedDateTimeBinding
