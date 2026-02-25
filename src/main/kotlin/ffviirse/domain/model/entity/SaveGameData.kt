package ffviirse.domain.model.entity

import ffviirse.domain.functional.Labeled
import java.io.File

data class SaveGameData(
    val saveFile: File = File(""),
    val generalData: GeneralData = GeneralData(),
) : Labeled {
    override val label: String
        get() = saveFile.nameWithoutExtension
}
