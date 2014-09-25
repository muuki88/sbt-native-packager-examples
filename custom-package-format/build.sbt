import NativePackagerKeys._

val TxtFormat = config("txtFormat")

val root = project.in(file("."))
    // adding your custom configuration scope
    .configs( TxtFormat )
    .settings(packageArchetype.java_server:_*)
    .settings(
        name := "mukis-custom-package",
        version := "1.0",
        mainClass in Compile := Some("de.mukis.ConfigApp"),
        maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>",
        packageSummary in Linux := "Custom application configuration",
        packageDescription := "Custom application configuration",
        // defining your custom configuration
        packageBin in TxtFormat := {
            val fileMappings = (mappings in Universal).value
            val output = target.value / s"${packageName.value}.txt"
            // create the is with the mappings. Note this is not the ISO format -.-
            IO.write(output, "# Filemappings\n")
            // append all mappings to the list
            fileMappings foreach {
                case (file, name) => IO.append(output, s"${file.getAbsolutePath}\t$name${IO.Newline}")
            }
            output
        }
    )

