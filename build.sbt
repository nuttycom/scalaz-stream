organization := "org.scalaz.stream"

name := "scalaz-stream"

version := "0.4-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions ++= Seq(
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-Xfatal-warnings",
  "-Yno-adapted-args"
)

resolvers ++= Seq(Resolver.sonatypeRepo("releases"), Resolver.sonatypeRepo("snapshots"))

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.1.0-M6",
  "org.scalaz" %% "scalaz-concurrent" % "7.1.0-M6",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.1.0-M6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.3" % "test"
)

seq(bintraySettings:_*)

publishMavenStyle := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

bintray.Keys.packageLabels in bintray.Keys.bintray :=
  Seq("stream processing", "functional I/O", "iteratees", "functional programming", "scala")

osgiSettings

OsgiKeys.bundleSymbolicName := "org.scalaz.stream"

OsgiKeys.exportPackage := Seq("scalaz.stream.*")

OsgiKeys.importPackage := Seq(
  """scala.*;version="$<range;[===,=+);$<@>>"""",
  """scalaz.*;version="$<range;[===,=+);$<@>>"""",
  "*"
)

ScctPlugin.instrumentSettings
