/**
 * Copyright 2013 Netflix, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rx.lang.scala {

  trait Subscription {

    val asJavaSubscription: rx.Subscription

    def unsubscribe(): Unit = asJavaSubscription.unsubscribe()
    def isUnsubscribed: Boolean
  }
}

package rx.lang.scala.subscriptions {

import rx.lang.scala.Subscription
import java.util.concurrent.atomic.AtomicBoolean


object Subscription {

  /**
   * Creates an [[rx.lang.scala.Subscription]] from an[[rx.Subscription]].
   */
  def apply(subscription: rx.Subscription): Subscription = {
     subscription match {
       case x: rx.subscriptions.BooleanSubscription            => new BooleanSubscription(x)
       case x: rx.subscriptions.CompositeSubscription          => new CompositeSubscription(x)
       case x: rx.subscriptions.MultipleAssignmentSubscription => new MultipleAssignmentSubscription(x)
       case x: rx.subscriptions.SerialSubscription             => new SerialSubscription(x)
       case x: rx.Subscription                                 => Subscription { x.unsubscribe() }
     }
  }

  /**
   * Creates an [[rx.lang.scala.Subscription]] that invokes the specified action when unsubscribed.
   */
  def apply(u: => Unit): Subscription  = {
    new Subscription () {

      private val _isUnsubscribed = new AtomicBoolean(false)
      def isUnsubscribed = _isUnsubscribed.get()

      val asJavaSubscription = new rx.Subscription {
        def unsubscribe() { u; _isUnsubscribed.set(true) }
      }
    }
  }
 }
}






