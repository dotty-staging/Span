resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages"     % "0.6.2")   // publish API docs to GitHub pages
addSbtPlugin("com.typesafe"     % "sbt-mima-plugin" % "0.1.18")  // compatibility testing
