package ffviirse.domain.property

import java.time.format.DateTimeFormatter
import javafx.beans.property.SimpleObjectProperty

class DateTimeFormatterProperty(value: DateTimeFormatter) : SimpleObjectProperty<DateTimeFormatter>(value)
