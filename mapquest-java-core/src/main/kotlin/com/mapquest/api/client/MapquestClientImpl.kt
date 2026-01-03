// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.client

import com.mapquest.api.core.ClientOptions
import com.mapquest.api.core.getPackageVersion
import com.mapquest.api.services.blocking.PetService
import com.mapquest.api.services.blocking.PetServiceImpl
import com.mapquest.api.services.blocking.StoreService
import com.mapquest.api.services.blocking.StoreServiceImpl
import com.mapquest.api.services.blocking.UserService
import com.mapquest.api.services.blocking.UserServiceImpl
import java.util.function.Consumer

class MapquestClientImpl(private val clientOptions: ClientOptions) : MapquestClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: MapquestClientAsync by lazy { MapquestClientAsyncImpl(clientOptions) }

    private val withRawResponse: MapquestClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetService by lazy { PetServiceImpl(clientOptionsWithUserAgent) }

    private val store: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): MapquestClientAsync = async

    override fun withRawResponse(): MapquestClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MapquestClient =
        MapquestClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pets(): PetService = pets

    override fun store(): StoreService = store

    override fun users(): UserService = users

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MapquestClient.WithRawResponse {

        private val pets: PetService.WithRawResponse by lazy {
            PetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreService.WithRawResponse by lazy {
            StoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MapquestClient.WithRawResponse =
            MapquestClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetService.WithRawResponse = pets

        override fun store(): StoreService.WithRawResponse = store

        override fun users(): UserService.WithRawResponse = users
    }
}
