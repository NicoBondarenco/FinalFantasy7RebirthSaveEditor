package ffviirse.domain.property

import java.time.ZonedDateTime
import javafx.beans.property.SimpleObjectProperty

class ZonedDateTimeProperty(value: ZonedDateTime) : SimpleObjectProperty<ZonedDateTime>(value)
