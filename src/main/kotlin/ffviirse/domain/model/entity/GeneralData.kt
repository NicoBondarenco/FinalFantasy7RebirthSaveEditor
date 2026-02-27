package ffviirse.domain.model.entity

import ffviirse.domain.model.value.MemberOutfit
import ffviirse.domain.model.value.MemberOutfit.AERITH_INDEPENDENT_FLORIST
import ffviirse.domain.model.value.MemberOutfit.BARRET_AVALANCHE_LEADER
import ffviirse.domain.model.value.MemberOutfit.CAIT_FORTUNE_TELLER
import ffviirse.domain.model.value.MemberOutfit.CLOUD_EX_SOLDIER
import ffviirse.domain.model.value.MemberOutfit.REDXIII_LABORATORY_ESCAPEE
import ffviirse.domain.model.value.MemberOutfit.TIFA_SEVENTH_HEAVEN
import ffviirse.domain.model.value.MemberOutfit.YUFFIE_MATERIA_HUNTER
import java.time.Duration

data class GeneralData(
    val playTime: Duration = Duration.ZERO,
    val playHours: Long = 0,
    val playMinutes: Long = 0,
    val playSeconds: Long = 0,
    val totalGil: Int = 0,
    val mainMenu: Boolean = false,
    val extraSettings: Boolean = false,
    val playLog: Boolean = false,
    val chapterSelection: Boolean = false,
    val chapterOne: Boolean = false,
    val chapterTwo: Boolean = false,
    val chapterThree: Boolean = false,
    val chapterFour: Boolean = false,
    val chapterFive: Boolean = false,
    val chapterSix: Boolean = false,
    val chapterSeven: Boolean = false,
    val chapterEight: Boolean = false,
    val chapterNine: Boolean = false,
    val chapterTen: Boolean = false,
    val chapterEleven: Boolean = false,
    val chapterTwelve: Boolean = false,
    val chapterThirteen: Boolean = false,
    val chapterFourteen: Boolean = false,
    val groupExperience: Int = 0,
    val rancidBreath: Boolean = false,
    val plasmaDischarge: Boolean = false,
    val mindBlast: Boolean = false,
    val gorgonShield: Boolean = false,
    val soothingBreeze: Boolean = false,
    val selfDestruct: Boolean = false,
    val sonicBoom: Boolean = false,
    val cloudOutfit: MemberOutfit = CLOUD_EX_SOLDIER,
    val barretOutfit: MemberOutfit = TIFA_SEVENTH_HEAVEN,
    val tifaOutfit: MemberOutfit = BARRET_AVALANCHE_LEADER,
    val aerithOutfit: MemberOutfit = AERITH_INDEPENDENT_FLORIST,
    val redOutfit: MemberOutfit = REDXIII_LABORATORY_ESCAPEE,
    val yuffieOutfit: MemberOutfit = YUFFIE_MATERIA_HUNTER,
    val caitOutfit: MemberOutfit = CAIT_FORTUNE_TELLER,
)
