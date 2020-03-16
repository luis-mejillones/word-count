name := """words-count"""

version := "1.0-SNAPSHOT"

lazy val root = Project( id = "words-count", base = file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

/**
 * Dependencies
 */
libraryDependencies ++= Seq (
  javaWs,
  guice,
  "com.fasterxml.jackson.core" % "jackson-core" % "2.9.9",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.9",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.9",
  "org.apache.httpcomponents" % "httpclient" % "4.5.10"
).map(_.force())

mainClass in (Compile,run) := Some("main.java.Main")
mainClass in (Compile,packageBin) := Some("main.java.Main")

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
