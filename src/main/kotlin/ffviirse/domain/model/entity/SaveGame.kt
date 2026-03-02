package ffviirse.domain.model.entity

import ffviirse.domain.functional.Labeled
import java.io.File

data class SaveGame(
    val saveFile: File = File(""),
    val generalData: GeneralData = GeneralData(),
    val partyInfo: PartyInfo = PartyInfo(),
) : Labeled {
    override val label: String
        get() = saveFile.nameWithoutExtension
}
