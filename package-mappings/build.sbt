import com.typesafe.sbt.SbtNativePackager._
import com.typesafe.sbt.packager.archetypes.ServerLoader
import NativePackagerKeys._

name := "mukis-package-mappings"

version := "1.0"

packageArchetype.java_application

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"

packageSummary in Linux := "Custom application configuration"

packageDescription := "Custom application configuration"

mappings in Universal <+= (packageBin in Compile, sourceDirectory ) map { (_, src) =>
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = src / "main" / "resources" / "reference.conf"
    conf -> "conf/application.conf"
}
