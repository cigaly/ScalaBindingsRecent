package rx.lang.scala.subjects

import rx.lang.scala.Subject

object AsyncSubject {
  def apply[T](): AsyncSubject[T] = {
    new AsyncSubject[T](rx.subjects.AsyncSubject.create())
  }
}

class AsyncSubject[T] private[scala] (val inner: rx.subjects.AsyncSubject[T]) extends Subject[T,T]  {
}