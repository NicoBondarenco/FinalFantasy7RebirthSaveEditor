package ffviirse.domain.attribute.property.wrapper

import java.time.temporal.Temporal
import javafx.beans.value.ObservableValue

abstract class BaseTemporalWrapper<T : Temporal>(
    observable: ObservableValue<out T>
) : BaseWrapper<T>(observable)
