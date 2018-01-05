import NativePackagerKeys._

name := "mukis-fullstack"

// used like the groupId in maven
organization in ThisBuild := "de.mukis"

// all sub projects have the same version
version in ThisBuild := "1.0"

scalaVersion in ThisBuild := "2.11.2"

// common dependencies
libraryDependencies in ThisBuild ++= Seq(
    "com.typesafe" % "config" % "1.2.0"
)

// this is the root project, aggregating all sub projects
lazy val root = Project(
    id = "root",
    base = file("."),
    // configure your native packaging settings here
    settings = Seq(
        maintainer := "John Smith <john.smith@example.com>",
        packageDescription := "Fullstack Application",
        packageSummary := "Fullstack Application",
        // entrypoint
        mainClass in Compile := Some("de.mukis.frontend.ProductionServer")
    ),
    // always run all commands on each sub project
    aggregate = Seq(frontend, backend, api)
).enablePlugins(JavaServerAppPackaging) // enable app packaging on this project
 .dependsOn(frontend, backend, api) // this does the actual aggregation

// --------- Project Frontend ------------------
lazy val frontend = Project(
    id = "frontend",
    base = file("frontend")
) dependsOn(api)


// --------- Project Backend ----------------
lazy val backend = Project(
    id = "backend",
    base = file("backend")
) dependsOn(api)

// --------- Project API ------------------
lazy val api = Project(
    id = "api",
    base = file("api")
)
