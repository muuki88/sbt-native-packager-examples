# Test/Stage/Prod packages

Create the same application package with different configuration files.

Build with

```bash
sbt
> testPackage/universal:packageBin
> stagePackage/universal:packageBin
> prodPackage/universal:packageBin
```
