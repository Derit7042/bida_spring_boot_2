plugins {
    id("java")
}

group = "com.busan"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation ("org.springframework.boot:spring-boot-starter-test:3.2.9")
    testRuntimeOnly     ("org.junit.platform:junit-platform-launcher")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.junit.jupiter:junit-jupiter-params")
    testImplementation ("org.junit.jupiter:junit-jupiter-api")
    testImplementation ("org.assertj:assertj-core:3.24.2")
    testImplementation ("org.hamcrest:hamcrest:3.0")
}

tasks.test {
    useJUnitPlatform()
}