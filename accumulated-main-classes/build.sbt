organization in ThisBuild := "rocks.muki"

lazy val root = project.in(file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "application",
    // add
    discoveredMainClasses in Compile ++= (discoveredMainClasses in (client, Compile)).value,
    discoveredMainClasses in Compile ++= (discoveredMainClasses in (server, Compile)).value
  )
  .dependsOn(client, server)

lazy val client = project.in(file("client"))
  .settings(
    name := "client"
  )

lazy val server = project.in(file("server"))
  .settings(
    name := "server"
  )
