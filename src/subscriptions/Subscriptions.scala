package rx.lang.scala

import rx.subscriptions.Subscriptions
import rx.util.functions.Action0

package object subscriptions {

  object Subscription {

    /**
     * Creates an [[rx.lang.scala.Subscription]] that invokes the specified action when unsubscribed.
     */
    def apply(unsubscribe: => Unit) : Subscription = {
      Subscriptions.create(new Action0(){ def call() { unsubscribe } })
    }

    def apply(): Subscription =  Subscription{}

  }

  /**
   * Represents a group of [[rx.lang.scala.Subscription]] that are disposed together.
   */
  object CompositeSubscription {

    /**
     * Creates a [[rx.lang.scala.CompositeSubscription]] from a group of [[rx.lang.scala.Subscription]].
     */
    def apply(subscriptions: Subscription*): CompositeSubscription = {
      new rx.subscriptions.CompositeSubscription(subscriptions.toArray : _*)
    }

    /**
     * Creates a [[rx.lang.scala.CompositeSubscription]].
     */
    def apply(): CompositeSubscription = {
      new rx.subscriptions.CompositeSubscription()
    }
  }

  implicit class CompositeSubscriptionExtensions (val inner: rx.subscriptions.CompositeSubscription)
    extends AnyVal
  {
    /**
     * Adds a subscription to the group,
     * or unsubscribes immediately is the [[rx.subscriptions.CompositeSubscription]] is unsubscribed.
     * @param subscription the subscription to be added.
     * @return the [[rx.subscriptions.CompositeSubscription]] itself.
     */
    def +=(subscription: Subscription): CompositeSubscription = {
      inner.add(subscription)
      inner
    }

    /**
     * Removes and unsubscribes a subscription to the group,
     * @param subscription the subscription be removed.
     * @return the [[rx.subscriptions.CompositeSubscription]] itself.
     */
    def -=(subscription: Subscription): CompositeSubscription = {
      inner.remove(subscription)
      inner
    }

  }

  object BooleanSubscription {

  /**
   * Creates a [[rx.lang.scala.subscriptions.BooleanSubscription]].
   */
  def apply(): BooleanSubscription =  {
    new rx.subscriptions.BooleanSubscription()
  }

  /**
   * Creates a [[rx.lang.scala.subscriptions.BooleanSubscription]] that invokes the specified action when unsubscribed.
   */
  def apply(u: => Unit): BooleanSubscription = {
    new rx.subscriptions.BooleanSubscription{
      override def unsubscribe(): Unit = {
        u
        super.unsubscribe()
      }
    }
  }
}

  /**
   * Represents a [[rx.lang.scala.subscriptions.Subscription]] whose underlying subscription can be swapped for another subscription.
   */
  object MultiAssignmentSubscription {

    /**
     * Creates a [[rx.lang.scala.subscriptions.MultiAssignmentSubscription]] that invokes the specified action when unsubscribed.
     */
    def apply(subscription: => Unit): MultipleAssignmentSubscription = {
      val m = MultiAssignmentSubscription()
      m.subscription = Subscription{ subscription }
      m
    }

    /**
     * Creates a [[rx.lang.scala.subscriptions.MultiAssignmentSubscription]].
     */
    def apply(): MultipleAssignmentSubscription = {
      new rx.subscriptions.MultipleAssignmentSubscription()
    }
  }

  implicit class MultiAssignmentSubscriptionExtensions (val inner: rx.subscriptions.MultipleAssignmentSubscription)
    extends AnyVal {

    /**
     * Gets the underlying subscription
     * @return the [[rx.lang.scala.Subscription]] itself.
     */
    def subscription: Subscription = inner.getSubscription()

    /**
     * Gets the underlying subscription
     * @param that the new subscription
     * @return the [[rx.lang.scala.MultipleAssignmentSubscription]] itself.
     */
    def subscription_=(that: Subscription): rx.lang.scala.MultipleAssignmentSubscription = {
      inner.setSubscription(that)
      inner
    }

  }

  /**
   * Represents a [[rx.lang.scala.Subscription]] that can be checked for status.
   */
  object SerialSubscription {

    /**
     * Creates a [[rx.lang.scala.subscriptions.SerialSubscription]].
     */
    def apply(): SerialSubscription =  {
      new rx.subscriptions.SerialSubscription()
    }

    /**
     * Creates a [[rx.lang.scala.subscriptions.SerialSubscription]] that invokes the specified action when unsubscribed.
     */
    def apply(u: => Unit): SerialSubscription = {
      new rx.subscriptions.SerialSubscription{
        override def unsubscribe(): Unit = {
          u
          super.unsubscribe()
        }
      }
    }
  }

  implicit class SerialSubscriptionExtensions (val inner: rx.subscriptions.SerialSubscription)
    extends AnyVal {

    def subscription_=(value: Subscription): Unit = inner.setSubscription(value)
    def subscription: Subscription = inner.getSubscription()

  }

}
