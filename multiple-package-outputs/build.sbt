import sbt._

name := "multiplatform-app"

version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.0"
)

enablePlugins(JavaServerAppPackaging)

mainClass in Compile := Some("de.mukis.TestApp")

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

rpmVendor := "mukis.de"
rpmUrl := Some("http://github.com/muuki88/sbt-native-packager-examples")
rpmLicense := Some("Apache 2")

// Creating custom packageOutputs formats

addCommandAlias("packageAll", "; clean " + 
                              "; set serverLoading in Debian := com.typesafe.sbt.packager.archetypes.ServerLoader.SystemV" +
                              "; packageDebianSystemV " +
                              "; clean " + 
                              "; set serverLoading in Debian := com.typesafe.sbt.packager.archetypes.ServerLoader.Upstart" +
                              "; packageDebianUpstart " + 
                              "; packageRpmSystemD")

lazy val packageDebianUpstart = taskKey[File]("creates deb-upstart package")
lazy val packageDebianSystemV = taskKey[File]("creates deb-systenv package")
lazy val packageRpmSystemD = taskKey[File]("creates rpm-systenv package")

packageDebianUpstart := {
  val output = baseDirectory.value / "package" / "deb-upstart"
  val debianFile = (packageBin in Debian).value
  IO.move(debianFile, output)
  output
}

packageDebianSystemV := {
  val output = baseDirectory.value / "package" / "deb-systemv"
  val debianFile = (packageBin in Debian).value
  IO.move(debianFile, output)
  output
}

packageRpmSystemD := {
  val output = baseDirectory.value / "package" / "rpm-systemd"
  val rpmFile = (packageBin in Rpm).value
  IO.move(rpmFile, output)
  output
}


