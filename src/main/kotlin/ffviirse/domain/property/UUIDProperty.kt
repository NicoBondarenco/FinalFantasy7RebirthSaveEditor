package ffviirse.domain.property

import java.util.UUID
import javafx.beans.property.SimpleObjectProperty

class UUIDProperty(value: UUID) : SimpleObjectProperty<UUID>(value)
