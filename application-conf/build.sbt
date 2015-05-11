import com.typesafe.sbt.packager.archetypes.ServerLoader

name := "mukis-application-conf"

version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.0"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

enablePlugins(JavaServerAppPackaging)

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

mappings in Universal += {
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = (resourceDirectory in Compile).value / "reference.conf"
    conf -> "conf/application.conf"
}
