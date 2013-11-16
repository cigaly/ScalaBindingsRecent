import java.io.IOException
import rx.lang.scala.Notification.{OnError, OnCompleted, OnNext}
import rx.lang.scala.{Notification, Observable}
import rx.lang.scala.subjects.{ReplaySubject, AsyncSubject}

object Main {

  def main(args: Array[String]): Unit = {
    def printObservable[T](o: Observable[T]): Unit = {
      import Notification._
      o.materialize.subscribe(n => n match {
        case OnNext(v) => println("Got value " + v)
        case OnCompleted() => println("Completed")
        case OnError(err) => println("Error: " + err.getMessage)
      }, error => println("Wooow"+error.getMessage), ()=> println("done"))
    }

    val o2 = Observable(new IOException("Oops"))
    printObservable(o2)
    println(o2.toBlockingObservable.toList)

  }
}
