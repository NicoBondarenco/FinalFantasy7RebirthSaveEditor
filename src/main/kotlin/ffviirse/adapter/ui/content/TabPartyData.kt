package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.adapter.ui.component.AppIntSpinner
import ffviirse.adapter.ui.component.AppLabel
import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.extension.fixedSize
import ffviirse.adapter.ui.extension.fixedWidth
import ffviirse.adapter.ui.extension.solidBorder
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.adapter.ui.theme.ThemeColor.TEXT_COLOR
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.bundleContentPane
import ffviirse.domain.context.session.SessionContext.bundlePartyTab
import ffviirse.domain.context.session.SessionContext.currentPartyContext
import ffviirse.domain.extension.nullString
import ffviirse.domain.model.context.CharacterInfoContext
import ffviirse.domain.model.value.PartyMember
import ffviirse.domain.model.value.PartyMember.AERITH_GAINSBOROUGH
import ffviirse.domain.model.value.PartyMember.BARRET_WALLACE
import ffviirse.domain.model.value.PartyMember.CAIT_SITH
import ffviirse.domain.model.value.PartyMember.CLOUD_STRIFE
import ffviirse.domain.model.value.PartyMember.RED_XIII
import ffviirse.domain.model.value.PartyMember.TIFA_LOCKHART
import ffviirse.domain.model.value.PartyMember.YUFFIE_KISARAGI
import ffviirse.domain.property.IntProperty
import java.util.concurrent.Callable
import javafx.beans.binding.Bindings
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE
import javafx.scene.control.TitledPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority.ALWAYS
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import org.springframework.stereotype.Component

@Component
class TabPartyData : AppTab(2, bundleContentPane.tabPartyDataTitle) {

    companion object {

        private const val CONTENT_PADDING = 10.0

        private const val MIN_LEVEL = 15
        private const val MAX_LEVEL = 70

        private const val MIN_HP = 1
        private const val MAX_HP = 9999

        private const val MIN_MP = 1
        private const val MAX_MP = 999

        private const val MIN_RELATIONSHIP = 0
        private const val MAX_RELATIONSHIP = 150

        private val characterLevels = intArrayOf(
            7200, 7365, 8059, 8827, 9849, 11382, 13374, 15565, 17493, 19517,
            22350, 26316, 30400, 34524, 39060, 43958, 49345, 55162, 61560, 68469,
            76068, 84274, 93300, 103048, 113770, 125349, 138085, 151839, 166968, 183307,
            201279, 220688, 242037, 265093, 290454, 317843, 347423, 377298, 407471, 437945,
            468723, 499808, 531203, 562911, 594936, 627281, 659949, 692943, 726266, 759922,
            793914, 828245, 862919, 897939, 933309, 969032
        )
    }

    private val editingCharacterExperience: BooleanProperty = SimpleBooleanProperty(false)

    init {
        labelProperty.bind(Bindings.createStringBinding({ bundleContentPane.tabPartyDataTitle }, appBundleProperty))
        content = createTabPane()
    }

    private fun createTabPane(): TabPane = TabPane().apply {
        tabClosingPolicy = UNAVAILABLE
        tabs.addAll(PartyMember.entries.sortedBy { it.fileIndex }.map { it.createMemberTab() })
    }

    private fun PartyMember.createMemberTab(): Tab = Tab().also { tab ->
        tab.text = this.label
        tab.content = this.createMemberContent()
    }

    private fun PartyMember.createMemberContent(): HBox = HBox().also { pane ->
        pane.withPadding(CONTENT_PADDING)
        pane.spacing = CONTENT_PADDING
        pane.alignment = Pos.TOP_LEFT
        pane.children.addAll(
            this.createStatusContent(),
            this.createAttributesContent(),
        )
    }

    private fun Pane.toTitledPane(
        callable: Callable<String>,
    ): TitledPane = TitledPane().apply {
        textProperty().bind(Bindings.createStringBinding(callable, appBundleProperty))
        solidBorder()
        content = this@toTitledPane
        isCollapsible = false
    }

    private fun PartyMember.createStatusContent(): TitledPane = VBox().also { pane ->
        pane.withPadding(0.0)
        pane.spacing = 0.0
        pane.alignment = Pos.TOP_LEFT

        val character = this.characterInfo

        pane.children.addAll(
            createExperienceContent(),
            createHpMpContent(
                MIN_HP,
                MAX_HP,
                character.characterHpcurrent,
                character.characterHpmax,
                { bundlePartyTab.fieldCurrentHpLabel },
                { bundlePartyTab.fieldMaxHpLabel }),
            createHpMpContent(
                MIN_MP,
                MAX_MP,
                character.characterMpcurrent,
                character.characterMpmax,
                { bundlePartyTab.fieldCurrentMpLabel },
                { bundlePartyTab.fieldMaxMpLabel }),
        )
        if (this.hasRelationship) {
            pane.children.add(this.createRelationshipContent())
        }
    }.toTitledPane { bundlePartyTab.paneCharacterStatusTitle }

    private fun PartyMember.createExperienceContent(): HBox = HBox().also { pane ->
        pane.withPadding(0.0)
        pane.spacing = 0.0
        pane.alignment = Pos.TOP_LEFT

        val character = this.characterInfo

        lateinit var levelField: AppIntSpinner
        lateinit var expField: AppIntSpinner

        levelField = AppIntSpinner(
            inputLabel = nullString(),
            minValue = MIN_LEVEL,
            maxValue = MAX_LEVEL,
            inputValidation = { it in MIN_LEVEL..MAX_LEVEL },
        ).apply {
            bindLabel(appBundleProperty) { bundlePartyTab.fieldCharacterLevelLabel }
            maxWidth = Double.MAX_VALUE
            fieldValueProperty.bindBidirectional(character.characterLevel)
            validatableFields.add(this)
            HBox.setHgrow(this, ALWAYS)
            fieldValueProperty.addListener { _, _, newValue ->
                if (!editingCharacterExperience.value) {
                    try {
                        editingCharacterExperience.value = true
                        expField.fieldValueProperty.value = characterLevels[newValue - MIN_LEVEL]
                    } finally {
                        editingCharacterExperience.value = false
                    }
                }
            }
        }

        expField = AppIntSpinner(
            inputLabel = nullString(),
            minValue = characterLevels.min(),
            maxValue = characterLevels.max(),
            inputValidation = { it in 0..3125 },
        ).apply {
            bindLabel(appBundleProperty) { bundlePartyTab.fieldCharacterExperienceLabel }
            maxWidth = Double.MAX_VALUE
            fieldValueProperty.bindBidirectional(character.characterExperience)
            validatableFields.add(this)
            HBox.setHgrow(this, ALWAYS)
            fieldValueProperty.addListener { _, _, newValue ->
                if (!editingCharacterExperience.value) {
                    try {
                        editingCharacterExperience.value = true
                        levelField.fieldValueProperty.value = calculateCharacterLevel(newValue)
                    } finally {
                        editingCharacterExperience.value = false
                    }
                }
            }
        }

        pane.children.addAll(levelField, expField)
    }

    private fun createHpMpContent(
        minValue: Int,
        maxValue: Int,
        currentProperty: IntProperty,
        maxProperty: IntProperty,
        callableCurrent: Callable<String>,
        callableMax: Callable<String>,
    ): HBox = HBox().apply {
        withPadding(0.0)
        spacing = 0.0
        alignment = Pos.TOP_LEFT

        children.addAll(
            AppIntSpinner(
                inputLabel = nullString(),
                minValue = minValue,
                maxValue = maxValue,
                inputValidation = { it in minValue..maxValue },
            ).apply {
                bindLabel(appBundleProperty, callableCurrent)
                maxWidth = Double.MAX_VALUE
                fieldValueProperty.bindBidirectional(currentProperty)
                validatableFields.add(this)
                HBox.setHgrow(this, ALWAYS)
            },
            AppIntSpinner(
                inputLabel = nullString(),
                minValue = minValue,
                maxValue = maxValue,
                inputValidation = { it in minValue..maxValue },
                isEditable = false,
            ).apply {
                bindLabel(appBundleProperty, callableMax)
                maxWidth = Double.MAX_VALUE
                fieldValueProperty.bindBidirectional(maxProperty)
                validatableFields.add(this)
                HBox.setHgrow(this, ALWAYS)
            },
        )
    }

    private fun PartyMember.createRelationshipContent(): AppIntSpinner = AppIntSpinner(
        inputLabel = nullString(),
        minValue = MIN_RELATIONSHIP,
        maxValue = MAX_RELATIONSHIP,
        inputValidation = { it in MIN_RELATIONSHIP..MAX_RELATIONSHIP },
    ).apply {
        bindLabel(appBundleProperty) { bundlePartyTab.fieldCharacterRelationshipLabel }
        maxWidth = Double.MAX_VALUE
        fieldValueProperty.bindBidirectional(this@createRelationshipContent.characterInfo.characterRelationship)
        validatableFields.add(this)
        HBox.setHgrow(this, ALWAYS)
    }

    private fun PartyMember.createAttributesContent(): TitledPane = VBox().also { pane ->
        pane.withPadding(CONTENT_PADDING)
        pane.spacing = CONTENT_PADDING
        pane.alignment = Pos.TOP_LEFT

        val character = this.characterInfo

        pane.children.addAll(
            createAttributeLine(
                character.characterAttack,
                character.characterDefense,
                { bundlePartyTab.fieldPhysicalAttackLabel },
                { bundlePartyTab.fieldPhysicalDefenseLabel },
            ),
            createAttributeLine(
                character.characterMattack,
                character.characterMdefense,
                { bundlePartyTab.fieldMagicalAttackLabel },
                { bundlePartyTab.fieldMagicalDefenseLabel },
            ),
            createAttributeLine(
                character.characterStrength,
                character.characterMagic,
                { bundlePartyTab.fieldStrengthValueLabel },
                { bundlePartyTab.fieldMagicValueLabel },
            ),
            createAttributeLine(
                character.characterVitality,
                character.characterSpirit,
                { bundlePartyTab.fieldVitalityValueLabel },
                { bundlePartyTab.fieldSpiritValueLabel },
            ),
            createAttributeLine(
                character.characterSpeed,
                character.characterLuck,
                { bundlePartyTab.fieldSpeedValueLabel },
                { bundlePartyTab.fieldLuckValueLabel },
            ),
            createAttributeLine(
                character.criticalHrate,
                character.weaponLevel,
                { bundlePartyTab.fieldCriticalRateLabel },
                { bundlePartyTab.fieldWeaponLevelLabel },
            ),
        )
    }.toTitledPane { bundlePartyTab.paneCharacterAttributesTitle }

    private fun createAttributeLine(
        rightProperty: IntProperty,
        leftProperty: IntProperty,
        rightCallable: Callable<String>,
        leftCallable: Callable<String>,
    ): HBox = HBox().apply {
        withPadding(0.0)
        spacing = CONTENT_PADDING
        alignment = Pos.TOP_LEFT

        children.addAll(
            createAttributeLabel(rightProperty, rightCallable),
            createAttributeLabel(leftProperty, leftCallable),
        )
    }

    private fun createAttributeLabel(
        valueProperty: IntProperty,
        valueCallable: Callable<String>,
    ): VBox = VBox().apply {
        withPadding(0.0)
        spacing = 2.0
        alignment = Pos.TOP_LEFT

        val width = 120.0

        children.addAll(
            AppLabel(nullString()).apply {
                textProperty().bind(Bindings.createStringBinding(valueCallable, appBundleProperty))
                fixedWidth(width)
            },
            Label(nullString()).apply {
                textProperty().bind(valueProperty.asString())
                textFill = TEXT_COLOR.fxColor()
                font = Font.font(12.0)
                fixedSize(width, 15.0)
            }
        )
    }

    private fun calculateCharacterLevel(
        experience: Int
    ): Int = characterLevels.indexOfLast {
        experience >= it
    }.plus(1).coerceIn(1, characterLevels.size).plus(MIN_LEVEL - 1)

    private val PartyMember.characterInfo: CharacterInfoContext
        get() = when (this) {
            CLOUD_STRIFE -> currentPartyContext.cloudStrife
            TIFA_LOCKHART -> currentPartyContext.tifaLockhart
            BARRET_WALLACE -> currentPartyContext.barretWallace
            AERITH_GAINSBOROUGH -> currentPartyContext.aerithGainsborough
            RED_XIII -> currentPartyContext.redXiii
            YUFFIE_KISARAGI -> currentPartyContext.yuffieKisaragi
            CAIT_SITH -> currentPartyContext.caitSith
        }

}
