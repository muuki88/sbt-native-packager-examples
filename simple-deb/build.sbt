import com.typesafe.sbt.packager.archetypes.TemplateWriter

name := "mukis-application-conf"
version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.0"
)

enablePlugins(JavaServerAppPackaging)

mainClass in Compile := Some("de.mukis.TestApp")

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

bashScriptConfigLocation := Some("${app_home}/../conf/jvmopts")
bashScriptExtraDefines += """addJava "-Dconfig.file=${app_home}/../conf/app.config""""

// how to override loader functions
linuxScriptReplacements += {
  val functions = sourceDirectory.value / "templates" / "custom-loader-functions"
  "loader-functions" -> TemplateWriter.generateScript(functions.toURL, Nil)
}
