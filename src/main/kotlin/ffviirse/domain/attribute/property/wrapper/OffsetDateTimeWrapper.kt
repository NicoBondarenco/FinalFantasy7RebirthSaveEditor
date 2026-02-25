package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.OffsetDateTimeBinding
import java.time.OffsetDateTime
import javafx.beans.value.ObservableValue

class OffsetDateTimeWrapper(
    observable: ObservableValue<out OffsetDateTime>
) : BaseTemporalWrapper<OffsetDateTime>(observable), OffsetDateTimeBinding
