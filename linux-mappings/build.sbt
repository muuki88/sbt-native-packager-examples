import NativePackagerKeys._
import AssemblyKeys._

name := "customLinuxMappings"

version := "1.0"

// add some dependencies
libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.0",
    "com.google.guava" % "guava" % "18.0"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

packageArchetype.java_server

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom application configuration"

packageDescription := "Custom application configuration"

// Adding a custom mapping. You can also put the file under :
// src/linux/usr/share/customlinuxmappings/bin/install.sh
linuxPackageMappings += {
    val file = sourceDirectory.value / "resources" / "install.sh"
    packageMapping( (file, "/usr/share/customlinuxmappings/bin/install.sh") )
}

// Add mapping only for deb packages
linuxPackageMappings in Debian += {
    val file = sourceDirectory.value / "resources" / "install.sh"
    packageMapping( (file, "/usr/share/customlinuxmappings/bin/debian-install.sh") )
}

// Altering permissions for configs
linuxPackageMappings := {
    val mappings = linuxPackageMappings.value
    // Changing the group for all configs
    mappings map { 
        case linuxPackage if linuxPackage.fileData.config equals "true" =>
            // altering the group
            val newFileData = linuxPackage.fileData.copy(
                group = "appdocs"
            )
            // altering the LinuxPackageMapping
            linuxPackage.copy(
                fileData = newFileData
            )
        case linuxPackage => linuxPackage
    }
}

// remove all non jar files
linuxPackageMappings := { 
    val mappings = linuxPackageMappings.value
    mappings map { mapping =>
        val filtered = mapping.mappings filter {
            case (file, name) => name endsWith ".jar"
        }
        mapping.copy(mappings = filtered)
    } filter{
        _.mappings.nonEmpty
    } 
 }
 
 // change symlinks
 
 linuxPackageSymlinks := Seq.empty
