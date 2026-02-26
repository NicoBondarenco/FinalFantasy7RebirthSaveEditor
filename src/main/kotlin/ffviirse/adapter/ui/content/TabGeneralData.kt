package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.adapter.ui.component.AppIntSpinner
import ffviirse.adapter.ui.component.AppTextInput.Companion.textField
import ffviirse.adapter.ui.extension.solidBorder
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.bundleContentPane
import ffviirse.domain.context.session.SessionContext.bundleGeneralTab
import ffviirse.domain.context.session.SessionContext.currentGeneralData
import java.util.concurrent.Callable
import javafx.beans.binding.Bindings
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.scene.control.TitledPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority.ALWAYS
import javafx.scene.layout.VBox
import org.springframework.stereotype.Component

@Component
class TabGeneralData : AppTab(1, bundleContentPane.tabGeneralDataTitle) {

    companion object {
        private const val CONTENT_PADDING = 10.0
    }

    init {
        labelProperty.bind(Bindings.createStringBinding({ bundleContentPane.tabGeneralDataTitle }, appBundleProperty))
        content = createContent()
    }

    private fun createContent(): HBox = HBox().apply {
        withPadding(CONTENT_PADDING)
        spacing = CONTENT_PADDING
        children.addAll(
            createTitledPane(widthProperty(), { bundleGeneralTab.paneGeneralDataTitle }) {
                createGeneralPane()
            },
            createTitledPane(widthProperty(), { bundleGeneralTab.panePartyLevelTitle }) {

            },
            createTitledPane(widthProperty(), { bundleGeneralTab.paneEnemySkillsTitle }) {

            },
            createTitledPane(widthProperty(), { bundleGeneralTab.paneCharactersOutfitsTitle }) {

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

    private fun TitledPane.createGeneralPane() {
        content = VBox().apply {
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
                }
            )
        }
    }
}
