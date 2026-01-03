@file:JvmName("JsonHandler")

package com.mapquest.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.mapquest.api.core.http.HttpResponse
import com.mapquest.api.core.http.HttpResponse.Handler
import com.mapquest.api.errors.MapquestInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw MapquestInvalidDataException("Error reading response", e)
            }
    }
