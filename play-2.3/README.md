# Docker ready play build

```
sbt docker:publishLocal
docker run -p 9000:9000 play-2-3:1.0-SNAPSHOT
```

and you have a running docker container in play. Almost no configuration needed.

# build.sbt

This is the basic build.sbt with a bit of configuration to make docker work

* you need a maintainer for you docker image
* we expose the play ports

```scala
import NativePackagerKeys._ // with auto plugins this won't be necessary soon

name := "play-2.3"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

// setting a maintainer which is used for all packaging types
maintainer := "Nepomuk Seiler"

// exposing the play ports
dockerExposedPorts in Docker := Seq(9000, 9443)

// run this with: docker run -p 9000:9000 play-2-3:1.0-SNAPSHOT
```
