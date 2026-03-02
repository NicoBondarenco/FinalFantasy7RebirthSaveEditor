package ffviirse.domain.model.context

import ffviirse.domain.extension.format
import ffviirse.domain.model.value.MemberOutfit.AERITH_INDEPENDENT_FLORIST
import ffviirse.domain.model.value.MemberOutfit.BARRET_AVALANCHE_LEADER
import ffviirse.domain.model.value.MemberOutfit.CAIT_FORTUNE_TELLER
import ffviirse.domain.model.value.MemberOutfit.CLOUD_EX_SOLDIER
import ffviirse.domain.model.value.MemberOutfit.REDXIII_LABORATORY_ESCAPEE
import ffviirse.domain.model.value.MemberOutfit.TIFA_SEVENTH_HEAVEN
import ffviirse.domain.model.value.MemberOutfit.YUFFIE_MATERIA_HUNTER
import ffviirse.domain.property.IntProperty
import ffviirse.domain.property.LongProperty
import ffviirse.domain.property.MemberOutfitProperty
import java.time.Duration
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

data class GeneralDataContext(
    val playTime: StringProperty = SimpleStringProperty(Duration.ZERO.format(3)),
    val playHours: LongProperty = LongProperty(0),
    val playMinutes: LongProperty = LongProperty(0),
    val playSeconds: LongProperty = LongProperty(0),
    val totalGil: IntProperty = IntProperty(0),
    val mainMenu: BooleanProperty = SimpleBooleanProperty(false),
    val extraSettings: BooleanProperty = SimpleBooleanProperty(false),
    val playLog: BooleanProperty = SimpleBooleanProperty(false),
    val chapterSelection: BooleanProperty = SimpleBooleanProperty(false),
    val chapterOne: BooleanProperty = SimpleBooleanProperty(false),
    val chapterTwo: BooleanProperty = SimpleBooleanProperty(false),
    val chapterThree: BooleanProperty = SimpleBooleanProperty(false),
    val chapterFour: BooleanProperty = SimpleBooleanProperty(false),
    val chapterFive: BooleanProperty = SimpleBooleanProperty(false),
    val chapterSix: BooleanProperty = SimpleBooleanProperty(false),
    val chapterSeven: BooleanProperty = SimpleBooleanProperty(false),
    val chapterEight: BooleanProperty = SimpleBooleanProperty(false),
    val chapterNine: BooleanProperty = SimpleBooleanProperty(false),
    val chapterTen: BooleanProperty = SimpleBooleanProperty(false),
    val chapterEleven: BooleanProperty = SimpleBooleanProperty(false),
    val chapterTwelve: BooleanProperty = SimpleBooleanProperty(false),
    val chapterThirteen: BooleanProperty = SimpleBooleanProperty(false),
    val chapterFourteen: BooleanProperty = SimpleBooleanProperty(false),
    val groupExperience: IntProperty = IntProperty(0),
    val rancidBreath: BooleanProperty = SimpleBooleanProperty(false),
    val plasmaDischarge: BooleanProperty = SimpleBooleanProperty(false),
    val mindBlast: BooleanProperty = SimpleBooleanProperty(false),
    val gorgonShield: BooleanProperty = SimpleBooleanProperty(false),
    val soothingBreeze: BooleanProperty = SimpleBooleanProperty(false),
    val selfDestruct: BooleanProperty = SimpleBooleanProperty(false),
    val sonicBoom: BooleanProperty = SimpleBooleanProperty(false),
    val cloudOutfit: MemberOutfitProperty = MemberOutfitProperty(CLOUD_EX_SOLDIER),
    val tifaOutfit: MemberOutfitProperty = MemberOutfitProperty(TIFA_SEVENTH_HEAVEN),
    val barretOutfit: MemberOutfitProperty = MemberOutfitProperty(BARRET_AVALANCHE_LEADER),
    val aerithOutfit: MemberOutfitProperty = MemberOutfitProperty(AERITH_INDEPENDENT_FLORIST),
    val redOutfit: MemberOutfitProperty = MemberOutfitProperty(REDXIII_LABORATORY_ESCAPEE),
    val yuffieOutfit: MemberOutfitProperty = MemberOutfitProperty(YUFFIE_MATERIA_HUNTER),
    val caitOutfit: MemberOutfitProperty = MemberOutfitProperty(CAIT_FORTUNE_TELLER),
)
