package de.mukis

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.nio.file.Files
import java.nio.charset.Charset
import org.apache.logging.log4j.LogManager

object ConfigApp extends App {

  val log = LogManager getLogger "App"
  // Creating an executor service to schedule the config parsing
  val service = Executors newScheduledThreadPool 1
  service.scheduleAtFixedRate(new Runnable() {
    override def run() {
      log info s"${System.currentTimeMillis / 1000}\t test output"
    }
  }, 0, 2, TimeUnit.SECONDS)
}