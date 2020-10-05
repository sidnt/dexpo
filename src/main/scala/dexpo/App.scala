package dexpo

import slinky._
import slinky.native._
import slinky.core.annotations.react
import slinky.core.FunctionalComponent
import slinky.core._

@react object App {
  val component = FunctionalComponent[Unit] { _ =>
    View(style = centerStyle)(Text("ℍ\uD835\uDD56\uD835\uDD5D\uD835\uDD5D\uD835\uDD60. \uD835\uDD3D\uD835\uDD63\uD835\uDD60\uD835\uDD5E \uD835\uDD52 \uD835\uDD3D\uD835\uDD66\uD835\uDD5F\uD835\uDD54\uD835\uDD65\uD835\uDD5A\uD835\uDD60\uD835\uDD5F\uD835\uDD52\uD835\uDD5D ℂ\uD835\uDD60\uD835\uDD5E\uD835\uDD61\uD835\uDD60\uD835\uDD5F\uD835\uDD56\uD835\uDD5F\uD835\uDD65."))
  }
}

object AppLoader {
  def apply(): ReactComponentClass[_] = App.component
}
