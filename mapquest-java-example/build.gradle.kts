plugins {
    id("mapquest.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":mapquest-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :mapquest-java-example:run` to run `Main`
    // Use `./gradlew :mapquest-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.mapquest.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
