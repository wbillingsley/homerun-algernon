ThisBuild / scalaVersion := "3.1.0"

ThisBuild / version := "0.1-SNAPSHOT"

lazy val root = project.in(file(".")).
  aggregate(model.js, model.jvm, server).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val model = crossProject(JSPlatform, JVMPlatform).in(file("modules/model")).
  settings(
    name := "homerun-model"
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
    scalaJSUseMainModuleInitializer := false,
  )


val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.7"
val DoobieVersion = "1.0.0-RC1"

lazy val server = project.in(file("modules/server"))
  .dependsOn(model.jvm)
  .settings(
    name := "homerun-server",

    libraryDependencies ++= Seq(
      ("com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion).cross(CrossVersion.for3Use2_13),
      ("com.typesafe.akka" %% "akka-stream" % AkkaVersion).cross(CrossVersion.for3Use2_13),
      ("com.typesafe.akka" %% "akka-http" % AkkaHttpVersion).cross(CrossVersion.for3Use2_13),

      "org.tpolecat" %% "doobie-core"     % DoobieVersion,
      "org.tpolecat" %% "doobie-h2" % DoobieVersion,
    )
  )
