package ffviirse.configuration.application

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import com.fasterxml.jackson.annotation.PropertyAccessor.ALL
import ffviirse.configuration.deserializer.I18nModule
import ffviirse.configuration.serializer.FileModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tools.jackson.core.StreamWriteFeature.WRITE_BIGDECIMAL_AS_PLAIN
import tools.jackson.databind.DeserializationFeature.FAIL_ON_INVALID_SUBTYPE
import tools.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import tools.jackson.databind.JacksonModule
import tools.jackson.databind.ObjectMapper
import tools.jackson.databind.PropertyNamingStrategies.LOWER_CAMEL_CASE
import tools.jackson.databind.PropertyNamingStrategies.SNAKE_CASE
import tools.jackson.databind.PropertyNamingStrategy
import tools.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS
import tools.jackson.databind.cfg.DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS
import tools.jackson.databind.cfg.MapperBuilder
import tools.jackson.databind.json.JsonMapper
import tools.jackson.dataformat.yaml.YAMLMapper
import tools.jackson.module.kotlin.KotlinFeature.NullIsSameAsDefault
import tools.jackson.module.kotlin.KotlinFeature.NullToEmptyCollection
import tools.jackson.module.kotlin.KotlinFeature.NullToEmptyMap
import tools.jackson.module.kotlin.KotlinFeature.SingletonSupport
import tools.jackson.module.kotlin.KotlinFeature.StrictNullChecks
import tools.jackson.module.kotlin.KotlinModule

@Configuration
class JacksonConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper = JsonMapper.builder()
        .buildMapper(SNAKE_CASE, setOf(FileModule()))

    @Bean
    fun yamlMapper(): YAMLMapper = YAMLMapper.builder()
        .buildMapper(LOWER_CAMEL_CASE, setOf(I18nModule()))

    private fun <T : ObjectMapper, B : MapperBuilder<T, B>> MapperBuilder<T, B>.buildMapper(
        namingStrategy: PropertyNamingStrategy,
        extraModules: Set<JacksonModule>,
    ): T = this.addModules(extraModules)
        .addModule(
            KotlinModule.Builder()
                .withReflectionCacheSize(512)
                .configure(NullToEmptyCollection, false)
                .configure(NullToEmptyMap, false)
                .configure(NullIsSameAsDefault, false)
                .configure(SingletonSupport, false)
                .configure(StrictNullChecks, false)
                .build()
        ).propertyNamingStrategy(namingStrategy)
        .changeDefaultVisibility {
            it.withVisibility(ALL, ANY)
        }
        .enable(WRITE_BIGDECIMAL_AS_PLAIN)
        .disable(FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(FAIL_ON_INVALID_SUBTYPE)
        .disable(WRITE_DATES_AS_TIMESTAMPS)
        .disable(FAIL_ON_EMPTY_BEANS)
        .build()

}
