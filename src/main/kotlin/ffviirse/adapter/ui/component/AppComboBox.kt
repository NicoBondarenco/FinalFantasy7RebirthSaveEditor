package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.domain.context.session.SessionContext.bundleMainApplication
import ffviirse.domain.functional.Labeled
import javafx.beans.property.Property
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import javafx.util.StringConverter

class AppComboBox<T>(
    itemList: ObservableList<T>,
    inputLabel: String,
    errorMessage: String = bundleMainApplication.validationGenericErrorMessage,
    itemConverter: StringConverter<T>? = null,
    inputValidation: (T) -> Boolean = { true }
) : AppField<T, ComboBox<T>>(inputLabel, errorMessage, DEFAULT_HEIGHT, inputValidation) {

    private val valueMap = itemList.associateBy { it.itemLabel }

    private val valueConverter = itemConverter ?: object : StringConverter<T>() {
        override fun toString(item: T): String = item.itemLabel
        override fun fromString(string: String): T = valueMap[string]!!
    }

    private val T.itemLabel: String
        get() = takeIf { it is Labeled }?.let { it as Labeled }?.label ?: toString()

    override val inputField: ComboBox<T> = comboBox(itemList)

    override val valueRetriever: (ComboBox<T>) -> T = { it.value }

    override val fieldValueProperty: Property<T> = inputField.valueProperty()

    init {
        initField()
    }

    private fun comboBox(itemList: ObservableList<T>): ComboBox<T> = ComboBox(itemList).apply {
        maxWidth = MAIN_WIDTH
        fixedHeight(INPUT_HEIGHT)
        focusedProperty().addListener { _, _, focused ->
            isValidProperty.value = focused || inputValidation(this.value)
        }
        converter = valueConverter
    }

}
