import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring") version "1.5.31"
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2020.0.4")
        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:2.2.6.RELEASE")
    }
}
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    api("org.springdoc:springdoc-openapi-ui:1.5.10")
    api("org.springdoc:springdoc-openapi-webmvc-core:1.5.10")
    api("org.springdoc:springdoc-openapi-kotlin:1.5.10")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
