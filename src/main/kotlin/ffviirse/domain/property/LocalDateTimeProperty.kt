package ffviirse.domain.property

import java.time.LocalDateTime
import javafx.beans.property.SimpleObjectProperty

class LocalDateTimeProperty(value: LocalDateTime) : SimpleObjectProperty<LocalDateTime>(value)
