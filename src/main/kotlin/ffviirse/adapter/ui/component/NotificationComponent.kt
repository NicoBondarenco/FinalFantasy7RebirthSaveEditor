package com.database.tesis.adapter.ui.component


import ffviirse.adapter.ui.theme.ThemeColor
import ffviirse.adapter.ui.theme.ThemeColor.BLUE_COLOR
import ffviirse.adapter.ui.theme.ThemeColor.GREEN_COLOR
import ffviirse.adapter.ui.theme.ThemeColor.PURPLE_COLOR
import ffviirse.adapter.ui.theme.ThemeColor.RED_COLOR
import ffviirse.adapter.ui.theme.ThemeColor.TEXT_COLOR
import ffviirse.adapter.ui.theme.ThemeColor.YELLOW_COLOR
import ffviirse.adapter.ui.theme.ThemeIcon
import ffviirse.adapter.ui.theme.ThemeIcon.ALERT_ERROR
import ffviirse.adapter.ui.theme.ThemeIcon.ALERT_HELP
import ffviirse.adapter.ui.theme.ThemeIcon.ALERT_INFO
import ffviirse.adapter.ui.theme.ThemeIcon.ALERT_SUCCESS
import ffviirse.adapter.ui.theme.ThemeIcon.ALERT_WARNING
import ffviirse.domain.context.session.SessionContext.appStage
import org.controlsfx.control.Notifications

fun showInfoNotification(
    title: String,
    text: String,
) = showDefaultNotification(title, text, ALERT_INFO, BLUE_COLOR, listOf("notification-display-info"))

fun showHelpNotification(
    title: String,
    text: String,
) = showDefaultNotification(title, text, ALERT_HELP, PURPLE_COLOR, listOf("notification-display-help"))

fun showSuccessNotification(
    title: String,
    text: String,
) = showDefaultNotification(title, text, ALERT_SUCCESS, GREEN_COLOR, listOf("notification-display-success"))

fun showWarningNotification(
    title: String,
    text: String,
) = showDefaultNotification(title, text, ALERT_WARNING, YELLOW_COLOR, listOf("notification-display-warning"))

fun showErrorNotification(
    title: String,
    text: String,
) = showDefaultNotification(title, text, ALERT_ERROR, RED_COLOR, listOf("notification-display-danger"))

fun showDefaultNotification(
    title: String,
    text: String,
    icon: ThemeIcon? = null,
    color: ThemeColor = TEXT_COLOR,
    styles: List<String> = listOf(),
) {
    val defaultStyles = listOf("notification-display")
    val notificationTitle = title.spaceChunked(50)
    val notificationText = text.spaceChunked(50)

    Notifications.create()
        .owner(appStage.scene.window)
        .title(notificationTitle)
        .text(notificationText)
        .styleClass(*(defaultStyles + styles).toTypedArray())
        .graphic(icon?.iconImage(50, color))
        .show()
}

private fun String.spaceChunked(size: Int): String = this.trim().let { text ->
    text.takeIf { it.length > size }?.let { content ->
        val result = StringBuilder()
        var remaining = content
        do {
            val temp = remaining.chunked(size)[0]
            val index = temp.lastIndexOf(" ").takeIf { it >= 0 } ?: temp.length
            result.append(temp.substring(0, index)).append("\n")
            remaining = remaining.substring(index).trimStart()
        } while (remaining.length > size)
        result.append(remaining)
        result.toString()
    } ?: text
}
