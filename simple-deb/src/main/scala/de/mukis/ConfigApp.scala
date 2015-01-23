package de.mukis

import com.typesafe.config.ConfigFactory

object TestApp extends App {
  val config = ConfigFactory.load()
  println(config.getString("example.greeting"))
}
