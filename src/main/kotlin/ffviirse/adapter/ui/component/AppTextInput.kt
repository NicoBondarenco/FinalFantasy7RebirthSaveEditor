package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.domain.context.session.SessionContext.appBundle
import ffviirse.domain.context.session.SessionContext.appMessage
import javafx.beans.property.Property
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.control.TextInputControl

class AppTextInput<T: TextInputControl> private constructor(
    override val inputField: T,
    mainHeight: Double,
    fieldHeight: Double,
    inputLabel: String,
    errorMessage: String,
    inputValidation: (String) -> Boolean
) : AppField<String, T>(inputLabel, errorMessage, mainHeight, inputValidation) {

    companion object {

        @JvmStatic
        private val TOTAL_HEIGHT = 140.0

        @JvmStatic
        private val AREA_HEIGHT = 100.0

        fun textField(
            inputLabel: String,
            errorMessage: String = appMessage.validationGenericErrorMessage,
            inputValidation: (String) -> Boolean = { true }
        ): AppTextInput<TextField> = AppTextInput(
            inputField = TextField(),
            mainHeight = DEFAULT_HEIGHT,
            fieldHeight = INPUT_HEIGHT,
            inputLabel = inputLabel,
            errorMessage = errorMessage,
            inputValidation = inputValidation
        )

        fun textArea(
            inputLabel: String,
            errorMessage: String = appMessage.validationGenericErrorMessage,
            inputValidation: (String) -> Boolean = { true }
        ): AppTextInput<TextArea> = AppTextInput(
            inputField = TextArea().apply {
                isWrapText = true
            },
            mainHeight = TOTAL_HEIGHT,
            fieldHeight = AREA_HEIGHT,
            inputLabel = inputLabel,
            errorMessage = errorMessage,
            inputValidation = inputValidation
        )

    }

    override val valueRetriever: (T) -> String = { it.text }

    override val fieldValueProperty: Property<String> = inputField.textProperty()

    init {
        inputField.initInput(fieldHeight)
        initField()
    }

    private fun T.initInput(fieldHeight: Double) = this.apply {
        maxWidth = MAIN_WIDTH
        fixedHeight(fieldHeight)
        focusedProperty().addListener { _, _, focused ->
            isValidProperty.value = focused || inputValidation(this.text)
        }
    }

}
