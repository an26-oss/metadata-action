// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.models.pets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.mapquest.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PetTest {

    @Test
    fun create() {
        val pet =
            Pet.builder()
                .name("doggie")
                .addPhotoUrl("string")
                .id(10L)
                .category(Category.builder().id(1L).name("Dogs").build())
                .status(Pet.Status.AVAILABLE)
                .addTag(Pet.Tag.builder().id(0L).name("name").build())
                .build()

        assertThat(pet.name()).isEqualTo("doggie")
        assertThat(pet.photoUrls()).containsExactly("string")
        assertThat(pet.id()).contains(10L)
        assertThat(pet.category()).contains(Category.builder().id(1L).name("Dogs").build())
        assertThat(pet.status()).contains(Pet.Status.AVAILABLE)
        assertThat(pet.tags().getOrNull())
            .containsExactly(Pet.Tag.builder().id(0L).name("name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pet =
            Pet.builder()
                .name("doggie")
                .addPhotoUrl("string")
                .id(10L)
                .category(Category.builder().id(1L).name("Dogs").build())
                .status(Pet.Status.AVAILABLE)
                .addTag(Pet.Tag.builder().id(0L).name("name").build())
                .build()

        val roundtrippedPet =
            jsonMapper.readValue(jsonMapper.writeValueAsString(pet), jacksonTypeRef<Pet>())

        assertThat(roundtrippedPet).isEqualTo(pet)
    }
}
