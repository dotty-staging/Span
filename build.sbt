name               := "Span"

version            := "1.4.0-SNAPSHOT"

organization       := "de.sciss"

scalaVersion       := "2.11.6"

crossScalaVersions := Seq("2.11.6", "2.10.5")

description        := "A simple data type for describing sample frame intervals"

homepage           := Some(url("https://github.com/Sciss/" + name.value))

licenses           := Seq("LGPL v2.1+" -> url( "http://www.gnu.org/licenses/lgpl-2.1.txt"))

initialCommands in console := """import de.sciss.span._"""

scalacOptions      := Seq("-deprecation", "-unchecked", "-feature", "-Xfuture", "-encoding", "utf8")

libraryDependencies in ThisBuild ++= Seq(
  "de.sciss"      %% "serial"    % "1.1.0-SNAPSHOT",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
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

pomExtra := { val n = name.value
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
<developers>
   <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
   </developer>
</developers>
}

// ---- ghpages ----

site.settings

ghpages.settings

git.remoteRepo := s"git@github.com:Sciss/${name.value}.git"

site.includeScaladoc()
