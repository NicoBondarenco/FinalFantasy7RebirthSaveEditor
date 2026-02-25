package ffviirse.configuration.application

import ffviirse.domain.context.application.ApplicationConstant.CONFIGURATION_FILE
import ffviirse.domain.context.application.ApplicationConstant.STEAM_PATH
import ffviirse.domain.context.application.ExternalProperties
import java.io.File
import java.io.FileFilter
import java.nio.file.Paths
import java.util.Locale
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExternalConfiguration {

    companion object {
        private const val SAVE_DIRECTORY_PROPERTY = "save.directory"
        private const val LOCALE_TAG_PROPERTY = "locale.tag"
    }

    private val saveDirectoryDefault
        get() = (findSteamDirectory() ?: System.getProperty("user.home"))
    private val localeTagDefault
        get() = Locale.getDefault().toLanguageTag()

    @Bean
    fun externalProperties(): ExternalProperties = configurationFile().let {
        ExternalProperties(
            saveDirectory = it.getOrDefault(SAVE_DIRECTORY_PROPERTY, saveDirectoryDefault),
            localeTag = it.getOrDefault(LOCALE_TAG_PROPERTY, localeTagDefault)
        )
    }

    private fun configurationFile(): Map<String, String> = Paths.get(CONFIGURATION_FILE).toFile().apply {
        if (!this.exists()) {
            this.writeText(defaultConfiguration())
        }
    }.readLines().filter { it.trim().isNotEmpty() }.map {
        it.split("=")
    }.associate { (first, second) -> first to second }

    private fun findSteamDirectory(): String? = File("${System.getProperty("user.home")}$STEAM_PATH").takeIf {
        it.exists()
    }?.let { file ->
        file.listFiles(FileFilter { it.isDirectory })?.firstOrNull()?.absolutePath
    }

    private fun defaultConfiguration(): String = buildString {
        appendLine("$SAVE_DIRECTORY_PROPERTY=$saveDirectoryDefault")
        appendLine("$LOCALE_TAG_PROPERTY=$localeTagDefault")
    }

}
