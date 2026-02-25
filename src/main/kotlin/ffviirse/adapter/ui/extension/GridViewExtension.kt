package ffviirse.adapter.ui.extension

import impl.org.controlsfx.skin.GridViewSkin
import javafx.scene.control.skin.VirtualFlow
import org.controlsfx.control.GridView

fun <T> GridView<T>.scrollToTop() {
    if (this.items.isNotEmpty()) {
        this.scrollTo(0)
    }
}

fun <T> GridView<T>.scrollToBottom() {
    if (this.items.isNotEmpty()) {
        this.scrollTo(this.items.size.minus(1))
    }
}

fun <T> GridView<T>.scrollTo(item: T) {
    this.items.indexOf(item).takeIf { it > -1 }?.let { this.scrollTo(it) }
}

fun <T> GridView<T>.scrollTo(index: Int) {
    (this.skin as GridViewSkin<*>).children.firstOrNull()?.apply {
        (this as VirtualFlow<*>).scrollTo(index)
    }
}
