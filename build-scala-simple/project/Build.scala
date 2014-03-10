import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._


object ApplicationBuild extends Build {

    lazy val root = Project(
        id = "hello_world",
        base = file("."),
        settings = Defaults.defaultSettings ++ packagerSettings ++ packageArchetype.java_server ++
          Seq(
            name := "Hello_World",
            Keys.normalizedName := "hello-world",
            packageSummary := "Hello World Package",
            packageDescription := "Say hello to the world from different packages",
            maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
          )
    )
}
