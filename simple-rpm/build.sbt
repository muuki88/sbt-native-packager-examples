import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := "simple-rpm"

version := "1.0"

mainClass in Compile := Some("de.mukis.MainApp")

packageArchetype.java_server

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom startscript parameters"

packageDescription := "Custom startscript parameters"

rpmRelease := "1"

rpmVendor := "mukis.de, Muki"

rpmUrl := Some("http://github.com/muuki88/sbt-native-packager")

rpmLicense := Some("Apache v2")

