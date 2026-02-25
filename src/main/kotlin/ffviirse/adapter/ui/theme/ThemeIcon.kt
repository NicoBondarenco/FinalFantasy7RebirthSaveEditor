package ffviirse.adapter.ui.theme

import ffviirse.adapter.ui.theme.ThemeColor.TEXT_COLOR
import org.kordamp.ikonli.Ikon
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldAL
import org.kordamp.ikonli.coreui.CoreUiFree
import org.kordamp.ikonli.evaicons.Evaicons
import org.kordamp.ikonli.javafx.FontIcon

enum class ThemeIcon(
    private val ikon: Ikon
) {
    ALERT_ERROR(BytedanceIconsBoldAL.ERROR),
    ALERT_WARNING(AntDesignIconsOutlined.WARNING),
    ALERT_SUCCESS(CoreUiFree.CHECK),
    ALERT_INFO(Evaicons.INFO_OUTLINE),
    ALERT_HELP(BytedanceIconsBoldAL.HELP);

    fun iconImage(
        size: Int,
        color: ThemeColor = TEXT_COLOR
    ): FontIcon = FontIcon.of(ikon, size, color.fxColor()).apply {
        this.iconCode = ikon
        this.iconSize = size
        this.iconColor = TEXT_COLOR.fxColor()
        this.style += "-fx-icon-size: ${size}px !important;"
    }

}
