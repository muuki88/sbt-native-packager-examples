package de.mukis

object MainApp extends App {

    println(System.getProperty("test", "no value"))
    println("Max Memory: " + (Runtime.getRuntime.maxMemory / (1024*1024)) + " Mb")

}
