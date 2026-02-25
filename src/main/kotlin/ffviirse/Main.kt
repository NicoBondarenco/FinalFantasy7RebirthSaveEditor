package ffviirse

import ffviirse.adapter.ui.content.MainContent
import ffviirse.adapter.ui.theme.ThemeApplication.Companion.DARK
import ffviirse.configuration.extension.bean
import ffviirse.configuration.handler.ExceptionHandler
import ffviirse.domain.context.application.ApplicationConstant.DEFAULT_INITIAL_HEIGHT
import ffviirse.domain.context.application.ApplicationConstant.DEFAULT_INITIAL_WIDTH
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.appTitle
import ffviirse.domain.context.session.SessionContext.setContext
import ffviirse.domain.context.session.SessionContext.setStage
import javafx.application.Application
import javafx.application.Platform
import javafx.beans.binding.Bindings
import javafx.scene.Scene
import javafx.stage.Stage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}

@SpringBootApplication
class MainSpringBoot

class Main : Application() {

    private lateinit var applicationContext: ConfigurableApplicationContext

    override fun init() {
        applicationContext = SpringApplicationBuilder(MainSpringBoot::class.java).run(*parameters.raw.toTypedArray<String>())
    }

    override fun start(stage: Stage) {
        Thread.setDefaultUncaughtExceptionHandler(ExceptionHandler())
        setUserAgentStylesheet(DARK.userAgentStylesheet)
        setContext(applicationContext)
        setStage(stage.initialize())
    }

    override fun stop() {
        applicationContext.close()
        Platform.exit()
    }

    private fun Stage.initialize() = this.apply {
        scene = Scene(applicationContext.bean<MainContent>())
        width = DEFAULT_INITIAL_WIDTH
        height = DEFAULT_INITIAL_HEIGHT
        title = appTitle.mainStageWindowTitle
        isResizable = false
        titleProperty().bind(
            Bindings.createStringBinding(
                { appTitle.mainStageWindowTitle },
                appBundleProperty
            )
        )
    }

}

