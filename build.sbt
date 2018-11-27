lazy val root = (project in file(".")).settings(
  name := "play-park",
  version := "0.1",
  scalaVersion := "2.12.7",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.18"
  )
)