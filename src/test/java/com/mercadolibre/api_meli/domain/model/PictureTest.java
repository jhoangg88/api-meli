package com.mercadolibre.api_meli.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PictureTest {

    @Test
    void testNoArgsConstructorAndSetter() {
        Picture picture = new Picture();
        picture.setUrl("https://example.com/image.png");

        assertThat(picture.getUrl()).isEqualTo("https://example.com/image.png");
    }

    @Test
    void testAllArgsConstructor() {
        Picture picture = new Picture("https://cdn.meli.com/img.png");

        assertThat(picture.getUrl()).isEqualTo("https://cdn.meli.com/img.png");
    }

    @Test
    void testEqualsAndHashCode() {
        Picture p1 = new Picture("https://example.com/1.png");
        Picture p2 = new Picture("https://example.com/1.png");
        Picture p3 = new Picture("https://example.com/2.png");

        assertThat(p1).isEqualTo(p2);
        assertThat(p1).hasSameHashCodeAs(p2);

        assertThat(p1).isNotEqualTo(p3);
        assertThat(p1.hashCode()).isNotEqualTo(p3.hashCode());
    }

    @Test
    void testToString() {
        Picture picture = new Picture("https://test.com/img.jpg");

        String toString = picture.toString();

        assertThat(toString).contains("https://test.com/img.jpg");
    }
}
