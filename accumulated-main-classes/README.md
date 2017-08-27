# Accumulated main classes

This example demonstrates how to accumulate multiple sub modules with one or more executable classes
into a single project that has all of them.


```bash
$ sbt universal:stage
$ ./target/universal/stage/bin/client-app
$ ./target/universal/stage/bin/server-app
```

## Explanation

The core idea is to create a module that depends on all all the sub modules you want to include and
configure all settings on this module.

```scala
lazy val root = project.in(file("."))
   // package the root module, but not the sub modules
  .enablePlugins(JavaAppPackaging)
  // include these modules in the resulting package
  .dependsOn(client, server)

// the modules you want to have in your application
lazy val client = project.in(file("client"))
lazy val server = project.in(file("server"))
```

To get all the available main classes, we use the `discoveredMainClasses` setting of sbt. It's scoped
to `Compile` or `Test` (the main classes in your application or test code). We now access the main classes
from the other projects `client` and `server` by scoping them to the right axis:


```scala
lazy val root = project.in(file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    // add the discoveredMainClasses to this project
    discoveredMainClasses in Compile ++= (discoveredMainClasses in (client, Compile)).value,
    discoveredMainClasses in Compile ++= (discoveredMainClasses in (server, Compile)).value
  )
```

The `(discoveredMainClasses in (client, Compile)).value` accesses the `discoveredMainClasses`
from the `client` project in the `Compile` scope.
