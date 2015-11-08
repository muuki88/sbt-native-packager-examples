# Assembly 

This example demonstrates how to assembly a single jar.

## plugin.sbt

```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.0")
```

## build.sbt

Important settings

```scala
// we specify the name for our fat jar
jarName in assembly := "assembly-project.jar"

// removes all jar mappings in universal and appends the fat jar
mappings in Universal <<= (mappings in Universal, assembly in Compile) map { (mappings, fatJar) =>
    val filtered = mappings filter { case (file, name) =>  ! name.endsWith(".jar") }
    filtered :+ (fatJar -> ("lib/" + fatJar.getName))
}

// the bash scripts classpath only needs the fat jar
scriptClasspath := Seq( (jarName in assembly).value )
```
