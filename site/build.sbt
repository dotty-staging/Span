lazy val baseName  = "Span"
lazy val baseNameL = baseName.toLowerCase

lazy val projectVersion = "1.4.1"

val lSpan = RootProject(uri(s"https://github.com/Sciss/Span.git#v${projectVersion}"))

lazy val root = project.in(file("."))
  .enablePlugins(GhpagesPlugin, SiteScaladocPlugin)
  .settings(
    name               := baseName,
    version            := projectVersion,
    organization       := "de.sciss",
    scalaVersion       := "2.12.6",
    git.remoteRepo     := s"git@github.com:Sciss/${name.value}.git",
    scalacOptions in (Compile, doc) ++= Seq(
      "-doc-title", s"${baseName} $projectVersion API"
    )
  )
  .aggregate(
    lSpan
  )
  
