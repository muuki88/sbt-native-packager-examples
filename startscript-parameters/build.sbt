import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := "mukis-startscript-parameters"

version := "1.0"

mainClass in Compile := Some("de.mukis.MainApp")

packageArchetype.java_server

maintainer in Debian := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom startscript parameters"

packageDescription := "Custom startscript parameters"
