group = "com.github.OpenEDGN"
version = "last"

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
    }
}
allprojects {

    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    for (childProject in childProjects.values) {
        delete(childProject.buildDir)
    }
}
