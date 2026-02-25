package ffviirse.domain.attribute.observable

import java.time.temporal.Temporal
import javafx.beans.value.ObservableObjectValue

interface ObservableTemporalValue<T : Temporal> : ObservableObjectValue<T>
