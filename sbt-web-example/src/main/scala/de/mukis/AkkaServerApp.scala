package de.mukis

import akka.actor.{ ActorSystem, Props }
import scala.concurrent.duration._
import com.typesafe.config.ConfigFactory

object AkkaServerApp extends App{
  val config = ConfigFactory.load
  val system = ActorSystem( "AkkaServerApp", config.withFallback( config ) )
  val ping = system.actorOf( Props[Ping] )
}