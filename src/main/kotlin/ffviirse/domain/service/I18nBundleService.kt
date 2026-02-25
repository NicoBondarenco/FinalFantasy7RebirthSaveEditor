package ffviirse.domain.service

import ffviirse.domain.i18n.I18nBundle
import org.springframework.stereotype.Service

@Service
class I18nBundleService(
    private val applicationBundles: Set<I18nBundle>
) {

    fun availableBundles(): Set<I18nBundle> = applicationBundles

}
