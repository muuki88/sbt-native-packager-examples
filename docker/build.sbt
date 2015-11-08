name := "mukis-docking-station"
version := "1.0"

enablePlugins(JavaAppPackaging)

maintainer in Docker := "Nepomuk Seiler <nepomuk.seiler@mukis.de>"
packageSummary in Docker := "A small docker application"
packageDescription := "Docker [micro|nano] Service"

// Only add this if you want to rename your docker image name
packageName in Docker := "docking-station"
