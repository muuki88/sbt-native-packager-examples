package de.mukis

import akka.actor.{ ActorSystem, Props, Actor, ActorLogging }
import scala.concurrent.duration._
import scala.language.postfixOps

class Pong extends Actor with ActorLogging {
  def receive = {
    case "Ping" =>
      log.info( "Received Ping" )
      sender ! "Pong"
  }
}

class Ping extends Actor with ActorLogging {
  import context.dispatcher 
  val pong = context.actorOf( Props[Pong] )
  val tick = context.system.scheduler.schedule( 500 millis, 1 second, self, "Tick" )
  
  log.info( "Configuration value: " + context.system.settings.config.getConfig( "TestApp" ).getString( "myConfig" ) )
  
  def receive = {
    case "Tick" =>
      log.info( "Received Tick")
      pong ! "Ping"
    case "Pong" =>
      log.info( "Received Pong")
  }
}  