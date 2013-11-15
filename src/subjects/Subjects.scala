package rx.lang.scala

import rx.lang.scala._

package object subjects {

object Subject {
  def apply[T](asyncSubject: AsyncSubject[T]): Subject[T,T] = {
    asyncSubject.inner
  }
}

object AsyncSubject {
    def apply[T](): AsyncSubject[T] =
      new AsyncSubject[T](rx.subjects.AsyncSubject.create())
}

class AsyncSubject[T] private [scala] (val inner: rx.subjects.AsyncSubject[T])
    extends AnyVal
{}

implicit final def asObservable[T](subject: AsyncSubject[T]): rx.lang.scala.Observable[T] =
  Observable(subject.inner)

implicit final def asObserver[T](subject: AsyncSubject[T]): rx.lang.scala.Observer[T] =
  subject.inner

object BehaviorSubject {
  def apply[T](value: T): BehaviorSubject[T] = rx.subjects.BehaviorSubject.createWithDefaultValue(value)
}

object PublishSubject {
  def apply[T](value: T): PublishSubject[T] = rx.subjects.PublishSubject.create()
}

object ReplaySubject {
  def apply[T](): ReplaySubject[T] = rx.subjects.ReplaySubject.create()
}

}