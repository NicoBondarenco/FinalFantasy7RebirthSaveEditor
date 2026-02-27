package ffviirse.domain.model.value

import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.functional.Labeled

enum class EnemySkill(
    val fileValue: Int,
    val skillLabel: () -> String,
) : Labeled {

    NO_SKILL(0x00000, { bundleGeneralTab.skillNoSkillLabel }),
    RANCID_BREATH(0x3B3C0, { bundleGeneralTab.skillRancidBreathLabel }),
    PLASMA_DISCHARGE(0x48B53, { bundleGeneralTab.skillPlasmaDischargeLabel }),
    MIND_BLAST(0x66C44, { bundleGeneralTab.skillMindBlastLabel }),
    GORGON_SHIELD(0xD31E9, { bundleGeneralTab.skillGorgonShieldLabel }),
    SOOTHING_BREEZE(0x108473, { bundleGeneralTab.skillSoothingBreezeLabel }),
    SELF_DESTRUCT(0x14DD84, { bundleGeneralTab.skillSelfDestructLabel }),
    SONIC_BOOM(0x15C8C4, { bundleGeneralTab.skillSonicBoomLabel });

    override val label: String
        get() = skillLabel()

    companion object {
        fun byFileValue(fileValue: Int): EnemySkill = entries.firstOrNull {
            it.fileValue == fileValue
        } ?: NO_SKILL
    }

}
