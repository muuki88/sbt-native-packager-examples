# Custom Package Format

This examples demonstrates how to create your own custom packaging
format. As an example we will create a text file that includes all
mappings.

```
sbt txtFormat:packageBin
```

# Core settings

The main part is the custom `packageBin in txtFormat` implementation.
This is done via a custom `AutoPlugin` define under `project/TxtFormatPlugin.scala`


The main steps are

- defining a custom scope
- implementing the `packageBin` task

