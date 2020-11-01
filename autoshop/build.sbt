name := """autoshop"""
organization := "com.iachulkov"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  guice,
  evolutions,
  javaJdbc,
  javaWs,
  "com.h2database" % "h2" % "1.4.192",
  "org.mybatis" % "mybatis" % "3.4.1",
  "org.mybatis" % "mybatis-guice" % "3.6",
  "com.google.inject.extensions" % "guice-multibindings" % "4.0"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
// Dependency injecting controllers - https://www.playframework.com/documentation/2.4.x/JavaDependencyInjection
routesGenerator := InjectedRoutesGenerator


