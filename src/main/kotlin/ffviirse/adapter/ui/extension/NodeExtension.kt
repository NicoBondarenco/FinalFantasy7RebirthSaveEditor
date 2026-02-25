package ffviirse.adapter.ui.extension

import javafx.scene.Node
import javafx.scene.layout.AnchorPane

fun <T : Node> T.withAnchorPosition(
    top: Number? = null,
    bottom: Number? = null,
    left: Number? = null,
    right: Number? = null,
): T = this.apply {
    top?.let { AnchorPane.setTopAnchor(this, it.toDouble()) }
    bottom?.let { AnchorPane.setBottomAnchor(this, it.toDouble()) }
    left?.let { AnchorPane.setLeftAnchor(this, it.toDouble()) }
    right?.let { AnchorPane.setRightAnchor(this, it.toDouble()) }
}
