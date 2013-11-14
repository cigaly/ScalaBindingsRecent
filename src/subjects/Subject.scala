package rx.lang.scala

/**
* A Subject is an Observable and an Observer at the same time.
*/
trait Subject[-T, +R] extends Observable[R] with Observer[T] {
  val inner: rx.subjects.Subject[_ >: T, _<: R]
  def asJava: rx.Observable[_ <: R] = inner
  def asJavaObserver: rx.Observer[_ >: T] = inner
}

