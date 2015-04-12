enablePlugins(JavaServerAppPackaging)

name := "mukis-startscript-parameters"

version := "1.0"

mainClass in Compile := Some("de.mukis.MainApp")

maintainer in Debian := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom startscript parameters"

packageDescription := "Custom startscript parameters"

rpmVendor := "Nepomuk Seiler"

rpmLicense := Some( "GNU/GPLv3" )

// Variant 1:
// javaOptions in Universal ++= Seq("mukis-startscript-parameters", "-Dde.mukis=Tester", "-interval", "20")
// Variant 2:
// src/templates/application.ini
