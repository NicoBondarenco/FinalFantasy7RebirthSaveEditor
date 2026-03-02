package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.adapter.ui.component.AppIntSpinner
import ffviirse.adapter.ui.component.AppLabel
import ffviirse.adapter.ui.component.AppTextInput.Companion.textField
import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.extension.solidBorder
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.adapter.ui.theme.ThemeColor.TEXT_COLOR
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.bundleContentPane
import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.context.session.SessionContext.currentGeneralData
import ffviirse.domain.extension.asObservable
import ffviirse.domain.extension.nullString
import ffviirse.domain.model.value.MemberOutfit
import ffviirse.domain.model.value.PartyMember
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI
import ffviirse.domain.property.MemberOutfitProperty
import java.util.concurrent.Callable
import javafx.beans.binding.Bindings
import javafx.beans.property.BooleanProperty
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority.ALWAYS
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.util.StringConverter
import org.springframework.stereotype.Component

@Component
class TabGeneralData : AppTab(1, bundleContentPane.tabGeneralDataTitle) {

    companion object {
        private const val CONTENT_PADDING = 10.0
        private val groupLevels = intArrayOf(0, 140, 330, 570, 860, 1200, 1590, 2030, 2520, 3125)
    }

    private val editingGroupExperience: BooleanProperty = SimpleBooleanProperty(false)

    init {
        labelProperty.bind(Bindings.createStringBinding({ bundleContentPane.tabGeneralDataTitle }, appBundleProperty))
        content = createContent()
    }

    private fun createContent(): HBox = HBox().apply {
        withPadding(CONTENT_PADDING)
        spacing = CONTENT_PADDING
        children.addAll(
            createTitledPane(widthProperty(), { bundleGeneralTab.paneGeneralDataTitle }) {
                createGeneralDataPane()
            },
            createTitledPane(widthProperty(), { bundleGeneralTab.paneMenuChapterTitle }) {
                createMenuChapterPane()
            },
            createTitledPane(widthProperty(), { bundleGeneralTab.paneEnemySkillsTitle }) {
                createEnemySkillPane()
            },
            createTitledPane(widthProperty(), { bundleGeneralTab.paneCharactersOutfitsTitle }) {
                createMemberOutfitPane()
            },
        )
    }

    private fun createTitledPane(
        widthProperty: ReadOnlyDoubleProperty,
        callableTitle: Callable<String>,
        paneContent: TitledPane.() -> Unit = {},
    ) = TitledPane().apply {
        textProperty().bind(Bindings.createStringBinding(callableTitle, appBundleProperty))
        prefWidthProperty().bind(widthProperty.subtract(CONTENT_PADDING * 5).divide(4))
        solidBorder()
        maxWidth = Double.MAX_VALUE
        HBox.setHgrow(this, ALWAYS)
        paneContent()
    }

    private fun TitledPane.createGeneralDataPane() {
        content = VBox().apply {
            withPadding(CONTENT_PADDING)
            alignment = Pos.TOP_LEFT
            children.addAll(
                textField(
                    inputLabel = bundleGeneralTab.fieldPlayTimeLabel,
                    inputValidation = { "[0-9]+:[0-5][0-9]:[0-5][0-9]".toRegex().matches(it) },
                ).apply {
                    bindLabel(appBundleProperty) { bundleGeneralTab.fieldPlayTimeLabel }
                    maxWidth = Double.MAX_VALUE
                    fieldValueProperty.bindBidirectional(currentGeneralData.playTime)
                    validatableFields.add(this)
                },
                AppIntSpinner(
                    inputLabel = bundleGeneralTab.fieldPlayTimeLabel,
                    inputValidation = { it >= 0 },
                ).apply {
                    bindLabel(appBundleProperty) { bundleGeneralTab.fieldTotalGilLabel }
                    maxWidth = Double.MAX_VALUE
                    fieldValueProperty.bindBidirectional(currentGeneralData.totalGil)
                    validatableFields.add(this)
                },
                createPartyExperienceField()
            )
        }
    }

    private fun TitledPane.createMenuChapterPane() {
        content = VBox().apply {
            withPadding(CONTENT_PADDING)
            alignment = Pos.TOP_LEFT
            children.addAll(
                createLabel { bundleGeneralTab.fieldUnlockedMenuLabel },
                createSeparator(),
                createCheckBox(currentGeneralData.mainMenu) { bundleGeneralTab.fieldMainMenuLabel },
                createCheckBox(currentGeneralData.extraSettings) { bundleGeneralTab.fieldExtraSettingsLabel },
                createCheckBox(currentGeneralData.playLog) { bundleGeneralTab.fieldPlayLogLabel },
                createCheckBox(currentGeneralData.chapterSelection) { bundleGeneralTab.fieldChapterSelectionLabel },
                createLabel { bundleGeneralTab.fieldHardChaptersLabel },
                createSeparator(),
                createCheckBox(currentGeneralData.chapterOne) { bundleGeneralTab.fieldChapterOneLabel },
                createCheckBox(currentGeneralData.chapterTwo) { bundleGeneralTab.fieldChapterTwoLabel },
                createCheckBox(currentGeneralData.chapterThree) { bundleGeneralTab.fieldChapterThreeLabel },
                createCheckBox(currentGeneralData.chapterFour) { bundleGeneralTab.fieldChapterFourLabel },
                createCheckBox(currentGeneralData.chapterFive) { bundleGeneralTab.fieldChapterFiveLabel },
                createCheckBox(currentGeneralData.chapterSix) { bundleGeneralTab.fieldChapterSixLabel },
                createCheckBox(currentGeneralData.chapterSeven) { bundleGeneralTab.fieldChapterSevenLabel },
                createCheckBox(currentGeneralData.chapterEight) { bundleGeneralTab.fieldChapterEightLabel },
                createCheckBox(currentGeneralData.chapterNine) { bundleGeneralTab.fieldChapterNineLabel },
                createCheckBox(currentGeneralData.chapterTen) { bundleGeneralTab.fieldChapterTenLabel },
                createCheckBox(currentGeneralData.chapterEleven) { bundleGeneralTab.fieldChapterElevenLabel },
                createCheckBox(currentGeneralData.chapterTwelve) { bundleGeneralTab.fieldChapterTwelveLabel },
                createCheckBox(currentGeneralData.chapterThirteen) { bundleGeneralTab.fieldChapterThirteenLabel },
                createCheckBox(currentGeneralData.chapterFourteen) { bundleGeneralTab.fieldChapterFourteenLabel },
            )
        }
    }

    private fun TitledPane.createEnemySkillPane() {
        content = VBox().apply {
            withPadding(CONTENT_PADDING)
            alignment = Pos.TOP_LEFT
            children.addAll(
                createCheckBox(currentGeneralData.rancidBreath) { bundleGeneralTab.skillRancidBreathLabel },
                createCheckBox(currentGeneralData.plasmaDischarge) { bundleGeneralTab.skillPlasmaDischargeLabel },
                createCheckBox(currentGeneralData.mindBlast) { bundleGeneralTab.skillMindBlastLabel },
                createCheckBox(currentGeneralData.gorgonShield) { bundleGeneralTab.skillGorgonShieldLabel },
                createCheckBox(currentGeneralData.soothingBreeze) { bundleGeneralTab.skillSoothingBreezeLabel },
                createCheckBox(currentGeneralData.selfDestruct) { bundleGeneralTab.skillSelfDestructLabel },
                createCheckBox(currentGeneralData.sonicBoom) { bundleGeneralTab.skillSonicBoomLabel },
            )
        }
    }

    private fun TitledPane.createMemberOutfitPane() {
        content = VBox().apply {
            withPadding(CONTENT_PADDING)
            alignment = Pos.TOP_LEFT
            children.addAll(
                createOutfitSelect(CLOUD_STRIFE, currentGeneralData.cloudOutfit),
                createOutfitSelect(TIFA_LOCKHART, currentGeneralData.tifaOutfit),
                createOutfitSelect(BARRET_WALLACE, currentGeneralData.barretOutfit),
                createOutfitSelect(AERITH_GAINSBOROUGH, currentGeneralData.aerithOutfit),
                createOutfitSelect(RED_XIII, currentGeneralData.redOutfit),
                createOutfitSelect(YUFFIE_KISARAGI, currentGeneralData.yuffieOutfit),
                createOutfitSelect(CAIT_SITH, currentGeneralData.caitOutfit),
            )
        }
    }

    private fun createOutfitSelect(
        member: PartyMember,
        property: MemberOutfitProperty
    ): VBox = VBox().apply {
        withPadding(0.0)
        spacing = 2.0
        maxWidth = Double.MAX_VALUE
        children.addAll(
            AppLabel(member.label).apply {
                maxWidth = Double.MAX_VALUE
                font = Font.font(15.0)
                fixedHeight(20.0)
            },
            ComboBox<MemberOutfit>().apply {
                itemsProperty().bind(
                    Bindings.createObjectBinding(
                        { MemberOutfit.entries.filter { it.partyMember == member }.asObservable() },
                        appBundleProperty
                    )
                )
                VBox.setMargin(this, Insets(0.0, 0.0, 5.0, 0.0))
                valueProperty().bindBidirectional(property)
                converter = object : StringConverter<MemberOutfit?>() {
                    override fun toString(item: MemberOutfit?): String = item?.label ?: nullString()
                    override fun fromString(string: String): MemberOutfit? = MemberOutfit.entries.firstOrNull { it.label == string }
                }
            }
        )
    }

    private fun createPartyExperienceField(): HBox = HBox().apply {
        spacing = CONTENT_PADDING

        lateinit var levelField: AppIntSpinner
        lateinit var expField: AppIntSpinner

        levelField = AppIntSpinner(
            inputLabel = bundleGeneralTab.fieldPartyLevelLabel,
            minValue = 1,
            maxValue = 10,
            inputValidation = { it in 1..10 },
        ).apply {
            bindLabel(appBundleProperty) { bundleGeneralTab.fieldPartyLevelLabel }
            maxWidth = Double.MAX_VALUE
            validatableFields.add(this)
            HBox.setHgrow(this, ALWAYS)
            fieldValueProperty.addListener { _, _, newValue ->
                if (!editingGroupExperience.value) {
                    try {
                        editingGroupExperience.value = true
                        expField.fieldValueProperty.value = groupLevels[newValue - 1]
                    } finally {
                        editingGroupExperience.value = false
                    }
                }
            }
        }

        expField = AppIntSpinner(
            inputLabel = bundleGeneralTab.fieldPartyExperienceLabel,
            minValue = 0,
            maxValue = 3125,
            inputValidation = { it in 0..3125 },
        ).apply {
            bindLabel(appBundleProperty) { bundleGeneralTab.fieldPartyExperienceLabel }
            maxWidth = Double.MAX_VALUE
            fieldValueProperty.bindBidirectional(currentGeneralData.groupExperience)
            validatableFields.add(this)
            HBox.setHgrow(this, ALWAYS)
            fieldValueProperty.addListener { _, _, newValue ->
                if (!editingGroupExperience.value) {
                    try {
                        editingGroupExperience.value = true
                        levelField.fieldValueProperty.value = calculateGroupLevel(newValue)
                    } finally {
                        editingGroupExperience.value = false
                    }
                }
            }
        }

        children.addAll(levelField, expField)
    }

    private fun createCheckBox(
        property: BooleanProperty,
        callable: Callable<String>,
    ): CheckBox = CheckBox().apply {
        textProperty().bind(Bindings.createStringBinding(callable, appBundleProperty))
        selectedProperty().bindBidirectional(property)
    }

    private fun createSeparator(): Pane = Pane().apply {
        VBox.setMargin(this, Insets(2.0, 0.0, 5.0, 0.0))
        solidBorder()
        fixedHeight(1.0)
    }

    private fun createLabel(
        callable: Callable<String>,
    ): Label = Label(nullString()).apply {
        textProperty().bind(Bindings.createStringBinding(callable, appBundleProperty))
        textFill = TEXT_COLOR.fxColor()
        font = Font.font(20.0)
        fixedHeight(25.0)
        VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))
    }

    private fun calculateGroupLevel(
        experience: Int
    ): Int = groupLevels.indexOfLast {
        experience >= it
    }.plus(1).coerceIn(1, groupLevels.size)

}
