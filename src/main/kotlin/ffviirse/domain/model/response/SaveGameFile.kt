package ffviirse.domain.model.response

import ffviirse.domain.functional.Labeled
import java.io.File

data class SaveGameFile(
    val saveFile: File,
): Labeled {
    override val label: String
        get() = saveFile.nameWithoutExtension
}
