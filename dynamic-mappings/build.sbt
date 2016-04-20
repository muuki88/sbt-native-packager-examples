name := "my-app"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"

enablePlugins(JavaAppPackaging)

mappings in Universal += {
  // logic like this belongs into an AutoPlugin
  val confFile = buildEnv.value match {
    case BuildEnv.Developement => "dev.conf"
    case BuildEnv.Test => "test.conf"
    case BuildEnv.Stage => "stage.conf"
    case BuildEnv.Production => "prod.conf"
  }
  ((resourceDirectory in Compile).value / confFile) -> "conf/application.conf"
}
