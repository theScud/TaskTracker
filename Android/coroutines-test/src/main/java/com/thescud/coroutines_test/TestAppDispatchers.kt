@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package com.thescud.coroutines_test

import com.thescud.coroutines.AppDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlin.coroutines.CoroutineContext

fun AppDispatchers.Default.setDefault(dispatchers: AppDispatchers) {
    override = dispatchers
}

fun AppDispatchers.Default.resetDefault() {
    override = null
}

fun testAppDispatchers(
    main: CoroutineDispatcher = StandardTestDispatcher(),
    computation: CoroutineDispatcher = main,
    io: CoroutineDispatcher = main
): AppDispatchers = object : AppDispatchers {
    override val main = (main as? MainCoroutineDispatcher) ?: MainCoroutineDispatcherWrapper(main)
    override val computation = computation
    override val io = io
}

private class MainCoroutineDispatcherWrapper(
    private val delegate: CoroutineDispatcher
) : MainCoroutineDispatcher() {

    override val immediate: MainCoroutineDispatcher
        get() = (delegate as? MainCoroutineDispatcher)?.immediate ?: this

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        delegate.dispatch(context, block)
    }

    override fun isDispatchNeeded(context: CoroutineContext): Boolean {
        return delegate.isDispatchNeeded(context)
    }
}
