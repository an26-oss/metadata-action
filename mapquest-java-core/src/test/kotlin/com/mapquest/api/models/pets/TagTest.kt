// File generated from our OpenAPI spec by Stainless.

package com.mapquest.api.models.pets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.mapquest.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TagTest {

    @Test
    fun create() {
        val tag = Tag.builder().id(0L).name("name").build()

        assertThat(tag.id()).contains(0L)
        assertThat(tag.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tag = Tag.builder().id(0L).name("name").build()

        val roundtrippedTag =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tag), jacksonTypeRef<Tag>())

        assertThat(roundtrippedTag).isEqualTo(tag)
    }
}
