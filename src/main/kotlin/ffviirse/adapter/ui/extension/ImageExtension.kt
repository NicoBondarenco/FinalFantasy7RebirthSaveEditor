package ffviirse.adapter.ui.extension

import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun ImageView.loadImage(path: String) {
    this.image = Image(path)
}
