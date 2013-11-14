package rx.lang.scala

import rx.subscriptions.{BooleanSubscription, Subscriptions}
import rx.util.functions.Action0

/**
 * Contains special Observables.
 * 
 * In Scala, this package only contains [[rx.lang.scala.observables.BlockingObservable]].
 * In the corresponding Java package `rx.observables`, there is also a
 * `GroupedObservable` and a `ConnectableObservable`, but these are not needed
 * in Scala, because we use a pair `(key, observable)` instead of `GroupedObservable`
 * and a pair `(startFunction, observable)` instead of `ConnectableObservable`. 
 */
package object observables {}

