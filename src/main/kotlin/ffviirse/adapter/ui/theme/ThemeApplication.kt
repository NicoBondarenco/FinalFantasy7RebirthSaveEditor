package ffviirse.adapter.ui.theme

import atlantafx.base.theme.Theme

class ThemeApplication private constructor(
    private val themeName: String,
    private val darkMode: Boolean,
    private val userAgentStylesheet: String,
    private val userAgentStylesheetBSS: String? = null
) : Theme {

    companion object {

        val DARK = ThemeApplication("application-dark", true, "/styles/application-dark.css")

    }

    override fun getName(): String = themeName

    override fun getUserAgentStylesheet(): String = userAgentStylesheet

    override fun getUserAgentStylesheetBSS(): String? = userAgentStylesheetBSS

    override fun isDarkMode(): Boolean = darkMode

}
