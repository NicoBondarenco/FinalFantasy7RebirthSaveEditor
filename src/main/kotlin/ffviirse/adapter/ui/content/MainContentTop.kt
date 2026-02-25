package ffviirse.adapter.ui.content

import ffviirse.adapter.ui.component.AppComboBox
import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.appLabel
import ffviirse.domain.extension.asObservable
import ffviirse.domain.model.response.SaveGameFile
import ffviirse.domain.service.SaveGameService
import javafx.scene.layout.HBox
import org.springframework.stereotype.Component

@Component
class MainContentTop(
    private val saveGameService: SaveGameService
) : HBox() {

    companion object {
        private const val PANE_HEIGHT = 75.0
        private const val PANE_PADDING = 5.0
    }

    private val saveFilesCombo: AppComboBox<SaveGameFile> = createSaveFilesCombo()

    private fun createSaveFilesCombo(): AppComboBox<SaveGameFile> = AppComboBox(
        itemList = saveGameService.savedGames().asObservable(),
        inputLabel = appLabel.mainTopSavesLabel,
    )

    init {
        fixedHeight(PANE_HEIGHT)
        withPadding(PANE_PADDING)
        children.add(saveFilesCombo)
        configureListener()
    }

    private fun configureListener() {
        appBundleProperty.addListener { _, _, newBundle ->
            saveFilesCombo.changeLabel(newBundle.bundleLabel.mainTopSavesLabel)
        }
    }

}
