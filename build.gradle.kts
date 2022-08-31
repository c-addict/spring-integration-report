plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    /**
     * Spring Boot starters
     */
    implementation("org.springframework.boot:spring-boot-starter:2.7.3")
    implementation("org.springframework.boot:spring-boot-starter-integration:2.7.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.3")

    /**
     * Common dependencies
     */
    implementation("org.projectlombok:lombok:1.18.24")


    /**
     * Testing
     */
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}