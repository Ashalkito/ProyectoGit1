plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"
application {
    mainClassName="dam.psp.emuladores.gui.ProgramaEmuladores"
}
repositories {
    mavenCentral()
}
javafx{
    modules("javafx.controls","javafx.fxml") // módulos que usaremos
    version="21" // versión de JavaFX a utilizar
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate:hibernate-core:6.3.0.Final")
    implementation("mysql:mysql-connector-java:5.1.13")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("org.hibernate:hibernate-validator:8.0.1.Final")
    implementation("org.hibernate.validator:hibernate-validator-annotation-processor:8.0.1.Final")
    implementation("org.glassfish.expressly:expressly:5.0.0")
}

tasks.test {
    useJUnitPlatform()
}
//