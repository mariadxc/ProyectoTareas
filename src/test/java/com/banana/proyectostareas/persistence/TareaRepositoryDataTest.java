package com.banana.proyectostareas.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
//@EnableAutoConfiguration
class TareaRepositoryDataTest {

    @Autowired
    private ProyectoRepositoryData proyectoRepo;

    @Autowired
    private TareaRepositoryData tareaRepo;

    @Autowired
    private TestEntityManager em;

    @Test
    void testBeans() {
        assertThat(proyectoRepo, notNullValue());
    }


}