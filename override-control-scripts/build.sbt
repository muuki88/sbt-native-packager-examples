import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := "mukis-override-control-scripts"

version := "1.0"

packageArchetype.java_server

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Override Control Scripts"

packageDescription := "Override post-install, pre-install scripts"

