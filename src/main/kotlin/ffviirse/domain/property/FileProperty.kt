package ffviirse.domain.property

import java.io.File
import javafx.beans.property.SimpleObjectProperty

class FileProperty(value: File) : SimpleObjectProperty<File>(value)
