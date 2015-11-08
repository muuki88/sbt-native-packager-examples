// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.url("GitHub repository", url("http://shaggyyeti.github.io/releases"))(Resolver.ivyStylePatterns)

// SBT web
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.2.1")
addSbtPlugin("default" % "sbt-sass" % "0.1.9")

addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.0.2")


