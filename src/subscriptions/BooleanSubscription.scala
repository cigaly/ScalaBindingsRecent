package rx.lang.scala.subscriptions

import rx.lang.scala._

object BooleanSubscription {

  /**
   * Creates a [[rx.lang.scala.subscriptions.BooleanSubscription]].
   */
  def apply(): BooleanSubscription =  {
    new BooleanSubscription(new rx.subscriptions.BooleanSubscription())
  }

  /**
   * Creates a [[rx.lang.scala.subscriptions.BooleanSubscription]] that invokes the specified action when unsubscribed.
   */
  def apply(unsubscribe: => Unit): BooleanSubscription = {
    new BooleanSubscription(new rx.subscriptions.BooleanSubscription{
      override def unsubscribe(): Unit = {
        unsubscribe
        super.unsubscribe()
      }
    })
  }
}

/**
 * Represents a [[rx.lang.scala.Subscription]] that can be checked for status.
 */
class BooleanSubscription private [scala] (inner: rx.subscriptions.BooleanSubscription)
  extends Subscription {

  /**
   * Checks whether the subscription has been unsubscribed.
   */
  def isUnsubscribed: Boolean = inner.isUnsubscribed()

  /**
   * Unsubscribes this subscription, setting isUnsubscribed to true.
   */
  def unsubscribe(): Unit = inner.unsubscribe()

}
