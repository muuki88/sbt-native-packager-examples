package de.mukis

import java.util.concurrent.{ Executors, TimeUnit }
import java.nio.file.Files
import java.nio.file.StandardOpenOption._
import java.nio.charset.Charset

object MainApp extends App {

  val logFile = Files createTempFile ("mukis-", ".log")
  val log = Files newBufferedWriter (logFile, Charset forName "UTF-8")
  log write (s"Parameters:\t ${args mkString " "}")
  log newLine ()
  log write (s"System property: ${System.getProperty("de.mukis", "Property 'de.mukis' not found")}")
  log newLine ()
  log.close

  val interval = {
    try {
      args.indexOf( "-interval" ) match {
        case i if args.size >= i => args( i + 1 ).toInt
        case _                   => 10
      }
    } catch {
      case e: Exception =>
        10
    }
  }

  // Creating an executor service to schedule the config parsing
  val service = Executors newScheduledThreadPool 1
  service.scheduleAtFixedRate(new Runnable() {
    override def run() {
      val log = Files newBufferedWriter (logFile, Charset forName "UTF-8", APPEND)
      log write (s"Update:\t${System currentTimeMillis}")
      log.newLine
      log.close
    }
  }, 0, interval, TimeUnit.SECONDS)

}