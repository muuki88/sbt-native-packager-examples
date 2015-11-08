import sbt._
import sbt.Keys._
import com.typesafe.sbt.packager.Keys.packageName
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._

object TxtFormatPlugin extends AutoPlugin {

  // enable this plugin when all requirements are fullfilled (in this case JavaAppPackaging has been loaded)
  override def trigger = AllRequirements
  
  // depend on JavaAppPackaging
  override def requires = JavaAppPackaging
  
  // scope gets automatically imported
  object autoImport {
    val TxtFormat = config("txtFormat")
  }
  
  import autoImport._
  
  // project settings applied when this plugin is activated
  override def projectSettings = inConfig(TxtFormat)(Seq(
    // define a custom target directory
    target := target.value / "txt",
    
    // implementing the packageBin task
    packageBin := {
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
  ))
}
