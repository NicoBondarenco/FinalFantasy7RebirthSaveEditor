package ffviirse.domain.model.value

import ffviirse.domain.functional.Labeled

enum class PartyMember(
    val memberName: String,
): Labeled {

    CLOUD_STRIFE("Cloud Strife"),
    BARRET_WALLACE("Barret Wallace"),
    TIFA_LOCKHART("Tifa Lockhart"),
    AERITH_GAINSBOROUGH("Aerith Gainsborough"),
    RED_XIII("Red XIII"),
    YUFFIE_KISARAGI("Yuffie Kisaragi"),
    CAIT_SITH("Cait Sith");

    override val label: String
        get() = memberName

}
