package com.namget.logintest.util

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

abstract class DefaultSubscriber<T> : Subscriber<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(s: Subscription?) {

    }

    override fun onNext(t: T) {

    }

    override fun onError(t: Throwable?) {
        //fabric onError message
    }
}