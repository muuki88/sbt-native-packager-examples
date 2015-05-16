enablePlugins(JavaServerAppPackaging)

name := "simple-rpm"
organization := "de.muki"
version := "1.0"

mainClass in Compile := Some("de.mukis.MainApp")

// package settings
maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom startscript parameters"
packageDescription := "Custom startscript parameters"

// rpm specific
rpmRelease := "1"
rpmVendor := "mukis.de, Muki"
rpmUrl := Some("http://github.com/muuki88/sbt-native-packager")
rpmLicense := Some("Apache v2")

