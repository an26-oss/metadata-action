// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.client

import com.mapquest.api.core.ClientOptions
import com.mapquest.api.core.getPackageVersion
import com.mapquest.api.services.async.PetServiceAsync
import com.mapquest.api.services.async.PetServiceAsyncImpl
import com.mapquest.api.services.async.StoreServiceAsync
import com.mapquest.api.services.async.StoreServiceAsyncImpl
import com.mapquest.api.services.async.UserServiceAsync
import com.mapquest.api.services.async.UserServiceAsyncImpl
import java.util.function.Consumer

class MapquestClientAsyncImpl(private val clientOptions: ClientOptions) : MapquestClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: MapquestClient by lazy { MapquestClientImpl(clientOptions) }

    private val withRawResponse: MapquestClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val store: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): MapquestClient = sync

    override fun withRawResponse(): MapquestClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MapquestClientAsync =
        MapquestClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pets(): PetServiceAsync = pets

    override fun store(): StoreServiceAsync = store

    override fun users(): UserServiceAsync = users

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MapquestClientAsync.WithRawResponse {

        private val pets: PetServiceAsync.WithRawResponse by lazy {
            PetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreServiceAsync.WithRawResponse by lazy {
            StoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MapquestClientAsync.WithRawResponse =
            MapquestClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetServiceAsync.WithRawResponse = pets

        override fun store(): StoreServiceAsync.WithRawResponse = store

        override fun users(): UserServiceAsync.WithRawResponse = users
    }
}
