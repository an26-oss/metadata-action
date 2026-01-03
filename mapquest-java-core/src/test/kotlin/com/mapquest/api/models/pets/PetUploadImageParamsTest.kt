// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.models.pets

import com.mapquest.api.core.http.QueryParams
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PetUploadImageParamsTest {

    @Test
    fun create() {
        PetUploadImageParams.builder()
            .petId(0L)
            .additionalMetadata("additionalMetadata")
            .image("some content")
            .build()
    }

    @Test
    fun pathParams() {
        val params = PetUploadImageParams.builder().petId(0L).image("some content").build()

        assertThat(params._pathParam(0)).isEqualTo("0")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            PetUploadImageParams.builder()
                .petId(0L)
                .additionalMetadata("additionalMetadata")
                .image("some content")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("additionalMetadata", "additionalMetadata").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = PetUploadImageParams.builder().petId(0L).image("some content").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            PetUploadImageParams.builder()
                .petId(0L)
                .additionalMetadata("additionalMetadata")
                .image("some content")
                .build()

        val body = params._body().getOrNull()

        assertThat(body).isEqualTo("some content")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = PetUploadImageParams.builder().petId(0L).image("some content").build()

        val body = params._body().getOrNull()

        assertThat(body).isEqualTo("some content")
    }
}
