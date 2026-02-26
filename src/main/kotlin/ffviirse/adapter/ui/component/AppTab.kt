package com.database.tesis.adapter.ui.component

import ffviirse.adapter.ui.component.AppField
import ffviirse.adapter.ui.extension.fixedSize
import ffviirse.adapter.ui.theme.ThemeColor.BLUE_COLOR
import ffviirse.adapter.ui.theme.ThemeColor.TEXT_COLOR
import javafx.beans.property.StringProperty
import javafx.scene.Group
import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.layout.StackPane
import javafx.scene.text.Font
import javafx.scene.text.TextAlignment

abstract class AppTab(
    val position: Int,
    title: String,
) : Tab() {

    private val label: Label = Label(title).apply {
        textAlignment = TextAlignment.CENTER
        rotate = 90.0
        textFill = TEXT_COLOR.fxColor()
        font = Font(16.0)
        fixedSize(100.0, 20.0)
    }

    protected val validatableFields: MutableList<AppField<*, *>> = mutableListOf()

    val isValid: Boolean
        get() = validatableFields.all { it.isValid }

    val labelProperty: StringProperty
        get() = label.textProperty()

    init {
        val pane = StackPane(Group(label))
        this.graphic = pane
        this.selectedProperty().addListener { _, _, selected ->
            if (selected) {
                label.textFill = BLUE_COLOR.fxColor()
            } else {
                label.textFill = TEXT_COLOR.fxColor()
            }
        }
    }

    open fun reset() {

    }

}
