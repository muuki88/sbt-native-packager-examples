package de.mukis

import com.typesafe.config.ConfigFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.nio.file.Files
import java.nio.charset.Charset

object ConfigApp extends App {

  val logFile = Files.createTempFile("mukis-", ".log")

  // Creating an executor service to schedule the config parsing
  val service = Executors newScheduledThreadPool 1
  service.scheduleAtFixedRate(new Runnable() {
    override def run() {
      // Loading config
      ConfigFactory.invalidateCaches
      val config = ConfigFactory load () getConfig ("mukis")

      // Writing the config content to the logfile
      val log = Files.newBufferedWriter(logFile, Charset forName "UTF-8")
      log write (s"User:\t${config.root render ()}")
      log.newLine
      log.close
    }
  }, 0, 5, TimeUnit.SECONDS)
}