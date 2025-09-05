package com.mercadolibre.api_meli.acceptancetest;

import com.intuit.karate.junit5.Karate;

class KarateAcceptanceTest {

    @Karate.Test
    Karate testAll() {
        // Busca todos los features bajo resources/features
        return Karate.run("classpath:features");
    }

    @Karate.Test
    Karate testProducts() {
        // Corre un feature específico
        return Karate.run("classpath:features/product/products.feature");
    }
}
