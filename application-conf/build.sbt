enablePlugins(SbtNativePackager)
enablePlugins(JavaAppPackaging)

name := "mukis-application-conf"

version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.1"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom application configuration"

packageDescription := "Custom application configuration"

mappings in Universal <+= (packageBin in Compile, sourceDirectory ) map { (_, src) =>
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = src / "main" / "resources" / "reference.conf"
    conf -> "conf/application.conf"
}
