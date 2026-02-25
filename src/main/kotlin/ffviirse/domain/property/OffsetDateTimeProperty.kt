package ffviirse.domain.property

import java.time.OffsetDateTime
import javafx.beans.property.SimpleObjectProperty

class OffsetDateTimeProperty(value: OffsetDateTime) : SimpleObjectProperty<OffsetDateTime>(value)
