package ffviirse.domain.context.session


import com.sun.javafx.stage.StageHelper
import ffviirse.adapter.ui.theme.ThemeApplication
import ffviirse.adapter.ui.theme.ThemeApplication.Companion.DARK
import ffviirse.domain.i18n.I18nBundle
import ffviirse.domain.i18n.I18nBundleBottomBar
import ffviirse.domain.i18n.I18nBundleContentPane
import ffviirse.domain.i18n.I18nBundleGeneralTab
import ffviirse.domain.i18n.I18nBundleMainApplication
import ffviirse.domain.i18n.I18nBundlePartyTab
import ffviirse.domain.i18n.I18nBundleTopBar
import ffviirse.domain.model.context.GeneralDataContext
import ffviirse.domain.model.context.SaveGameContext
import ffviirse.domain.model.entity.SaveGame
import ffviirse.domain.model.mapper.update
import ffviirse.domain.property.I18nBundleProperty
import javafx.application.Platform
import javafx.stage.Stage
import org.springframework.context.ApplicationContext

object SessionContext {

    val appBundleProperty: I18nBundleProperty = I18nBundleProperty(I18nBundle())

    val appBundle: I18nBundle
        get() = appBundleProperty.value

    val bundleMainApplication: I18nBundleMainApplication
        get() = appBundle.bundleMainApplication

    val bundleTopBar: I18nBundleTopBar
        get() = appBundle.bundleTopBar

    val bundleBottomBar: I18nBundleBottomBar
        get() = appBundle.bundleBottomBar

    val bundleContentPane: I18nBundleContentPane
        get() = appBundle.bundleContentPane

    val bundleGeneralTab: I18nBundleGeneralTab
        get() = appBundle.bundleGeneralTab

    val bundlePartyTab: I18nBundlePartyTab
        get() = appBundle.bundlePartyTab

    var appTheme: ThemeApplication = DARK
        private set

    lateinit var appStage: Stage
        private set

    lateinit var appContext: ApplicationContext
        private set

    val currentSaveGame: SaveGameContext = SaveGameContext()

    val currentGeneralData: GeneralDataContext
        get() = currentSaveGame.generalData

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

    fun changeCurrentSave(saveData: SaveGame) = Platform.runLater {
        currentSaveGame.update(saveData)
    }

}
