enablePlugins(JavaServerAppPackaging)

name := "mukis-application-conf"

version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.1",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

mappings in Universal += {
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = (resourceDirectory in Compile).value / "reference.conf"
    conf -> "conf/application.conf"
}

// for publish task
// import com.typesafe.sbt.packager.SettingsHelper
// SettingsHelper.addPackage(Debian, packageBin in Test, "jar")

mappings in Universal += {
  var testjar = (packageBin in Test).value
  testjar -> s"lib/${testjar.getName}"
}
