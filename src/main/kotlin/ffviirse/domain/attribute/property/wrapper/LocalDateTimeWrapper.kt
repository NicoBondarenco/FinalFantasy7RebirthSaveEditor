package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.LocalDateTimeBinding
import java.time.LocalDateTime
import javafx.beans.value.ObservableValue

class LocalDateTimeWrapper(
    observable: ObservableValue<out LocalDateTime>
) : BaseTemporalWrapper<LocalDateTime>(observable), LocalDateTimeBinding
