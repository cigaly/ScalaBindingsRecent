import org.junit.{Assert, Test}
import org.scalatest.junit.JUnitSuite
import rx.lang.scala.subscriptions.Subscription

class SubscriptionTests extends JUnitSuite {
  @Test
  def anonymousSubscriptionCreate() {
    val subscription = Subscription{}
    Assert.assertNotNull(subscription)
  }

  @Test
  def anonymousSubscriptionDispose() {
    var unsubscribed = false
    val subscription = Subscription{ unsubscribed = true }
    Assert.assertFalse(unsubscribed)
    subscription.unsubscribe()
    Assert.assertTrue(unsubscribed)
  }
}
