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
  "org.scalatest" %%% "scalatest" % "3.0.0" % "test"
)

enablePlugins(ScalaJSPlugin)

// This is an application with a main method
// scalaJSUseMainModuleInitializer := true


// Stuff for cpFastJS and cpFullJS below

def cpReplaceFile(pathToSrc: String, destDir: String="docs/assets/js") {
  val srcFileName = file(pathToSrc).getName

  java.nio.file.Files.copy(
    file(s"${pathToSrc}").toPath,
    file(s"${destDir}/${srcFileName}").toPath,
    StandardCopyOption.REPLACE_EXISTING
  )
}

lazy val cpFastJS = taskKey[Unit]("Copies compiled js file (from fastOptJS) to /doc/")
cpFastJS := {
  val pathToFastOptJS = (Compile / fastOptJS).value.data.toString
  println("cpFastJS: Copying compiled js file (from fastOptJS) to /doc/ ...")
  cpReplaceFile(pathToFastOptJS)
}
