lazy val baseName  = "Span"
lazy val baseNameL = baseName.toLowerCase

lazy val projectVersion = "1.4.0-SNAPSHOT"
lazy val mimaVersion    = "1.4.0"

name               := baseName
version            := projectVersion
organization       := "de.sciss"
scalaVersion       := "2.12.5"
crossScalaVersions := Seq("2.12.5", "2.11.12")
description        := "A simple data type for describing sample frame intervals"
homepage           := Some(url(s"https://github.com/Sciss/${name.value}"))
licenses           := Seq("LGPL v2.1+" -> url( "http://www.gnu.org/licenses/lgpl-2.1.txt"))

mimaPreviousArtifacts := Set("de.sciss" %% baseNameL % mimaVersion)

initialCommands in console := """import de.sciss.span._"""

scalacOptions      := Seq("-deprecation", "-unchecked", "-feature", "-Xfuture", "-encoding", "utf8", "-Xlint")

libraryDependencies ++= Seq(
  "de.sciss"      %% "serial"    % "1.1.0-SNAPSHOT",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

// ---- publishing ----

publishMavenStyle := true

publishTo :=
  Some(if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

/* this seems to be generated now automatically somewhere:
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
*/

pomExtra := { val n = name.value
<developers>
   <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
   </developer>
</developers>
}

// ---- ghpages ----

enablePlugins(GhpagesPlugin, SiteScaladocPlugin)

git.remoteRepo := s"git@github.com:Sciss/${name.value}.git"