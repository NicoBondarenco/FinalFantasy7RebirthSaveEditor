package ffviirse.adapter.ui.component

import ffviirse.adapter.ui.extension.fixedHeight
import ffviirse.adapter.ui.extension.transparentBackground
import ffviirse.adapter.ui.extension.withPadding
import ffviirse.adapter.ui.theme.ThemeColor
import ffviirse.domain.context.session.SessionContext.appBundle
import ffviirse.domain.context.session.SessionContext.appMessage
import ffviirse.domain.extension.nullString
import javafx.beans.binding.Bindings
import javafx.beans.property.BooleanProperty
import javafx.beans.property.Property
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.geometry.Pos
import javafx.scene.control.Control
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.text.Font

abstract class AppField<T, F : Control>(
    protected val inputLabel: String,
    protected val errorMessage: String = appMessage.validationGenericErrorMessage,
    protected val mainHeight: Double = DEFAULT_HEIGHT,
    protected val inputValidation: (T) -> Boolean = { true }
) : VBox() {

    companion object {
        @JvmStatic
        protected val MAIN_SPACING = 0.0

        @JvmStatic
        protected val MAIN_PADDING = 5.0

        @JvmStatic
        protected val MAIN_WIDTH = Double.MAX_VALUE

        @JvmStatic
        protected val DEFAULT_HEIGHT = 80.0

        @JvmStatic
        protected val MAIN_ALIGNMENT = Pos.TOP_LEFT

        @JvmStatic
        protected val SEPARATOR_HEIGHT = 2.0

        @JvmStatic
        protected val LABEL_FONT = 15.0

        @JvmStatic
        protected val LABEL_HEIGHT = 20.0

        @JvmStatic
        protected val ERROR_FONT = 10.0

        @JvmStatic
        protected val ERROR_HEIGHT = 15.0

        @JvmStatic
        protected val INPUT_HEIGHT = 40.0
    }

    abstract val inputField: F

    protected abstract val valueRetriever: (F) -> T

    val isValidProperty: BooleanProperty = SimpleBooleanProperty(true)
    val isValid: Boolean get() = isValidProperty.value

    private val fieldLabel: AppLabel = fieldLabel()
    val labelProperty: StringProperty
        get() = fieldLabel.textProperty()

    val errorProperty: StringProperty = SimpleStringProperty(nullString()).apply {
        bind(
            Bindings.createStringBinding({
                nullString().takeIf { isValid } ?: errorMessage
            }, isValidProperty)
        )
    }

    abstract val fieldValueProperty: Property<T>
    var fieldValue: T
        get() = fieldValueProperty.value
        set(value) {
            fieldValueProperty.value = value
        }

    protected fun initField() {
        spacing = MAIN_SPACING
        withPadding(MAIN_PADDING)
        maxWidth = MAIN_WIDTH
        maxHeight = mainHeight
        alignment = MAIN_ALIGNMENT
        children.addAll(fieldLabel, separator(), inputField, separator(), errorLabel())
    }

    private fun fieldLabel(): AppLabel = AppLabel(inputLabel).apply {
        maxWidth = MAIN_WIDTH
        font = Font.font(LABEL_FONT)
        fixedHeight(LABEL_HEIGHT)
    }

    private fun errorLabel(): Label = Label().apply {
        textFill = ThemeColor.ERROR_COLOR.fxColor()
        font = Font.font(ERROR_FONT)
        fixedHeight(ERROR_HEIGHT)
        maxWidth = MAIN_WIDTH
        textProperty().bind(errorProperty)
    }

    private fun separator(): Pane = Pane().apply {
        background = transparentBackground()
        maxWidth = MAIN_WIDTH
        fixedHeight(SEPARATOR_HEIGHT)
    }

    fun validate() {
        isValidProperty.set(inputValidation(fieldValue))
    }

}
