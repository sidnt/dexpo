package dexpo

import slinky._
import slinky.native._
import slinky.core.annotations.react
import slinky.core.FunctionalComponent
import slinky.core._
import facade.Hooks._

@react object App {

  /**
    * if we keep `App` as the top/root level component/app
    * handed off to expo machinery
    * is it possible that we are able to run a zio subsystem
    * inside this component, at its top level?
    * sure we could run arbitrary code
    * and have it manange the state related stuff?
    * .
    * App would be handed off to expo
    * it would be loaded
    * zio subsytem would be kicked off into action
    * it would manage some external effects, eg network calls.
    * (don't yet know about user interaction changing state)
    */
  var state = 0
  import zio._
  import duration._
  val perSecond = Schedule.spaced(1.second)
  val zrts = Runtime.default
  val mutator =
    for {
      _ <- UIO(state += 1).repeat(perSecond)
    } yield ()
  

  /**
    * problem here:
    * [1] on android, the timer runs so long as the app is in focus
    * navigate to other app OR turn the screen off, the Schedule suspends
    * [2] on web: the error goes :
    * `java.time.zone.ZoneRulesException: Unknown time-zone ID: Asia/Calcutta`
    */
  val run = zrts.unsafeRunAsync_(mutator)

  val component = FunctionalComponent[Unit] { _ =>
    val (count, setCount) = useState(0)
    View(style = centerStyle)(
      Text("Customary Greetings."),
      Button(
        title = "Refresh Seconds Elapsed",
        onPress = () => setCount(state)
      ),
      Text(s"seconds elapsed: $count")
    )
  }
}

object AppLoader {
  def apply(): ReactComponentClass[_] = App.component
}
