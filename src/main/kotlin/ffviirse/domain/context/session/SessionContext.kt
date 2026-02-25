package ffviirse.domain.context.session


import com.sun.javafx.stage.StageHelper
import ffviirse.adapter.ui.theme.ThemeApplication
import ffviirse.adapter.ui.theme.ThemeApplication.Companion.DARK
import ffviirse.domain.i18n.I18nBundle
import ffviirse.domain.i18n.I18nBundleLabel
import ffviirse.domain.i18n.I18nBundleMessage
import ffviirse.domain.i18n.I18nBundleTitle
import ffviirse.domain.model.entity.SaveGameData
import ffviirse.domain.property.I18nBundleProperty
import ffviirse.domain.property.SaveGameDataProperty
import javafx.application.Platform
import javafx.stage.Stage
import org.springframework.context.ApplicationContext

object SessionContext {

    val appBundleProperty: I18nBundleProperty = I18nBundleProperty(I18nBundle())

    val appBundle: I18nBundle
        get() = appBundleProperty.value

    val appLabel: I18nBundleLabel
        get() = appBundle.bundleLabel

    val appTitle: I18nBundleTitle
        get() = appBundle.bundleTitle

    val appMessage: I18nBundleMessage
        get() = appBundle.bundleMessage

    var appTheme: ThemeApplication = DARK
        private set

    lateinit var appStage: Stage
        private set

    lateinit var appContext: ApplicationContext
        private set

    var currentSaveProperty: SaveGameDataProperty = SaveGameDataProperty(SaveGameData())
        private set

    val currentSave: SaveGameData
        get() = currentSaveProperty.value

    fun setContext(context: ApplicationContext) {
        if (!::appContext.isInitialized) {
            appContext = context
        }
    }

    fun setStage(stage: Stage) {
        if (!::appStage.isInitialized) {
            appStage = stage.apply {
                centerOnScreen()
                show()
            }
            StageHelper.setPrimary(appStage, true)
        }
    }

    fun changeBundle(bundle: I18nBundle) = Platform.runLater {
        appBundleProperty.value = bundle
    }

    fun changeCurrentSave(saveData: SaveGameData) = Platform.runLater {
        currentSaveProperty.value = saveData
    }

}
