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

package rx.lang.scala.subscriptions

import rx.lang.scala.{Observable, Scheduler}
import rx.subscriptions.Subscriptions
import rx.util.functions.Action0
import rx.lang.scala.{Observable, Scheduler, Subscription}

object Subscription {

    /**
     * Creates an [[rx.lang.scala.Subscription]] that invokes the specified action when unsubscribed.
     */
    def apply(unsubscribe: => Unit) : Subscription = {
      Subscriptions.create(new Action0(){ def call() { unsubscribe } })
    }

 }






