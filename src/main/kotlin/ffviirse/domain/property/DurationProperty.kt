package ffviirse.domain.property

import java.time.Duration
import javafx.beans.property.SimpleObjectProperty

class DurationProperty(value: Duration) : SimpleObjectProperty<Duration>(value)
