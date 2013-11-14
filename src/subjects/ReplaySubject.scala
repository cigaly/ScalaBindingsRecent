package rx.lang.scala.subjects

import rx.lang.scala.Subject

object ReplaySubject {
  def apply[T](): ReplaySubject[T] = {
    new ReplaySubject[T](rx.subjects.ReplaySubject.create())
  }
}

class ReplaySubject[T] private (val inner: rx.subjects.ReplaySubject[T]) extends Subject[T,T]  {
}



