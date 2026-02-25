package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.domain.context.session.SessionContext.appBundle
import ffviirse.domain.context.session.SessionContext.appMessage
import javafx.beans.property.BooleanProperty
import javafx.beans.property.Property
import javafx.scene.control.Spinner

class AppIntSpinner(
    inputLabel: String,
    errorMessage: String = appMessage.validationGenericErrorMessage,
    isEditable: Boolean = true,
    inputValidation: (Int) -> Boolean = { true }
) : AppField<Int, Spinner<Int>>(inputLabel, errorMessage, DEFAULT_HEIGHT, inputValidation) {

    override val inputField: Spinner<Int> = spinner(isEditable)

    override val valueRetriever: (Spinner<Int>) -> Int = { it.value }

    override val fieldValueProperty: Property<Int> = inputField.valueFactory.valueProperty()

    val editableProperty: BooleanProperty = inputField.editableProperty()

    var editable: Boolean
        get() = editableProperty.get()
        set(value) = editableProperty.set(value)

    init {
        initField()
    }

    private fun spinner(
        editable: Boolean
    ): Spinner<Int> = Spinner<Int>(0, Int.MAX_VALUE, 0, 1).apply {
        maxWidth = MAIN_WIDTH
        fixedHeight(INPUT_HEIGHT)
        isEditable = editable
        focusedProperty().addListener { _, _, focused ->
            isValidProperty.value = focused || inputValidation(this.value)
            if (!focused) {
                increment(0)
            }
        }
    }

}
