import rx.lang.scala.subjects.{ReplaySubject, AsyncSubject}

object Main {

  def main(args: Array[String]): Unit = {

    val s = ReplaySubject[Integer]()
    s.onNext(3)
    s.onNext(42)
    s.onCompleted()
    s.subscribe(println(_))

  }
}
