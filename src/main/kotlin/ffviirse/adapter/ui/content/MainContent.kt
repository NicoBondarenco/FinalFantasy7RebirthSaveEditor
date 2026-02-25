package ffviirse.adapter.ui.content

import ffviirse.adapter.ui.extension.withPadding
import javafx.scene.layout.VBox
import org.springframework.stereotype.Component

@Component
class MainContent(
    private val mainContentTop: MainContentTop
) : VBox() {

    companion object {
        private const val PANE_PADDING = 0.0
    }

    init {
        withPadding(PANE_PADDING)
        children.add(mainContentTop)
    }

}
