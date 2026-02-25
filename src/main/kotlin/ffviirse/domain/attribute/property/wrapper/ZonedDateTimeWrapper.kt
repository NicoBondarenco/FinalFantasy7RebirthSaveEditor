package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.ZonedDateTimeBinding
import java.time.ZonedDateTime
import javafx.beans.value.ObservableValue

class ZonedDateTimeWrapper(
    observable: ObservableValue<out ZonedDateTime>
) : BaseTemporalWrapper<ZonedDateTime>(observable), ZonedDateTimeBinding
