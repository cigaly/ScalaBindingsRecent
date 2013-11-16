import java.io.IOException
import rx.lang.scala.Notification.{OnError, OnCompleted, OnNext}
import rx.lang.scala.{Notification, Observable}
import rx.lang.scala.subjects.{ReplaySubject, AsyncSubject}

object Main {

  def main(args: Array[String]): Unit = {
    println("hello")
    val movies = Observable(new rx.lang.scala.examples.Movie(3000),
                            new rx.lang.scala.examples.Movie(1000),
                            new rx.lang.scala.examples.Movie(2000))
    val lib = new rx.lang.scala.examples.MovieLib(movies)

  }
}
