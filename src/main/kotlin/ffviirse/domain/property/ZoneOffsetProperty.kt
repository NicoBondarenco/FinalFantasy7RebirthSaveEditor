package ffviirse.domain.property

import java.time.ZoneOffset
import javafx.beans.property.SimpleObjectProperty

class ZoneOffsetProperty(value: ZoneOffset) : SimpleObjectProperty<ZoneOffset>(value)
