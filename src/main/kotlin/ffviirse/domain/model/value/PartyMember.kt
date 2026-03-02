package ffviirse.domain.model.value

import ffviirse.domain.functional.Labeled

enum class PartyMember(
    val fileIndex: Int,
    val memberName: String,
    val hasRelationship: Boolean,
) : Labeled {

    CLOUD_STRIFE(0, "Cloud Strife", false),
    BARRET_WALLACE(1, "Barret Wallace", true),
    TIFA_LOCKHART(2, "Tifa Lockhart", true),
    AERITH_GAINSBOROUGH(3, "Aerith Gainsborough", true),
    RED_XIII(4, "Red XIII", true),
    YUFFIE_KISARAGI(5, "Yuffie Kisaragi", true),
    CAIT_SITH(6, "Cait Sith", false);

    override val label: String
        get() = memberName

}
