// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.mapquest.api.core.ClientOptions
import com.mapquest.api.core.RequestOptions
import com.mapquest.api.core.http.HttpResponse
import com.mapquest.api.core.http.HttpResponseFor
import com.mapquest.api.models.pets.Pet
import com.mapquest.api.models.pets.PetCreateParams
import com.mapquest.api.models.pets.PetDeleteParams
import com.mapquest.api.models.pets.PetFindByStatusParams
import com.mapquest.api.models.pets.PetFindByTagsParams
import com.mapquest.api.models.pets.PetRetrieveParams
import com.mapquest.api.models.pets.PetUpdateByIdParams
import com.mapquest.api.models.pets.PetUpdateParams
import com.mapquest.api.models.pets.PetUploadImageParams
import com.mapquest.api.models.pets.PetUploadImageResponse
import java.util.function.Consumer

interface PetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PetService

    /** Add a new pet to the store */
    fun create(params: PetCreateParams): Pet = create(params, RequestOptions.none())

    /** @see create */
    fun create(params: PetCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Pet

    /** @see create */
    fun create(pet: Pet, requestOptions: RequestOptions = RequestOptions.none()): Pet =
        create(PetCreateParams.builder().pet(pet).build(), requestOptions)

    /** @see create */
    fun create(pet: Pet): Pet = create(pet, RequestOptions.none())

    /** Returns a single pet */
    fun retrieve(petId: Long): Pet = retrieve(petId, PetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        petId: Long,
        params: PetRetrieveParams = PetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Pet = retrieve(params.toBuilder().petId(petId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(petId: Long, params: PetRetrieveParams = PetRetrieveParams.none()): Pet =
        retrieve(petId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: PetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Pet

    /** @see retrieve */
    fun retrieve(params: PetRetrieveParams): Pet = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(petId: Long, requestOptions: RequestOptions): Pet =
        retrieve(petId, PetRetrieveParams.none(), requestOptions)

    /** Update an existing pet by Id */
    fun update(params: PetUpdateParams): Pet = update(params, RequestOptions.none())

    /** @see update */
    fun update(params: PetUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Pet

    /** @see update */
    fun update(pet: Pet, requestOptions: RequestOptions = RequestOptions.none()): Pet =
        update(PetUpdateParams.builder().pet(pet).build(), requestOptions)

    /** @see update */
    fun update(pet: Pet): Pet = update(pet, RequestOptions.none())

    /** delete a pet */
    fun delete(petId: Long) = delete(petId, PetDeleteParams.none())

    /** @see delete */
    fun delete(
        petId: Long,
        params: PetDeleteParams = PetDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().petId(petId).build(), requestOptions)

    /** @see delete */
    fun delete(petId: Long, params: PetDeleteParams = PetDeleteParams.none()) =
        delete(petId, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: PetDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: PetDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(petId: Long, requestOptions: RequestOptions) =
        delete(petId, PetDeleteParams.none(), requestOptions)

    /** Multiple status values can be provided with comma separated strings */
    fun findByStatus(): List<Pet> = findByStatus(PetFindByStatusParams.none())

    /** @see findByStatus */
    fun findByStatus(
        params: PetFindByStatusParams = PetFindByStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Pet>

    /** @see findByStatus */
    fun findByStatus(params: PetFindByStatusParams = PetFindByStatusParams.none()): List<Pet> =
        findByStatus(params, RequestOptions.none())

    /** @see findByStatus */
    fun findByStatus(requestOptions: RequestOptions): List<Pet> =
        findByStatus(PetFindByStatusParams.none(), requestOptions)

    /**
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     */
    fun findByTags(): List<Pet> = findByTags(PetFindByTagsParams.none())

    /** @see findByTags */
    fun findByTags(
        params: PetFindByTagsParams = PetFindByTagsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Pet>

    /** @see findByTags */
    fun findByTags(params: PetFindByTagsParams = PetFindByTagsParams.none()): List<Pet> =
        findByTags(params, RequestOptions.none())

    /** @see findByTags */
    fun findByTags(requestOptions: RequestOptions): List<Pet> =
        findByTags(PetFindByTagsParams.none(), requestOptions)

    /** Updates a pet in the store with form data */
    fun updateById(petId: Long) = updateById(petId, PetUpdateByIdParams.none())

    /** @see updateById */
    fun updateById(
        petId: Long,
        params: PetUpdateByIdParams = PetUpdateByIdParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = updateById(params.toBuilder().petId(petId).build(), requestOptions)

    /** @see updateById */
    fun updateById(petId: Long, params: PetUpdateByIdParams = PetUpdateByIdParams.none()) =
        updateById(petId, params, RequestOptions.none())

    /** @see updateById */
    fun updateById(
        params: PetUpdateByIdParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see updateById */
    fun updateById(params: PetUpdateByIdParams) = updateById(params, RequestOptions.none())

    /** @see updateById */
    fun updateById(petId: Long, requestOptions: RequestOptions) =
        updateById(petId, PetUpdateByIdParams.none(), requestOptions)

    /** uploads an image */
    fun uploadImage(petId: Long, image: String): PetUploadImageResponse =
        uploadImage(petId, image, PetUploadImageParams.none())

    /** @see uploadImage */
    fun uploadImage(
        petId: Long,
        image: String,
        params: PetUploadImageParams = PetUploadImageParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PetUploadImageResponse =
        uploadImage(params.toBuilder().petId(petId).image(image).build(), requestOptions)

    /** @see uploadImage */
    fun uploadImage(
        petId: Long,
        image: String,
        params: PetUploadImageParams = PetUploadImageParams.none(),
    ): PetUploadImageResponse = uploadImage(petId, image, params, RequestOptions.none())

    /** @see uploadImage */
    fun uploadImage(
        params: PetUploadImageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PetUploadImageResponse

    /** @see uploadImage */
    fun uploadImage(params: PetUploadImageParams): PetUploadImageResponse =
        uploadImage(params, RequestOptions.none())

    /** @see uploadImage */
    fun uploadImage(
        petId: Long,
        image: String,
        requestOptions: RequestOptions,
    ): PetUploadImageResponse =
        uploadImage(petId, image, PetUploadImageParams.none(), requestOptions)

    /** A view of [PetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): PetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /pet`, but is otherwise the same as
         * [PetService.create].
         */
        @MustBeClosed
        fun create(params: PetCreateParams): HttpResponseFor<Pet> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: PetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet>

        /** @see create */
        @MustBeClosed
        fun create(
            pet: Pet,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet> = create(PetCreateParams.builder().pet(pet).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(pet: Pet): HttpResponseFor<Pet> = create(pet, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /pet/{petId}`, but is otherwise the same as
         * [PetService.retrieve].
         */
        @MustBeClosed
        fun retrieve(petId: Long): HttpResponseFor<Pet> = retrieve(petId, PetRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            petId: Long,
            params: PetRetrieveParams = PetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet> = retrieve(params.toBuilder().petId(petId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            petId: Long,
            params: PetRetrieveParams = PetRetrieveParams.none(),
        ): HttpResponseFor<Pet> = retrieve(petId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: PetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: PetRetrieveParams): HttpResponseFor<Pet> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(petId: Long, requestOptions: RequestOptions): HttpResponseFor<Pet> =
            retrieve(petId, PetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /pet`, but is otherwise the same as
         * [PetService.update].
         */
        @MustBeClosed
        fun update(params: PetUpdateParams): HttpResponseFor<Pet> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: PetUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet>

        /** @see update */
        @MustBeClosed
        fun update(
            pet: Pet,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet> = update(PetUpdateParams.builder().pet(pet).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(pet: Pet): HttpResponseFor<Pet> = update(pet, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `delete /pet/{petId}`, but is otherwise the same as
         * [PetService.delete].
         */
        @MustBeClosed fun delete(petId: Long): HttpResponse = delete(petId, PetDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            petId: Long,
            params: PetDeleteParams = PetDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().petId(petId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(petId: Long, params: PetDeleteParams = PetDeleteParams.none()): HttpResponse =
            delete(petId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: PetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: PetDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(petId: Long, requestOptions: RequestOptions): HttpResponse =
            delete(petId, PetDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /pet/findByStatus`, but is otherwise the same as
         * [PetService.findByStatus].
         */
        @MustBeClosed
        fun findByStatus(): HttpResponseFor<List<Pet>> = findByStatus(PetFindByStatusParams.none())

        /** @see findByStatus */
        @MustBeClosed
        fun findByStatus(
            params: PetFindByStatusParams = PetFindByStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Pet>>

        /** @see findByStatus */
        @MustBeClosed
        fun findByStatus(
            params: PetFindByStatusParams = PetFindByStatusParams.none()
        ): HttpResponseFor<List<Pet>> = findByStatus(params, RequestOptions.none())

        /** @see findByStatus */
        @MustBeClosed
        fun findByStatus(requestOptions: RequestOptions): HttpResponseFor<List<Pet>> =
            findByStatus(PetFindByStatusParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /pet/findByTags`, but is otherwise the same as
         * [PetService.findByTags].
         */
        @MustBeClosed
        fun findByTags(): HttpResponseFor<List<Pet>> = findByTags(PetFindByTagsParams.none())

        /** @see findByTags */
        @MustBeClosed
        fun findByTags(
            params: PetFindByTagsParams = PetFindByTagsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Pet>>

        /** @see findByTags */
        @MustBeClosed
        fun findByTags(
            params: PetFindByTagsParams = PetFindByTagsParams.none()
        ): HttpResponseFor<List<Pet>> = findByTags(params, RequestOptions.none())

        /** @see findByTags */
        @MustBeClosed
        fun findByTags(requestOptions: RequestOptions): HttpResponseFor<List<Pet>> =
            findByTags(PetFindByTagsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /pet/{petId}`, but is otherwise the same as
         * [PetService.updateById].
         */
        @MustBeClosed
        fun updateById(petId: Long): HttpResponse = updateById(petId, PetUpdateByIdParams.none())

        /** @see updateById */
        @MustBeClosed
        fun updateById(
            petId: Long,
            params: PetUpdateByIdParams = PetUpdateByIdParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = updateById(params.toBuilder().petId(petId).build(), requestOptions)

        /** @see updateById */
        @MustBeClosed
        fun updateById(
            petId: Long,
            params: PetUpdateByIdParams = PetUpdateByIdParams.none(),
        ): HttpResponse = updateById(petId, params, RequestOptions.none())

        /** @see updateById */
        @MustBeClosed
        fun updateById(
            params: PetUpdateByIdParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see updateById */
        @MustBeClosed
        fun updateById(params: PetUpdateByIdParams): HttpResponse =
            updateById(params, RequestOptions.none())

        /** @see updateById */
        @MustBeClosed
        fun updateById(petId: Long, requestOptions: RequestOptions): HttpResponse =
            updateById(petId, PetUpdateByIdParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /pet/{petId}/uploadImage`, but is otherwise the
         * same as [PetService.uploadImage].
         */
        @MustBeClosed
        fun uploadImage(petId: Long, image: String): HttpResponseFor<PetUploadImageResponse> =
            uploadImage(petId, image, PetUploadImageParams.none())

        /** @see uploadImage */
        @MustBeClosed
        fun uploadImage(
            petId: Long,
            image: String,
            params: PetUploadImageParams = PetUploadImageParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PetUploadImageResponse> =
            uploadImage(params.toBuilder().petId(petId).image(image).build(), requestOptions)

        /** @see uploadImage */
        @MustBeClosed
        fun uploadImage(
            petId: Long,
            image: String,
            params: PetUploadImageParams = PetUploadImageParams.none(),
        ): HttpResponseFor<PetUploadImageResponse> =
            uploadImage(petId, image, params, RequestOptions.none())

        /** @see uploadImage */
        @MustBeClosed
        fun uploadImage(
            params: PetUploadImageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PetUploadImageResponse>

        /** @see uploadImage */
        @MustBeClosed
        fun uploadImage(params: PetUploadImageParams): HttpResponseFor<PetUploadImageResponse> =
            uploadImage(params, RequestOptions.none())

        /** @see uploadImage */
        @MustBeClosed
        fun uploadImage(
            petId: Long,
            image: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PetUploadImageResponse> =
            uploadImage(petId, image, PetUploadImageParams.none(), requestOptions)
    }
}
