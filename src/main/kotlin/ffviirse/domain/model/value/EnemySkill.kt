package ffviirse.domain.model.value

import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.functional.Labeled
import ffviirse.domain.model.mapper.gorgonShieldOffset
import ffviirse.domain.model.mapper.mindBlastOffset
import ffviirse.domain.model.mapper.noSkillOffset
import ffviirse.domain.model.mapper.plasmaDischargeOffset
import ffviirse.domain.model.mapper.rancidBreathOffset
import ffviirse.domain.model.mapper.selfDestructOffset
import ffviirse.domain.model.mapper.sonicBoomOffset
import ffviirse.domain.model.mapper.soothingBreezeOffset

enum class EnemySkill(
    val skillOrder: Int,
    val fileValue: Int,
    val skillLabel: () -> String,
) : Labeled {

    NO_SKILL(0, noSkillOffset, { bundleGeneralTab.skillNoSkillLabel }),
    RANCID_BREATH(1, rancidBreathOffset, { bundleGeneralTab.skillRancidBreathLabel }),
    PLASMA_DISCHARGE(2, plasmaDischargeOffset, { bundleGeneralTab.skillPlasmaDischargeLabel }),
    MIND_BLAST(3, mindBlastOffset, { bundleGeneralTab.skillMindBlastLabel }),
    GORGON_SHIELD(4, gorgonShieldOffset, { bundleGeneralTab.skillGorgonShieldLabel }),
    SOOTHING_BREEZE(5, soothingBreezeOffset, { bundleGeneralTab.skillSoothingBreezeLabel }),
    SELF_DESTRUCT(6, selfDestructOffset, { bundleGeneralTab.skillSelfDestructLabel }),
    SONIC_BOOM(7, sonicBoomOffset, { bundleGeneralTab.skillSonicBoomLabel });

    override val label: String
        get() = skillLabel()

    companion object {
        fun byFileValue(fileValue: Int): EnemySkill = entries.firstOrNull {
            it.fileValue == fileValue
        } ?: NO_SKILL
    }

}
