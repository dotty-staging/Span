lazy val baseName  = "Span"
lazy val baseNameL = baseName.toLowerCase

lazy val projectVersion = "2.0.0"
lazy val mimaVersion    = "2.0.0"

lazy val deps = new {
  val main = new {
    val serial    = "2.0.0"
  }
  val test = new {
    val scalaTest = "3.2.2"
  }
}

lazy val commonJvmSettings = Seq(
  crossScalaVersions := Seq("0.27.0-RC1", "2.13.3", "2.12.12"),
)

lazy val root = crossProject(JSPlatform, JVMPlatform).in(file("."))
  .settings(
    name               := baseName,
    version            := projectVersion,
    organization       := "de.sciss",
    scalaVersion       := "2.13.3",
    description        := "A simple data type for describing sample frame intervals",
    homepage           := Some(url(s"https://git.iem.at/sciss/${name.value}")),
    licenses           := Seq("LGPL v2.1+" -> url( "http://www.gnu.org/licenses/lgpl-2.1.txt")),
    mimaPreviousArtifacts := Set("de.sciss" %% baseNameL % mimaVersion),
    initialCommands in console := """import de.sciss.span._""",
    scalacOptions      := Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8", "-Xlint", "-Xsource:2.13"),
    libraryDependencies ++= Seq(
      "de.sciss"      %%% "serial"     % deps.main.serial,
      "org.scalatest" %%% "scalatest"  % deps.test.scalaTest % Test,
    )
  )
  .jvmSettings(commonJvmSettings)
  .settings(publishSettings)

// ---- publishing ----
lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    Some(if (isSnapshot.value)
      "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    else
      "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
    )
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := { val n = name.value
<scm>
  <url>git@git.iem.at:sciss/{n}.git</url>
  <connection>scm:git:git@git.iem.at:sciss/{n}.git</connection>
</scm>
<developers>
   <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
   </developer>
</developers>
  }
)

