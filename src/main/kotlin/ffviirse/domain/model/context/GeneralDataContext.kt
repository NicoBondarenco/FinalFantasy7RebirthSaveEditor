package ffviirse.domain.model.context

import ffviirse.domain.extension.format
import ffviirse.domain.property.DurationProperty
import ffviirse.domain.property.IntProperty
import ffviirse.domain.property.LongProperty
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
)
