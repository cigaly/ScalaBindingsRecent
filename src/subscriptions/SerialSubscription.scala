package rx.lang.scala.subscriptions

import rx.lang.scala._

object SerialSubscription {

  /**
   * Creates a [[rx.lang.scala.subscriptions.SerialSubscription]].
   */
  def apply(): SerialSubscription =  {
    new SerialSubscription(new rx.subscriptions.SerialSubscription())
  }

  /**
   * Creates a [[rx.lang.scala.subscriptions.SerialSubscription]] that invokes the specified action when unsubscribed.
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
class SerialSubscription private [scala] (inner: rx.subscriptions.SerialSubscription)
  extends Subscription {

  /**
   * Checks whether the subscription has been unsubscribed.
   */
  def isUnsubscribed: Boolean = ??? //inner.isUnsubscribed()

  /**
   * Unsubscribes this subscription, setting isUnsubscribed to true.
   */
  def unsubscribe(): Unit = inner.unsubscribe()

  def subscription_=(value: Subscription): Unit = inner.setSubscription(value)
  def subscription: Subscription = Subscription(inner.getSubscription())

}

