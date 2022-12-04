plugins {
    java
    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("org.sonarqube") version "3.5.0.2730"
    id("org.springdoc.openapi-gradle-plugin") version "1.5.0"
}

group = "com.personal.asr"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

sonarqube {
    properties {
        property("sonar.projectKey", "caching-example")
        property("sonar.organization", "my-experiments")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.exclusions", "**/build/**/*")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.13")
    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.13")
    implementation("org.springdoc:springdoc-openapi-javadoc:1.6.13")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
