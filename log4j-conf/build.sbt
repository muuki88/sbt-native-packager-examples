import com.typesafe.sbt.SbtNativePackager._
import com.typesafe.sbt.packager.archetypes.ServerLoader
import NativePackagerKeys._

name := "mukis-log4j-conf"

version := "1.0"

libraryDependencies ++= Seq(
    "org.apache.logging.log4j" % "log4j-api" % "2.0-rc1",
    "org.apache.logging.log4j" % "log4j-core" % "2.0-rc1"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

packageArchetype.java_server

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom log4j configuration"

packageDescription := "Custom log4j configuration"

mappings in Universal <+= (packageBin in Compile, sourceDirectory ) map { (_, src) =>
    val conf = src / "main" / "resources" / "log4j.xml"
    conf -> "conf/log4j.xml"
}
