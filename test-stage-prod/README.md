# Test/Stage/Prod packages

Create the same application package with different configuration files.

Build with

```bash
sbt
> testPackage / Universal / packageBin
> stagePackage / Universal / packageBin
> prodPackage / Universal / packageBin
```
