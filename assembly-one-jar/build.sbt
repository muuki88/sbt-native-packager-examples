import NativePackagerKeys._
import AssemblyKeys._

name := "assemblyProject"

version := "1.0"

// add some dependencies
libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.2.0",
    "com.google.guava" % "guava" % "18.0"
)

mainClass in Compile := Some("de.mukis.ConfigApp")

// the assembly settings
assemblySettings

// we specify the name for our fat jar
jarName in assembly := "assembly-project.jar"

// using the java server for this application
packageArchetype.java_server

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom application configuration"

packageDescription := "Custom application configuration"

// removes all jar mappings in universal and appends the fat jar
mappings in Universal := {
    // universalMappings: Seq[(File,String)]
    val universalMappings = (mappings in Universal).value 
    val fatJar = (assembly in Compile).value
    // removing means filtering
    val filtered = universalMappings filter { 
        case (file, name) =>  ! name.endsWith(".jar") 
    }
    // add the fat jar
    filtered :+ (fatJar -> ("lib/" + fatJar.getName))
}
    

// the bash scripts classpath only needs the fat jar
scriptClasspath := Seq( (jarName in assembly).value )
