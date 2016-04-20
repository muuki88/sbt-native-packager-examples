lazy val Prod = config("prod") extend(Universal) describedAs("scope to build production packages")
lazy val Stage = config("stage") extend(Universal) describedAs("scope to build staging packages")

lazy val app = project
  .in(file("."))
  .configs(Prod, Stage)
  .enablePlugins(JavaAppPackaging)
  // default settings
  .settings(
    name := "my-app",
    libraryDependencies += "com.typesafe" % "config" % "1.3.0"
  )
  // inheriting tasks and settings
  .settings(inConfig(Prod)(UniversalPlugin.projectSettings))
  .settings(inConfig(Prod)(JavaAppPackaging.projectSettings))
  // define custom settings
  .settings(inConfig(Prod)(Seq(
    // you have to override everything carefully
    packageName := "my-prod-app",
    executableScriptName := "my-prod-app",
    // this is what we acutally want to change
    mappings += ((resourceDirectory in Compile).value / "prod.conf") -> "conf/application.conf"
  )))
