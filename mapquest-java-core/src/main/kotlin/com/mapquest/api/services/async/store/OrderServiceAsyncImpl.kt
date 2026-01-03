// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.services.async.store

import com.mapquest.api.core.ClientOptions
import com.mapquest.api.core.RequestOptions
import com.mapquest.api.core.checkRequired
import com.mapquest.api.core.handlers.emptyHandler
import com.mapquest.api.core.handlers.errorBodyHandler
import com.mapquest.api.core.handlers.errorHandler
import com.mapquest.api.core.handlers.jsonHandler
import com.mapquest.api.core.http.HttpMethod
import com.mapquest.api.core.http.HttpRequest
import com.mapquest.api.core.http.HttpResponse
import com.mapquest.api.core.http.HttpResponse.Handler
import com.mapquest.api.core.http.HttpResponseFor
import com.mapquest.api.core.http.json
import com.mapquest.api.core.http.parseable
import com.mapquest.api.core.prepareAsync
import com.mapquest.api.models.Order
import com.mapquest.api.models.store.orders.OrderCreateParams
import com.mapquest.api.models.store.orders.OrderDeleteParams
import com.mapquest.api.models.store.orders.OrderRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrderServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderServiceAsync {

    private val withRawResponse: OrderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderServiceAsync =
        OrderServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: OrderCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Order> =
        // post /store/order
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: OrderRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Order> =
        // get /store/order/{orderId}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: OrderDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /store/order/{orderId}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderServiceAsync.WithRawResponse =
            OrderServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Order> = jsonHandler<Order>(clientOptions.jsonMapper)

        override fun create(
            params: OrderCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Order>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "order")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<Order> = jsonHandler<Order>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Order>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "order", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: OrderDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "order", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }
    }
}
