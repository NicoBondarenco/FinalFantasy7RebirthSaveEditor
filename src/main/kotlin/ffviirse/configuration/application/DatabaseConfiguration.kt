package ffviirse.configuration.application

//import ffviirse.configuration.properties.DatabaseProperties
//import javax.sql.DataSource
//import kotlin.reflect.full.createInstance
//import kotlinx.coroutines.Dispatchers
//import org.flywaydb.core.Flyway
//import org.h2.engine.IsolationLevel
//import org.h2.jdbcx.JdbcDataSource
//import org.jetbrains.exposed.v1.core.DatabaseConfig
//import org.jetbrains.exposed.v1.core.Schema
//import org.jetbrains.exposed.v1.core.vendors.DatabaseDialect
//import org.jetbrains.exposed.v1.jdbc.Database
//import org.springframework.boot.context.properties.EnableConfigurationProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//@EnableConfigurationProperties(DatabaseProperties::class)
//class DatabaseConfiguration {
//
//    @Bean
//    fun databaseConfig(
//        properties: DatabaseProperties
//    ): DatabaseConfig = DatabaseConfig {
//        dispatcher = Dispatchers.IO
//        defaultIsolationLevel = IsolationLevel.valueOf(properties.isolationLevel).jdbc
//        defaultSchema = Schema(properties.defaultSchema)
//        defaultFetchSize = properties.fetchSize
//        defaultMaxAttempts = properties.maxAttempts
//        keepLoadedReferencesOutOfTransaction = false
//        defaultReadOnly = false
//        useNestedTransactions = properties.nestedTransactions
//        explicitDialect = Class.forName(properties.explicitDialect).kotlin.createInstance() as DatabaseDialect
//    }
//
//    @Bean
//    fun database(
//        properties: DatabaseProperties,
//        configuration: DatabaseConfig,
//        flyway: Flyway,
//    ): Database = Database.connect(
//        url = properties.connectionUrl,
//        user = properties.connectionUsername,
//        password = properties.connectionPassword,
//        databaseConfig = configuration,
//    )
//
//    @Bean
//    fun flywayDatasource(
//        properties: DatabaseProperties,
//    ): DataSource = JdbcDataSource().apply {
//        setUrl(properties.flywayUrl)
//        user = properties.connectionUsername
//        password = properties.connectionPassword
//    }
//
//    @Bean
//    fun flyway(
//        flywayDatasource: DataSource,
//        properties: DatabaseProperties,
//    ): Flyway = Flyway.configure(DatabaseConfiguration::class.java.classLoader).apply {
//        dataSource(flywayDatasource)
//        failOnMissingLocations(true)
//        createSchemas(true)
//        baselineOnMigrate(true)
//        schemas(properties.defaultSchema)
//        table(properties.flywayTable)
//        locations(properties.flywayLocation)
//    }.load().apply {
//        repair()
//        migrate()
//    }
//
//}
