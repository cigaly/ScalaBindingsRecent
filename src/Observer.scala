package rx.lang.scala

trait Observer[-T] {

  def asJavaObserver: rx.Observer[_ >: T]

  def onNext(value: T): Unit = asJavaObserver.onNext(value)
  def onError(error: Throwable): Unit = asJavaObserver.onError(error)
  def onCompleted(): Unit = asJavaObserver.onCompleted()

}

object Observer {
  def apply[T](observer: rx.Observer[T]) : Observer[T] = {
    new Observer[T]() {
      def asJavaObserver: rx.Observer[_ >: T] = observer
    }
  }
}


