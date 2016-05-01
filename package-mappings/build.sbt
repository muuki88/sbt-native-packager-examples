import com.typesafe.sbt.packager.archetypes.ServerLoader
import NativePackagerHelper._

name := "mukis-package-mappings"
version := "1.0"

libraryDependencies += "com.typesafe" % "config" % "1.3.0"
libraryDependencies += "com.google.guava" % "guava" % "19.0" % "provided" extra("heroku" -> "true")

enablePlugins(JavaAppPackaging)

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

mappings in Universal += {
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = sourceDirectory.value / "main" / "resources" / "reference.conf"
    conf -> "conf/application.conf"
}


// add 'provided' library to zip package
mappings in Universal ++= {
  // calculate provided dependencies.
  val compileDep = (managedClasspath in Compile).value.toSet
  val runtimeDep = (managedClasspath in Runtime).value.toSet
  val provided = compileDep -- runtimeDep

  // create mappings
  fromClasspath(provided.toSeq, "jar", artifact => true)
}
