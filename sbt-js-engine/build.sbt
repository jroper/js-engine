sbtPlugin := true

organization := "com.typesafe.sbt"

name := "sbt-js-engine"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
)

libraryDependencies ++= Seq(
  "com.typesafe" %% "jse" % "1.0.0-SNAPSHOT",
  "org.specs2" %% "specs2" % "2.2.2" % "test",
  "junit" % "junit" % "4.11" % "test"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.0.0-SNAPSHOT")

publishMavenStyle := false

publishTo := {
  val isSnapshot = version.value.contains("-SNAPSHOT")
  val scalasbt = "http://repo.scala-sbt.org/scalasbt/"
  val (name, url) = if (isSnapshot)
    ("sbt-plugin-snapshots", scalasbt + "sbt-plugin-snapshots")
  else
    ("sbt-plugin-releases", scalasbt + "sbt-plugin-releases")
  Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
}