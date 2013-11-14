package subjects

import rx.lang.scala.Subject

object PublishSubject {
  def apply[T](value: T): PublishSubject[T] = {
    new PublishSubject[T](rx.subjects.PublishSubject.create())
  }
}

class PublishSubject[T] private (val inner: rx.subjects.PublishSubject[T]) extends Subject[T,T]  {
 }
