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

Typesafe config can pick jvm startup parameter `config.file` to pass
in a configuration location. So you don't need to add a folder to the
_classpath_, which could be a potential security risk.

### Project

You can find a working example at *application-conf*

# Links

* [SBT Native Packager](https://github.com/sbt/sbt-native-packager)

