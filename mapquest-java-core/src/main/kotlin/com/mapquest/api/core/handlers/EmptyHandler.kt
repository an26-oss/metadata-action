@file:JvmName("EmptyHandler")

package com.mapquest.api.core.handlers

import com.mapquest.api.core.http.HttpResponse
import com.mapquest.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
