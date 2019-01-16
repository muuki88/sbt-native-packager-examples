// the application itself
lazy val app = project
  .in(file("."))
  .settings(
    name := "my-app",
    libraryDependencies += "com.typesafe" % "config" % "1.3.0"
  )

// --------------------------------------
// -------- Package Submodules ----------
// --------------------------------------
lazy val testPackage = project
  .in(file("build/test"))
  .enablePlugins(JavaAppPackaging)
  .settings(
    Compile / mainClass := (app / Compile / mainClass).value,
    Compile / resourceDirectory := (app / Compile / resourceDirectory).value,
    Universal / mappings += {
      ((resourceDirectory in Compile).value / "test.conf") -> "conf/application.conf"
    }
  )
  .dependsOn(app)

lazy val stagePackage = project
  .in(file("build/stage"))
  .enablePlugins(JavaAppPackaging)
  .settings(
    Compile / mainClass := (app / Compile / mainClass).value,
    Compile / resourceDirectory := (app / Compile / resourceDirectory).value,
    Universal / mappings += {
      ((resourceDirectory in Compile).value / "stage.conf") -> "conf/application.conf"
    }
  )
  .dependsOn(app)

lazy val prodPackage = project
  .in(file("build/prod"))
  .enablePlugins(JavaAppPackaging)
  .settings(
    Compile / mainClass := (app / Compile / mainClass).value,
    Compile / resourceDirectory := (app / Compile / resourceDirectory).value,
    Universal / mappings += {
      ((Compile / resourceDirectory).value / "prod.conf") -> "conf/application.conf"
    }
  )
  .dependsOn(app)
