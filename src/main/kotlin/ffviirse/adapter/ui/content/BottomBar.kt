package ffviirse.adapter.ui.content

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.extension.solidBorder
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.bundleBottomBar
import ffviirse.domain.context.session.SessionContext.currentSaveGame
import ffviirse.domain.extension.nullString
import ffviirse.domain.model.mapper.toSaveGame
import ffviirse.domain.service.SaveGameService
import javafx.beans.binding.Bindings
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import org.springframework.stereotype.Component

@Component
class BottomBar(
    private val saveGameService: SaveGameService,
) : HBox() {

    companion object {
        private const val PANE_HEIGHT = 85.0
        private const val PANE_PADDING = 5.0

        private const val SAVE_FILE_BUTTON_WIDTH = 150.0
    }

    private val saveButtonActive: BooleanProperty = SimpleBooleanProperty(false)

    init {
        fixedHeight(PANE_HEIGHT)
        withPadding(PANE_PADDING)
        alignment = Pos.CENTER_RIGHT
        children.addAll(createSaveButton())
        solidBorder(top = 0.0)
    }

    private fun createSaveButton(): Button = Button(nullString()).apply {
        textProperty().bind(Bindings.createStringBinding({ bundleBottomBar.mainBottomSaveLabel }, appBundleProperty))
        disableProperty().bind(saveButtonActive)
        setOnAction {
            if (!saveButtonActive.value) {
                try {
                    saveButtonActive.value = true
                    saveGameService.exportSave(currentSaveGame.toSaveGame())
                } finally {
                    saveButtonActive.value = false
                }
            }
        }
    }

}
