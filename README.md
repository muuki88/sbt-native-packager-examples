# Goal

This is a small collection of sbt-native-packager examples. Each example
is very small and should be easy to understand. Pick the ones you need
and tailor your packaging process.

# Examples

Currently all examples are tested for Debian only. Feel free to correct
and contribute.

## Application configuration

Your application has an external configuration, which you want to change
and the application should pick up this changes.

### Requirements

* Linux OS (debian/rpm)
* [Typesafe Config](https://github.com/typesafehub/config)

### How it's done

Typesafe config uses the system property `config.file` to pass
in a configuration location. So you don't need to add a folder to the
_classpath_, which could be a potential security risk.

### Project

You can find a working example at *application-conf*

## Log4j configuration

This is related to the _Application configuration_. This time we
use log4j.

### Requirements

* Linux OS (debian/rpm)
* [Log4j 2](http://logging.apache.org/log4j/2.x/) (works in a similar way with 1.x)

### How it's done

Log4j uses the system property `log4j.configurationFile` to pass
in a configuration location. So you don't need to add a folder to the
_classpath_, which could be a potential security risk.

Log4j 2 as also a cool [auto reconfigurate feature](http://logging.apache.org/log4j/2.x/manual/configuration.html#AutomaticReconfiguration),
which can come in very handy.

### Project

You can find a working example at *log4j-conf*

# Links

* [SBT Native Packager](https://github.com/sbt/sbt-native-packager)

