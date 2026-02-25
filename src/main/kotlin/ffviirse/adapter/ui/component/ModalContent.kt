package ffviirse.adapter.ui.component

import javafx.scene.layout.VBox

abstract class ModalContent : VBox() {

    protected var currentModal: CustomModal? = null

    fun setModal(modal: CustomModal) {
        this.currentModal = modal
    }

}
