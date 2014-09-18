# Assembly 

This example demonstrates how to assembly a single jar.

## plugin.sbt

```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")
```

## build.sbt

```scala
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

mappings in Universal <+= (packageBin in Compile, sourceDirectory ) map { (_, src) =>
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = src / "main" / "resources" / "reference.conf"
    conf -> "conf/application.conf"
}

// removes all jar mappings in universal and appends the fat jar
mappings in Universal <<= (mappings in Universal, assembly in Compile) map { (mappings, fatJar) =>
    val filtered = mappings filter { case (file, name) =>  ! name.endsWith(".jar") }
    filtered :+ (fatJar -> ("lib/" + fatJar.getName))
}

// the bash scripts classpath only needs the fat jar
scriptClasspath := Seq( (jarName in assembly).value )
```
