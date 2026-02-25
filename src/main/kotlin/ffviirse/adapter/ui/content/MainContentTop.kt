package ffviirse.adapter.ui.content

import ffviirse.adapter.ui.component.AppComboBox
import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.extension.fixedWidth
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.adapter.ui.model.ComboBoxItemView
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.appLabel
import ffviirse.domain.extension.asObservable
import ffviirse.domain.extension.onlyNumbers
import ffviirse.domain.i18n.I18nBundle
import ffviirse.domain.model.response.SaveGameFile
import ffviirse.domain.service.I18nBundleService
import ffviirse.domain.service.SaveGameService
import java.io.File
import javafx.collections.ObservableList
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority.ALWAYS
import javafx.scene.layout.Region
import org.springframework.stereotype.Component

@Component
class MainContentTop(
    private val saveGameService: SaveGameService,
    private val i18nBundleService: I18nBundleService,
) : HBox() {

    companion object {
        private const val PANE_HEIGHT = 75.0
        private const val PANE_PADDING = 5.0

        private const val SAVE_FILES_COMBO_WIDTH = 250.0
        private const val CURRENT_LANGUAGE_COMBO_WIDTH = 250.0
    }

    private val saveFilesCombo: AppComboBox<ComboBoxItemView<SaveGameFile>> = createSaveFilesCombo()
    private val selectLanguageCombo: AppComboBox<I18nBundle> = createSelectLanguageCombo()

    init {
        fixedHeight(PANE_HEIGHT)
        withPadding(PANE_PADDING)
        children.addAll(saveFilesCombo, createSpacer(), selectLanguageCombo)
    }

    private fun createSaveFilesCombo(): AppComboBox<ComboBoxItemView<SaveGameFile>> = AppComboBox(
        itemList = saveFiles(),
        inputLabel = appLabel.mainTopSavesLabel,
    ).apply {
        fixedWidth(SAVE_FILES_COMBO_WIDTH)
        bindLabel(appBundleProperty) { appLabel.mainTopSavesLabel }
        fieldValue = ComboBoxItemView()
        fieldValueProperty.addListener { _, _, newValue ->
            newValue.itemValue?.let { saveGameService.selectSaveGame(it) }
        }
    }

    private fun saveFiles(): ObservableList<ComboBoxItemView<SaveGameFile>> = (saveGameService.savedGames().map {
        ComboBoxItemView(
            displayOrder = it.saveFile.nameWithoutExtension.onlyNumbers().toInt() + 1,
            displayName = it.label,
            itemValue = it,
        )
    } + ComboBoxItemView(itemValue = SaveGameFile())).sortedBy { it.displayOrder }.asObservable()

    private fun createSelectLanguageCombo(): AppComboBox<I18nBundle> = AppComboBox(
        itemList = i18nBundleService.availableBundles().asObservable(),
        inputLabel = appLabel.mainTopLanguagesLabel,
    ).apply {
        fixedWidth(CURRENT_LANGUAGE_COMBO_WIDTH)
        bindLabel(appBundleProperty) { appLabel.mainTopLanguagesLabel }
        fieldValueProperty.bindBidirectional(appBundleProperty)
    }

    private fun createSpacer(): Region = Region().apply {
        HBox.setHgrow(this, ALWAYS)
    }

}
