# Dynamic mappings

Show case for using java system properties to change your build behaviour.
Used to create different output packages.


```bash
sbt -Denv=test universal:packageBin
sbt -Denv=stage universal:packageBin
sbt -Denv=prod universal:packageBin
```

The `BuildEnv` autoplugin is responsible for parsing the env parameter.
