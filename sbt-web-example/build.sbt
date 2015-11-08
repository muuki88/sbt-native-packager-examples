enablePlugins(
  JavaServerAppPackaging,
  SbtWeb
)

name := "mukis-akka-server-app"
version := "1.0"

val akkaVersion = "2.3.9"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)

mainClass in Compile := Some("de.mukis.AkkaServerApp")

maintainer := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary := "Custom application configuration"
packageDescription := "Custom application configuration"

