enablePlugins(JavaServerAppPackaging)

name := "mukis-startscript-parameters"

version := "1.0"

mainClass in Compile := Some("de.mukis.MainApp")

maintainer in Debian := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom startscript parameters"

packageDescription := "Custom startscript parameters"
