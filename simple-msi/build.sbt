import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := "simple-msi"

version := "1.0"

mainClass in Compile := Some("de.mukis.MainApp")

packageArchetype.java_server

maintainer in Windows := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Windows := "Custom startscript parameters"

packageDescription := "Custom startscript parameters"

