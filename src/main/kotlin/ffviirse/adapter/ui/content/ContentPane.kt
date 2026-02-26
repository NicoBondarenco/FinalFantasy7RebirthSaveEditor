package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.adapter.ui.extension.solidBorder
import ffviirse.configuration.extension.beans
import javafx.geometry.Side.LEFT
import javafx.scene.control.TabPane
import javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

@Component
class ContentPane(
    private val context: ApplicationContext
) : TabPane() {

    private val appTabs: List<AppTab> = this.context.beans<AppTab>().values.sortedBy { it.position }

    init {
        tabClosingPolicy = UNAVAILABLE
        side = LEFT
        isRotateGraphic = true
        tabs.addAll(appTabs)
        solidBorder()
    }

    val isValid: Boolean
        get() = appTabs.all { it.isValid }

}
