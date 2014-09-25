# Custom Package Format

This examples demonstrates how to create your own custom packaging
format. As an example we will create a text file that includes all
mappings.

```
sbt txtFormat:packageBin
```

# Core settings

The main part is the custom `packageBin in txtFormat` implementation.

First define a scope with

```scala
val TxtFormat = config("txtFormat")
```

and then implement `packageBin` for this scope

```scala
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
```
