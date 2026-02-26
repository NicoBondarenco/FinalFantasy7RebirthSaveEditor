package ffviirse.domain.model.context

import ffviirse.domain.property.FileProperty
import java.io.File

data class SaveGameContext(
    val saveFile: FileProperty = FileProperty(File("")),
    val generalData: GeneralDataContext = GeneralDataContext(),
)
