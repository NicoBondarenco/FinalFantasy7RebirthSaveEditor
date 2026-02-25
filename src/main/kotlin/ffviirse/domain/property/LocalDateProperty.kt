package ffviirse.domain.property

import java.time.LocalDate
import javafx.beans.property.SimpleObjectProperty

class LocalDateProperty(value: LocalDate) : SimpleObjectProperty<LocalDate>(value)
