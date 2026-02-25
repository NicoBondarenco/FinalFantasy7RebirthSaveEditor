package ffviirse.adapter.ui.component

import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.Window

class CustomModal(
    title: String,
    owner: Window,
    content: ModalContent,
    size: ComponentSize? = null,
) : Stage() {

    init {
        this.title = title
        initModality(Modality.APPLICATION_MODAL)
        initOwner(owner)
        isResizable = false
        centerOnScreen()
        scene = Scene(content, size?.width ?: owner.width, size?.height ?: owner.height)
        content.setModal(this)
        showAndWait()
    }

}
