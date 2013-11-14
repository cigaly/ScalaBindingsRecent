//import java.lang.String
//import scala.Predef.String
//
///**
// * Created with IntelliJ IDEA.
// * User: netflix
// * Date: 11/10/13
// * Time: 3:46 PM
// * To change this template use File | Settings | File Templates.
// */
//private[scala] class UnitTestSuite extends org.scalatest.junit.JUnitSuite {
//  import scala.concurrent.duration._
//
//  // Tests which needn't be run:
//
//  @Ignore def testCovariance = {
//    println("hey, you shouldn't run this test")
//
//    val o1: Observable[Nothing] = Observable()
//    val o2: Observable[Int] = o1
//    val o3: Observable[App] = o1
//    val o4: Observable[Any] = o2
//    val o5: Observable[Any] = o3
//  }
//
//  // Tests which have to be run:
//
//  @Test def testDematerialize() {
//    val o = Observable(1, 2, 3)
//    val mat = o.materialize
//    val demat = mat.dematerialize
//
//    // correctly rejected:
//    // val wrongDemat = Observable("hello").dematerialize
//
//    assertEquals(demat.toBlockingObservable.toIterable.toList, List(1, 2, 3))
//  }
//
//  // Test that Java's firstOrDefault propagates errors.
//  // If this changes (i.e. it suppresses errors and returns default) then Scala's firstOrElse
//  // should be changed accordingly.
//  @Test def testJavaFirstOrDefault() {
//    assertEquals(1, rx.Observable.from(1, 2).firstOrDefault(10).toBlockingObservable().single)
//    assertEquals(10, rx.Observable.empty().firstOrDefault(10).toBlockingObservable().single)
//    val msg = "msg6251"
//    var receivedMsg = "none"
//    try {
//      rx.Observable.error(new Exception(msg)).firstOrDefault(10).toBlockingObservable().single
//    } catch {
//      case e: Exception => receivedMsg = e.getCause().getMessage()
//    }
//    assertEquals(receivedMsg, msg)
//  }
//
//  @Test def testFirstOrElse() {
//    def mustNotBeCalled: String = sys.error("this method should not be called")
//    def mustBeCalled: String = "this is the default value"
//    assertEquals("hello", Observable("hello").firstOrElse(mustNotBeCalled).toBlockingObservable.single)
//    assertEquals("this is the default value", Observable().firstOrElse(mustBeCalled).toBlockingObservable.single)
//  }
//
//  @Test def testFirstOrElseWithError() {
//    val msg = "msg6251"
//    var receivedMsg = "none"
//    try {
//      Observable[Int](new Exception(msg)).firstOrElse(10).toBlockingObservable.single
//    } catch {
//      case e: Exception => receivedMsg = e.getCause().getMessage()
//    }
//    assertEquals(receivedMsg, msg)
//  }
//
//  /*
//  @Test def testHead() {
//    val observer = mock(classOf[Observer[Int]])
//    val o = Observable().head
//    val sub = o.subscribe(observer)
//
//    verify(observer, never).onNext(any(classOf[Int]))
//    verify(observer, never).onCompleted()
//    verify(observer, times(1)).onError(any(classOf[NoSuchElementException]))
//  }
//  */
//
//  @Test def testTest() = {
//    val a: Observable[Int] = Observable()
//    assertEquals(4, Observable(1, 2, 3, 4).toBlockingObservable.toIterable.last)
//    println("This UnitTestSuite.testTest() for rx.lang.scala.Observable")
//  }
//
//}
