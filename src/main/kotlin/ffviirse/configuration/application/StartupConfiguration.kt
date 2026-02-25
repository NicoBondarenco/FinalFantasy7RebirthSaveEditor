package ffviirse.configuration.application

import ffviirse.domain.context.application.ApplicationConstant.BACKUP_PATH
import ffviirse.domain.context.application.ExternalProperties
import ffviirse.domain.context.session.SessionContext.changeBundle
import ffviirse.domain.i18n.I18nBundle
import java.nio.file.Paths
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class StartupConfiguration(
    private val applicationBundles: Set<I18nBundle>,
    private val externalProperties: ExternalProperties,
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        changeBundle()
        createDirectory(BACKUP_PATH)
    }

    private fun changeBundle() {
        val bundle = applicationBundles.firstOrNull {
            it.languageTag.lowercase() == externalProperties.localeTag.lowercase()
        } ?: applicationBundles.minByOrNull { it.displayOrder }!!
        changeBundle(bundle)
    }

    private fun createDirectory(path: String) = Paths.get(path).toFile().mkdirs()

}
