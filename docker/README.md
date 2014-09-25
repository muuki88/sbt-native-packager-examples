# Docker

This example demonstrates the settings for a docker build.

```bash
sbt docker:publishLocal
```

# Core settings


```scala
import NativePackagerKeys._

packageArchetype.java_server

maintainer in Docker := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

// Only add this if you want to rename your docker image name
packageName in Docker := "docking-station"
```
