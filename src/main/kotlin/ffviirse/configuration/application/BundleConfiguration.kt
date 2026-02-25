package ffviirse.configuration.application

import ffviirse.domain.context.application.ApplicationConstant.LANGUAGES_PATH
import ffviirse.domain.context.session.SessionContext.changeBundle
import ffviirse.domain.i18n.I18nBundle
import java.io.File
import java.io.FileFilter
import java.nio.file.Paths
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tools.jackson.dataformat.yaml.YAMLMapper

@Configuration
class BundleConfiguration {

    @Bean
    fun applicationBundles(
        yamlMapper: YAMLMapper,
    ): Set<I18nBundle> = languageFiles().map {
        yamlMapper.readValue(it, I18nBundle::class.java)
    }.toSet()

    private fun languageFiles(): List<File> = Paths.get(LANGUAGES_PATH).toFile().listFiles(FileFilter {
        it.isFile && it.extension == "yaml"
    })?.takeIf {
        it.isNotEmpty()
    }?.toList() ?: throw IllegalStateException("No language files found in 'languages' directory")

}
