plugins {
    id("io.micronaut.library") version "4.6.2"
    id("io.micronaut.openapi") version "4.6.2"
}

group = "ch.finma.iir"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.validation:micronaut-validation")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    sourceCompatibility = JavaVersion.toVersion("25")
    targetCompatibility = JavaVersion.toVersion("25")
}

micronaut {
    openapi {
        client(file("../iir-finma-api.json")) {
            lang = "java"
            apiPackageName = "ch.finma.iir.client.api"
            modelPackageName = "ch.finma.iir.client.model"
            useReactive = false
        }
    }
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("ch.finma.iir.*")
    }
}

tasks.withType<Test>().configureEach {
    testLogging {
        events("passed", "skipped", "failed")
    }
}
