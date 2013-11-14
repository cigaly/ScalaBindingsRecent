package rx.lang.scala.subscriptions

import rx.lang.scala._

object MultiAssignmentSubscription {

  /**
   * Creates a [[rx.lang.scala.subscriptions.MultiAssignmentSubscription]] that invokes the specified action when unsubscribed.
   */
  def apply(subscription: => Unit): MultiAssignmentSubscription = {
    val m = MultiAssignmentSubscription()
    m.subscription = Subscription{ subscription }
    m
  }

  /**
   * Creates a [[rx.lang.scala.subscriptions.MultiAssignmentSubscription]].
   */
  def apply(): MultiAssignmentSubscription = {
    new MultiAssignmentSubscription(new rx.subscriptions.MultipleAssignmentSubscription())
  }
}



/**
 * Represents a [[rx.lang.scala.subscriptions.Subscription]] whose underlying subscription can be swapped for another subscription.
 */
class MultiAssignmentSubscription private [scala] (inner: rx.subscriptions.MultipleAssignmentSubscription)
  extends Subscription {

  /**
   * Gets the underlying subscription
   * @return the [[MultiAssignmentSubscription]] itself.
   */
  def subscription: Subscription = inner.getSubscription()

  /**
   * Gets the underlying subscription
   * @param that the new subscription
   * @return the [[MultiAssignmentSubscription]] itself.
   */
  def subscription_=(that: Subscription): this.type = {
    inner.setSubscription(that)
    this
  }

  /**
   * Checks whether the subscription has been unsubscribed.
   */
  def isUnsubscribed: Boolean = inner.isUnsubscribed()

  /**
   * Unsubscribes this subscription, setting isUnsubscribed to true.
   */
  def unsubscribe(): Unit = inner.unsubscribe()
}


