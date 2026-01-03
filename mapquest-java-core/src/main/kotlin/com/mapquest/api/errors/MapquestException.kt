package com.mapquest.api.errors

open class MapquestException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
