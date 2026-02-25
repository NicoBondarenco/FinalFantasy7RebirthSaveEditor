package ffviirse.adapter.ui.extension


import ffviirse.adapter.ui.component.ComponentSize
import ffviirse.adapter.ui.theme.ThemeColor
import ffviirse.adapter.ui.theme.ThemeColor.TEXT_COLOR
import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region

fun Region.fixedWidth(width: Double) {
    this.prefWidth = width
    this.minWidth = width
    this.maxWidth = width
}

fun Region.fixedHeight(height: Double) {
    this.prefHeight = height
    this.minHeight = height
    this.maxHeight = height
}

fun Region.fixedSize(width: Double, height: Double) {
    this.prefWidth = width
    this.prefHeight = height
    this.minWidth = width
    this.minHeight = height
    this.maxWidth = width
    this.maxHeight = height
}

fun Region.fixedSize(size: ComponentSize) {
    this.prefWidth = size.width
    this.prefHeight = size.height
    this.minWidth = size.width
    this.minHeight = size.height
    this.maxWidth = size.width
    this.maxHeight = size.height
}

fun Region.solidBorder() = this.apply {
    border = Border(BorderStroke(TEXT_COLOR.fxColor(), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths(1.0)))
}

fun Region.withPadding(padding: Double) = this.withPadding(padding, padding, padding, padding)

fun Region.withPadding(vertical: Double, horizontal: Double) = this.withPadding(vertical, horizontal, vertical, horizontal)

fun Region.withPadding(top: Double, right: Double, bottom: Double, left: Double) {
    this.padding = Insets(top, right, bottom, left)
}

fun blueBackground() = background(ThemeColor.BLUE_COLOR)

fun transparentBackground() = background(ThemeColor.TRANSPARENT_COLOR)

fun defaultBackground() = background(ThemeColor.BACKGROUND_COLOR)

fun stripeBackground() = background(ThemeColor.STRIPE_COLOR)

fun hoverBackground() = background(ThemeColor.HOVER_COLOR)

fun background(color: ThemeColor) = Background(BackgroundFill(color.fxColor(), CornerRadii(0.0), Insets(0.0)))
