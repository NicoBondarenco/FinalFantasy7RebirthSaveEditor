package ffviirse.adapter.ui.theme

import ffviirse.domain.context.session.SessionContext.appTheme
import javafx.scene.paint.Color

enum class ThemeColor(
    val cssColor: String,
    val fxColor: () -> Color
) {

    WHITE_COLOR("-white-color", { Color.rgb(220, 220, 220) }),
    BLACK_COLOR("-black-color", { Color.rgb(25, 25, 25) }),
    GRAY_COLOR("-gray-color", { Color.rgb(50, 50, 50) }),
    RED_COLOR("-red-color", { Color.rgb(191, 47, 73) }),
    BLUE_COLOR("-blue-color", { Color.rgb(66, 134, 228) }),
    GREEN_COLOR("-green-color", { Color.rgb(40, 166, 67) }),
    YELLOW_COLOR("-yellow-color", { Color.rgb(253, 168, 9) }),
    PURPLE_COLOR("-purple-color", { Color.rgb(145, 88, 239) }),
    BROWN_COLOR("-brown-color", { Color.rgb(73, 37, 50) }),
    ORANGE_COLOR("-orange-color", { Color.rgb(255, 127, 80) }),
    GOLD_COLOR("-gold-color", { Color.rgb(255, 215, 0) }),
    SILVER_COLOR("-silver-color", { Color.rgb(192, 192, 192) }),
    BRASS_COLOR("-brass-color", { Color.rgb(205, 127, 50) }),
    CYAN_COLOR("-cyan-color", { Color.rgb(0, 170, 170) }),
    MAGENTA_COLOR("-magenta-color", { Color.rgb(139, 0, 139) }),
    OLIVE_COLOR("-olive-color", { Color.rgb(128, 128, 0) }),
    TEAL_COLOR("-teal-color", { Color.rgb(0, 120, 120) }),
    AVOCADO_COLOR("-avocado-color", { Color.rgb(86, 130, 3) }),
    SKY_COLOR("-sky-color", { Color.rgb(99, 197, 218) }),
    MAUVE_COLOR("-mauve-color", { Color.rgb(122, 73, 136) }),
    UMBER_COLOR("-umber-color", { Color.rgb(53, 35, 21) }),

    TEXT_COLOR("-color-button-fg", { Color.rgb(255, 255, 255).takeIf { appTheme.isDarkMode } ?: Color.rgb(0, 0, 0) }),
    ERROR_COLOR("-color-danger-4", { Color.rgb(255, 97, 88).takeIf { appTheme.isDarkMode } ?: Color.rgb(255, 97, 88) }),
    IMPORTANT_COLOR("-color-danger-5", { Color.rgb(255, 69, 58).takeIf { appTheme.isDarkMode } ?: Color.rgb(255, 69, 58) }),
    BACKGROUND_COLOR("-color-bg-default", { Color.rgb(35, 35, 35).takeIf { appTheme.isDarkMode } ?: Color.rgb(200, 200, 200) }),
    STRIPE_COLOR("-color-bg-stripe", { Color.rgb(70, 70, 70).takeIf { appTheme.isDarkMode } ?: Color.rgb(150, 150, 150) }),
    HOVER_COLOR("-color-bg-hover", { Color.rgb(105, 105, 105).takeIf { appTheme.isDarkMode } ?: Color.rgb(100, 100, 100) }),
    SURFACE_COLOR("-color-bg-overlay", { Color.rgb(25, 25, 25).takeIf { appTheme.isDarkMode } ?: Color.rgb(255, 255, 255) }),

    TRANSPARENT_COLOR("-transparent-color", { Color.TRANSPARENT });

}
