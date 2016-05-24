lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(
    name := "my-app",
    organization := "de.mukis",
    version := "1.0",
    scalaVersion := "2.11.7",
    mainClass in Compile := Some("de.mukis.ConfigApp"),
    libraryDependencies ++= Seq(
        "com.typesafe" % "config" % "1.2.1",
        "org.scalatest" %% "scalatest" % "2.2.4" % "it,test"
    ),
    // add integration tests to universal packaging
    mappings in Universal += {
      val jar = (sbt.Keys.`package` in IntegrationTest).value
      jar -> s"lib/${jar.getName}"
    }
  )
