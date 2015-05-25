enablePlugins(JavaServerAppPackaging)

name := "mukis-akka-server-app"
version := "1.0"

val akkaVersion = "2.3.9"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-kernel" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)

mainClass in Compile := Some("de.mukis.AkkaServerApp")

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

rpmVendor := "Nepomuk Seiler"
rpmLicense := Some( "Apache" )

mappings in Universal <+= (packageBin in Compile, sourceDirectory ) map { (_, src) =>
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = src / "main" / "resources" / "application.conf"
    conf -> "conf/application.conf"
}
