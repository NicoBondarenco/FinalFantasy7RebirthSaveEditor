package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.adapter.ui.component.AppIntSpinner
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.bundleContentPane
import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.context.session.SessionContext.currentGeneralData
import ffviirse.domain.model.value.PartyMember
import javafx.beans.binding.Bindings
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Pos
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority.ALWAYS
import javafx.scene.layout.VBox
import org.springframework.stereotype.Component

@Component
class TabPartyData : AppTab(2, bundleContentPane.tabPartyDataTitle) {

    companion object {

        private const val CONTENT_PADDING = 10.0

        private const val MIN_LEVEL = 15

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
        tabs.addAll(PartyMember.entries.sortedBy { it.fileIndex }.map { createMemberTab(it) })
    }

    private fun createMemberTab(member: PartyMember): Tab = Tab().apply {
        text = member.label
    }

    private fun createMemberContent(): VBox = VBox().apply {
        withPadding(CONTENT_PADDING)
        spacing = CONTENT_PADDING
        alignment = Pos.TOP_LEFT
    }

    private fun createDataContent(): VBox = VBox().apply {
        withPadding(0.0)
        spacing = CONTENT_PADDING
        alignment = Pos.TOP_LEFT
        children.addAll(
            createExperienceContent()
        )
    }

    private fun createExperienceContent(): HBox = HBox().apply {
        withPadding(0.0)
        spacing = CONTENT_PADDING
        alignment = Pos.TOP_LEFT

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
                if (!editingCharacterExperience.value) {
                    try {
                        editingCharacterExperience.value = true
                        expField.fieldValueProperty.value = characterLevels[newValue - 1 - MIN_LEVEL]
                    } finally {
                        editingCharacterExperience.value = false
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

        children.addAll(levelField, expField)
    }

    private fun createHpMpContent(): HBox = HBox().apply {

    }

    private fun calculateCharacterLevel(
        experience: Int
    ): Int = characterLevels.indexOfLast {
        experience >= it
    }.plus(1).coerceIn(1, characterLevels.size).plus(MIN_LEVEL)

}
