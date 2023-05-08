package com.shyamlearning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestContainersTest extends AbstractTestcontainers{

//    @Container
//    private static final PostgreSQLContainer<?> postgreSQLContainer =
//        new PostgreSQLContainer<>("postgres:latest")
//                .withDatabaseName("shyam-dao-unit-test")
//                .withUsername("shyam")
//                .withPassword("password");

    @Test
    void canStartpostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();
    }
}
