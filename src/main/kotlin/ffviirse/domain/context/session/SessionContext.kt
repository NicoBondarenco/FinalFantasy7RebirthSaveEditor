package ffviirse.domain.context.session


import com.sun.javafx.stage.StageHelper
import ffviirse.adapter.ui.theme.ThemeApplication
import ffviirse.adapter.ui.theme.ThemeApplication.Companion.DARK
import ffviirse.domain.i18n.I18nBundle
import ffviirse.domain.i18n.I18nBundleLabel
import ffviirse.domain.i18n.I18nBundleMessage
import ffviirse.domain.i18n.I18nBundleTitle
import javafx.application.Platform
import javafx.beans.property.SimpleObjectProperty
import javafx.stage.Stage
import org.springframework.context.ApplicationContext

object SessionContext {

    val appBundleProperty: SimpleObjectProperty<I18nBundle> = SimpleObjectProperty(I18nBundle())

    var appBundle: I18nBundle
        get() = appBundleProperty.get()
        private set(value) = appBundleProperty.set(value)

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

    fun changeBundle(bundle: I18nBundle) {
        Platform.runLater {
            appBundle = bundle
        }
    }

}
