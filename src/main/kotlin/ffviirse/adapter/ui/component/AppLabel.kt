package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.theme.ThemeColor
import javafx.scene.control.Label
import javafx.scene.text.Font

class AppLabel(
    text: String
) : Label("${text}:") {

    companion object {
        private const val LABEL_FONT = 15.0
        private const val LABEL_HEIGHT = 20.0
    }

    init {
        textFill = ThemeColor.TEXT_COLOR.fxColor()
        font = Font.font(LABEL_FONT)
        fixedHeight(LABEL_HEIGHT)
    }

}
