name := "iterators-benchmark"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalanlp" %% "breeze" % "0.12",
  "org.scalanlp" %% "breeze-natives" % "0.12"
)

enablePlugins(JmhPlugin)
