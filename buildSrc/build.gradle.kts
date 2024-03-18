plugins {
  `kotlin-dsl`
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0-Beta4")
}

repositories {
  gradlePluginPortal() // so that external plugins can be resolved in dependencies section
}
