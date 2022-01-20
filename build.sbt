ThisBuild / scalaVersion := "3.1.0"

lazy val root = project.in(file(".")).
  aggregate(model.js, model.jvm).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val model = crossProject(JSPlatform, JVMPlatform).in(file("modules/model")).
  settings(
    name := "model",
    version := "0.1-SNAPSHOT",
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
    scalaJSUseMainModuleInitializer := false,
  )