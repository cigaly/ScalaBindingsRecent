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
class MultiAssignmentSubscription private [scala] (val asJavaSubscription: rx.subscriptions.MultipleAssignmentSubscription)
  extends Subscription {

  /**
   * Gets the underlying subscription.
   */
  def subscription: Subscription = Subscription(asJavaSubscription.getSubscription())

  /**
   * Gets the underlying subscription
   * @param that the new subscription
   * @return the [[rx.lang.scala.subscriptions.MultiAssignmentSubscription]] itself.
   */
  def subscription_=(that: Subscription): this.type = {
    asJavaSubscription.setSubscription(that.asJavaSubscription)
    this
  }

  /**
   * Checks whether the subscription has been unsubscribed.
   */
  def isUnsubscribed: Boolean = asJavaSubscription.isUnsubscribed()

}


