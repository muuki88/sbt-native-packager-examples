import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val scalacOptionsForOptimizer = Seq(
  // https://www.lightbend.com/blog/scala-inliner-optimizer
  "-Xmaxerrs", "1000", // the optimizer can sometimes print large numbers of errors and we'd like to see all of them
  "-Xmaxwarns", "1000", // the optimizer can sometimes print large numbers of warnings and we'd like to see all of them
  "-opt:-l:none,_", // enable all optimizations; the "_" means all optimizations; the first "-l:none" is a workaround for "_" turning on the "none" flag and in fact disabling all optimizations https://github.com/scala/bug/issues/11746
  "-opt-inline-from:**",
  // "-opt-warnings:-none,_", // enable optimizer warnings; the "_" means all warnings; the first "-none" is a workaround for "_" turning on the "none" flag and in fact disabling all warnings; currently the "warnings" emitted by this flag seem to be compile errors that fail the build https://github.com/scala/bug/issues/11746
  // "-Vopt", "_", // trace the optimizer progress for methods; `_` to print all, prefix match to select. -Vopt replaced -Yopt-trace
  // "-Vinline", "_", // print a summary of inliner activity; `_` to print all, prefix match to select. -Vinline replaced -Yopt-log-inline
)

lazy val root = (project in file("."))
  .settings(
    name := "sbt-optimize-prod-with-build-env-plugin-example",
    libraryDependencies += scalaTest % Test,
    scalacOptions ++= (buildEnv.value match {
      case BuildEnv.Production => {
        sLog.value.log(sbt.util.Level.Info, "Using scalac optimizer due to production build")
        scalacOptionsForOptimizer
      }
      case _ => Seq.empty
    })
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
