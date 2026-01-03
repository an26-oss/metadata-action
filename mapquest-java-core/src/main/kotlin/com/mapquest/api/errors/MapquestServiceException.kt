// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.errors

import com.mapquest.api.core.JsonValue
import com.mapquest.api.core.http.Headers

abstract class MapquestServiceException
protected constructor(message: String, cause: Throwable? = null) :
    MapquestException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
