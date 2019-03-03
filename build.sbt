lazy val root = (project in file("."))
  .settings(
    name := "play-park",
    version := "0.1",
    scalaVersion := "2.12.7",
    libraryDependencies ++= Seq(
        "org.scalikejdbc" %% "scalikejdbc"       % "3.3.2",
        "org.skinny-framework" %% "skinny-orm" % "3.0.0",
        "com.h2database"  %  "h2"                % "1.4.197",
        "ch.qos.logback"  %  "logback-classic"   % "1.2.3",
        "org.postgresql" % "postgresql" % "42.2.5",
    )
)

lazy val jts = (project in file("jts"))
  .settings(
    name := "jts",
    version := "0.1",
    scalaVersion := "2.12.7",
    libraryDependencies ++= Seq(
        "org.locationtech.jts" % "jts-core" % "1.16.1"
    ))
  .dependsOn(root)