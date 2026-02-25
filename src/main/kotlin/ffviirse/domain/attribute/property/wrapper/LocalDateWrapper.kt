package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.LocalDateBinding
import java.time.LocalDate
import javafx.beans.value.ObservableValue

class LocalDateWrapper(
    observable: ObservableValue<out LocalDate>
) : BaseTemporalWrapper<LocalDate>(observable), LocalDateBinding
