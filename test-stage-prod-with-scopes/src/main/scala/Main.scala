import com.typesafe.config.ConfigFactory

object Main extends App {

  val config = ConfigFactory.load
  val env = config.getString("env")

  println(s"This package runs in $env")

}
