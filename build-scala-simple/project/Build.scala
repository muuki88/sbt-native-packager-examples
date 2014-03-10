import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._


object ApplicationBuild extends Build {

    lazy val root = Project(
        id = "helloWorld",
        base = file("."),
        settings = Defaults.defaultSettings ++ packagerSettings ++ packageArchetype.java_server ++
          Seq(
            name := "Hello World",
            packageSummary := "Hello World Package",
            packageDescription := "Say hello to the world from different packages",
            maintainer in Windows := "Typesafe Inc.",
            maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
          )
    )
}
