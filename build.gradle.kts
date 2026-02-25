import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.lang)
    alias(libs.plugins.spring.framework.kotlin)
    alias(libs.plugins.spring.framework.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.java.fx.openfx)
    java
    application
}

application {
    mainClass.set("com.tesis.MainKt")
}

group = "com.tesis"
version = "1.0.0"

java.sourceCompatibility = JavaVersion.valueOf(libs.versions.target.get())
java.targetCompatibility = JavaVersion.valueOf(libs.versions.target.get())

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JvmTarget.valueOf(libs.versions.jvm.get()))
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-Xcontext-receivers",
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-java-parameters",
        )
    }
}

dependencies {
    implementation(platform(libs.javafx.ikonli.bom))

    implementation(libs.bundles.kotlin.stdlib.all)
    implementation(libs.bundles.kotlinx.coroutines.all)

    implementation(libs.bundles.log.logback.all)

    implementation(libs.bundles.spring.all)

    implementation(libs.bundles.javafx.all)

    implementation(libs.bundles.jackson.all)

    implementation(libs.bundles.database.all)

    implementation(libs.bundles.okhttp.all)

    testImplementation(libs.bundles.junit.all)
}

tasks.test {
    useJUnitPlatform()
    systemProperty("file.encoding", "UTF-8")
    systemProperty("user.timezone", "UTC")
    maxHeapSize = "1g"

    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
