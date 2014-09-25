import com.typesafe.sbt.SbtNativePackager._
import com.typesafe.sbt.packager.archetypes.ServerLoader
import NativePackagerKeys._

name := "mukis-docking-station"

version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.0"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

packageArchetype.java_server

maintainer in Docker := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Docker := "A small docker application"

packageDescription := "Docker [micro|nano] Service"

// Only add this if you want to rename your docker image name
packageName in Docker := "docking-station"
