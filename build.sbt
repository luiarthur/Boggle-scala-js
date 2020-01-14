/* sbt uses java.io.File to represent a file and defines the type alias File
 * for java.io.File so that an extra import is not necessary. The file method
 * is an alias for the single-argument File constructor to simplify
 * constructing a new file from a String:
 *
 * val source: File = file("/home/user/code/A.scala")
 *
 * See: https://www.scala-sbt.org/1.x/docs/Paths.html
 */

import java.nio.file.StandardCopyOption

name := "BoggleScalaJS"

version := "0.1.0"

scalaVersion := "2.12.8" // or any other Scala version >= 2.10.2

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.7",
  "org.querki" %%% "jquery-facade" % "1.2",
  "org.scalatest" %%% "scalatest" % "3.0.0" % "test"
)

enablePlugins(ScalaJSPlugin)

// This is an application with a main method.
// Boggle.Main.main() is automatically run at the end of the fastopt.js script.
scalaJSUseMainModuleInitializer := true

// Include js dependencies.
// Dependencies (here jQuery) will be bundled into one file.
skip in packageJSDependencies := false
jsDependencies ++= Seq(
  "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
)

// Stuff for cpFastJS and cpFullJS below

def cpReplaceFile(pathToSrc: String, destDir: String="docs/assets/js") {
  val srcFileName = file(pathToSrc).getName

  java.nio.file.Files.copy(
    file(s"${pathToSrc}").toPath,
    file(s"${destDir}/${srcFileName}").toPath,
    StandardCopyOption.REPLACE_EXISTING
  )
}

lazy val cpFastJS = taskKey[Unit]("Copies compiled js files (from fastOptJS) to /doc/")
cpFastJS := {
  val pathToFastOptJS = (Compile / fastOptJS).value.data.toString
  val pathToJSDeps = pathToFastOptJS.replace("-fastopt.", "-jsdeps.")
  println("cpFastJS: Copying compiled js files (from fastOptJS) to /doc/ ...")
  cpReplaceFile(pathToFastOptJS)
  cpReplaceFile(pathToJSDeps)
}

lazy val cpOptJS = taskKey[Unit]("Copies compiled js files (from fullOptJS) to /doc/")
cpOptJS := {
  val pathToOptJS = (Compile / fullOptJS).value.data.toString
  val pathToMinJSDeps = pathToOptJS.replace("-opt.js", "-jsdeps.min.js")
  println("cpFastJS: Copying compiled js files (from fastOptJS) to /doc/ ...")
  cpReplaceFile(pathToOptJS)
  cpReplaceFile(pathToMinJSDeps)
}
