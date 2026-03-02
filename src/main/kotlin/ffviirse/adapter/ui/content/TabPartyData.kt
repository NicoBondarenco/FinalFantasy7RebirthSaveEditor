package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.adapter.ui.component.AppIntSpinner
import ffviirse.adapter.ui.extension.withPadding
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
import javafx.beans.binding.Bindings
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Pos
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE
import javafx.scene.control.TitledPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority.ALWAYS
import javafx.scene.layout.VBox
import org.springframework.stereotype.Component

@Component
class TabPartyData : AppTab(2, bundleContentPane.tabPartyDataTitle) {

    companion object {

        private const val CONTENT_PADDING = 10.0

        private const val MIN_LEVEL = 15
        private const val MAX_LEVEL = 70

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

    private fun PartyMember.createMemberContent(): VBox = VBox().also { pane ->
        pane.withPadding(CONTENT_PADDING)
        pane.spacing = CONTENT_PADDING
        pane.alignment = Pos.TOP_LEFT
        pane.children.addAll(this.createDataContent())
    }

    private fun PartyMember.createDataContent(): TitledPane = VBox().also { pane ->
        pane.withPadding(0.0)
        pane.spacing = CONTENT_PADDING
        pane.alignment = Pos.TOP_LEFT
        pane.children.addAll(
            createExperienceContent()
        )
    }.let {
        TitledPane().apply {
            textProperty().bind(Bindings.createStringBinding({ bundlePartyTab.paneCharacterStatusTitle }))
            content = it
        }
    }

    private fun PartyMember.createExperienceContent(): HBox = HBox().also { pane ->
        pane.withPadding(0.0)
        pane.spacing = CONTENT_PADDING
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

    private fun createHpMpContent(): HBox = HBox().apply {

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
