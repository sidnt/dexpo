lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "lsjs",
    scalaVersion := "2.13.3",
    version := "0.0.0",
    libraryDependencies ++= Seq(
      "dev.zio" %%% "zio" % "1.0.1",
      "me.shadaj" %%% "slinky-native" % "0.6.6"
    ),
    scalacOptions += "-Ymacro-annotations",
    scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule))
  )
