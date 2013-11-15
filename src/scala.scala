package rx.lang

import rx.lang.scala.{Observable, Scheduler}

package object scala {

  type Observer[-T] = rx.Observer[_ >: T]

  type Subscription = rx.Subscription
  type BooleanSubscription = rx.subscriptions.BooleanSubscription
  type CompositeSubscription = rx.subscriptions.CompositeSubscription
  type MultipleAssignmentSubscription = rx.subscriptions.MultipleAssignmentSubscription
  type SerialSubscription = rx.subscriptions.SerialSubscription

  /**
   * A Subject is an Observable and an Observer at the same time.
   *
   * The Java Subject looks like this:
   * {{{
   * public abstract class Subject<T,R> extends Observable<R> implements Observer<T>
   * }}}
   */
  type Subject[-T, +R] = rx.subjects.Subject[_ >: T, _ <: R]
  //type AsyncSubject[T] = rx.subjects.AsyncSubject[T]
  type BehaviorSubject[T] = rx.subjects.BehaviorSubject[T]
  type PublishSubject[T] = rx.subjects.PublishSubject[T]
  type ReplaySubject[T] = rx.subjects.ReplaySubject[T]

  /**
   * Allows to construct observables in a similar way as futures.
   *
   * Example:
   *
   * {{{
   * implicit val scheduler = Schedulers.threadPoolForIO
   * val o: Observable[List[Friend]] = observable {
   *    session.getFriends
   * }
   * o.subscribe(
   *   friendList => println(friendList),
   *   err => println(err.getMessage)
   * )
   * }}}
   */
  def observable[T](body: => T)(implicit scheduler: Scheduler): Observable[T] = {
    Observable(1).observeOn(scheduler).map(_ => body)
  }
}
