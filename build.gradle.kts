plugins {
    id("java")
}

group = "mini.carlos.skyblock"
version = "1.0-SNAPSHOT"

subprojects{
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains:annotations:24.0.0")

        compileOnly("org.projectlombok:lombok:1.18.38")
        annotationProcessor("org.projectlombok:lombok:1.18.38")
    }
}
