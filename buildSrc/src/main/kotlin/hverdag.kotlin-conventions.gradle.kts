plugins {
    base
    kotlin("jvm")
    id("idea")
}

group = "hverdag"
version = "0.1"

repositories {
    mavenCentral()
    gradlePluginPortal()
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0-Beta4")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
}



kotlin {
    jvmToolchain(21)
    jvmToolchain { vendor = JvmVendorSpec.ADOPTIUM }
}


tasks.test {
    useJUnitPlatform()
}