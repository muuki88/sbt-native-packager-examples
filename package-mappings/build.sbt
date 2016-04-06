import com.typesafe.sbt.packager.archetypes.ServerLoader

name := "mukis-package-mappings"
version := "1.0"

enablePlugins(JavaAppPackaging)

maintainer in Linux := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Linux := "Custom application configuration"
packageDescription := "Custom application configuration"

mappings in Universal += {
    // we are using the reference.conf as default application.conf
    // the user can override settings here
    val conf = sourceDirectory.value / "main" / "resources" / "reference.conf"
    conf -> "conf/application.conf"
}
