package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.domain.context.session.SessionContext.appLabel
import ffviirse.domain.context.session.SessionContext.appMessage
import javafx.beans.property.Property
import javafx.beans.property.StringProperty
import javafx.scene.control.CheckBox

class AppCheckBox(
    inputLabel: String,
    errorMessage: String = appMessage.validationGenericErrorMessage,
    inputValidation: (Boolean) -> Boolean = { true }
) : AppField<Boolean, CheckBox>(inputLabel, errorMessage, DEFAULT_HEIGHT, inputValidation) {

    override val inputField: CheckBox = checkBox()

    override val valueRetriever: (CheckBox) -> Boolean = { it.isSelected }

    override val fieldValueProperty: Property<Boolean> = inputField.selectedProperty()

    override val labelProperty: StringProperty
        get() = inputField.textProperty()

    init {
        initField()
    }

    private fun checkBox(): CheckBox = CheckBox(appLabel.appCheckboxDefaultLabel).apply {
        maxWidth = MAIN_WIDTH
        fixedHeight(INPUT_HEIGHT)
        focusedProperty().addListener { _, _, focused ->
            isValidProperty.value = focused || inputValidation(this.isFocused)
        }
    }

}
