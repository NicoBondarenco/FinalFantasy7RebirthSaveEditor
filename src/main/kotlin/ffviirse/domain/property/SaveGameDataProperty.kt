package ffviirse.domain.property

import ffviirse.domain.model.entity.SaveGame
import javafx.beans.property.SimpleObjectProperty

class SaveGameDataProperty(value: SaveGame) : SimpleObjectProperty<SaveGame>(value)
