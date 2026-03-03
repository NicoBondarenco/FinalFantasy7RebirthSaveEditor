package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.domain.context.session.SessionContext.bundleMainApplication
import javafx.beans.property.BooleanProperty
import javafx.beans.property.Property
import javafx.scene.control.Spinner

class AppIntSpinner(
    inputLabel: String,
    errorMessage: String = bundleMainApplication.validationGenericErrorMessage,
    isEditable: Boolean = true,
    val minValue: Int = 0,
    val maxValue: Int = Int.MAX_VALUE,
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
    ): Spinner<Int> = Spinner<Int>(minValue, maxValue, 0, 1).apply {
        maxWidth = MAIN_WIDTH
        fixedHeight(INPUT_HEIGHT)
        isEditable = editable
        skinProperty().addListener { _, _, newSkin ->
            if (newSkin != null) {
                lookup(".increment-arrow-button")?.isDisable = !editable
                lookup(".decrement-arrow-button")?.isDisable = !editable
            }
        }
        focusedProperty().addListener { _, _, focused ->
            isValidProperty.value = focused || inputValidation(this.value)
            if (!focused) {
                increment(0)
            }
        }
        disableProperty().addListener { _, _, newValue ->
            lookup(".increment-arrow-button")?.isDisable = newValue
            lookup(".decrement-arrow-button")?.isDisable = newValue
        }
    }

}
