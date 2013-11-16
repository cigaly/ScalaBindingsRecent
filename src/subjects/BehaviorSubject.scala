package subjects

import rx.lang.scala.Subject

object BehaviorSubject {
  def apply[T](value: T): BehaviorSubject[T] = {
    new BehaviorSubject[T](rx.subjects.BehaviorSubject.createWithDefaultValue(value))
  }
}

class BehaviorSubject[T] private (val asJavaSubject: rx.subjects.BehaviorSubject[T]) extends Subject[T,T]  {
}




