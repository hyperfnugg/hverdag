plugins {
  id("hverdag.app-conventions")
}

application {
  mainClass.set("moutza.Main")
}

dependencies {
  implementation(project(":common"))
  dependencies {
    implementation(platform("org.http4k:http4k-bom:5.14.1.0"))
    implementation("org.http4k:http4k-htmx")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.11.0")
    runtimeOnly("org.webjars.npm:github-com-mblode-marx:4.0.0")
  }
}
