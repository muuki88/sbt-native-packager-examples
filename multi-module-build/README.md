# Multi Module Build

How to aggregate multiple projects into a single native package.

```bash
sbt debian:packageBin
```

# Project setup

We have three projects `api`, `backend` and `frontend` which will
be aggregated to a single package `de.mukis.mukis-fullstack.deb`
