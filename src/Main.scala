import rx.lang.scala.subjects._
import rx.lang.scala.subscriptions._

object Main {
  def main(args: Array[String]): Unit = {

    val s = AsyncSubject[Integer]()

    s.subscribe(println(_))
    s.onNext(3)
    s.onNext(41)
    s.onCompleted()

    val b = new rx.subscriptions.BooleanSubscription()
    println(b.isUnsubscribed)

    val c = Subscription()
    c.unsubscribe()

    var u0 = false
    val s0 = BooleanSubscription{ u0 = true }

    var u1 = false
    val s1 = Subscription{ u1 = true }

    val composite = CompositeSubscription()

    ///Assert.assertFalse(composite.isUnsubscribed)

    composite.add(s1)
    composite += s0

    composite.unsubscribe()

    //Assert.assertTrue(composite.isUnsubscribed)
    //Assert.assertTrue(s0.isUnsubscribed)
    //Assert.assertTrue(u0)
    //Assert.assertTrue(u1)

    //val s2 = BooleanSubscription()
    //Assert.assertFalse(s2.isUnsubscribed)
    //composite += s2
    //Assert.assertTrue(s2.isUnsubscribed)
  }
}




