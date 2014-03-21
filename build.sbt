name         := "Span"

version      := "1.2.1-SNAPSHOT"

organization := "de.sciss"

scalaVersion := "2.11.0-RC3"

crossScalaVersions := Seq("2.11.0-RC3", "2.10.3")

description  := "A simple data type for describing sample frame intervals"

homepage     := Some(url("https://github.com/Sciss/" + name.value))

licenses     := Seq("LGPL v2.1+" -> url( "http://www.gnu.org/licenses/lgpl-2.1.txt"))

initialCommands in console := """import de.sciss.span._"""

libraryDependencies in ThisBuild ++= Seq(
  "de.sciss"      %% "serial"    % "1.0.2+",
  "org.scalatest" %% "scalatest" % "2.1.2" % "test"
)

// retrieveManaged := true

// ---- publishing ----

publishMavenStyle := true

publishTo :=
  Some(if (version.value endsWith "-SNAPSHOT")
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

git.remoteRepo := "git@github.com:Sciss/" + name.value + ".git"

site.includeScaladoc()
