package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
//@EnableAutoConfiguration
class ProyectoRepositoryDataTest {

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

    @Test
    void whenFindAll_thenReturnListaProyectos() throws ProyectoNotfoundException {
        //given
        Proyecto proyecto = new Proyecto(null, "Nombre Proyecto", LocalDate.now(), null);

        em.persist(proyecto);

        //when
        List<Proyecto> listaProyectos = proyectoRepo.findAll();
        System.out.println("listaProyectos" + listaProyectos);

        //then
        assertNotNull(listaProyectos);

    }

    @Test
    void whenSave_thenInsertaProyecto() throws ProyectoNotfoundException {
        //given
        Proyecto proyecto = new Proyecto(null, "Nombre Proyecto", LocalDate.now(), null);

//        em.persist(proyecto);
        proyectoRepo.save(proyecto);
        //when
        List<Proyecto> listaProyectos = proyectoRepo.findAll();
        System.out.println("Lista de proyectos" + listaProyectos);
        //then
        assertNotNull(listaProyectos);

    }

    @Test
    void whenUpdate_thenActualizaProyecto() throws ProyectoNotfoundException {
        //given
        Proyecto proyecto = new Proyecto(null, "Nombre Proyecto", LocalDate.now(), null);
        proyectoRepo.save(proyecto);
        System.out.println("proyecto" + proyectoRepo.findById(1L));

        //when
        proyecto.setNombre("Nuevo nombre");
        proyectoRepo.flush();

        List<Proyecto> listaProyectos = proyectoRepo.findAll();
        System.out.println("Lista de proyectos" + listaProyectos);
        System.out.println("proyecto" + proyectoRepo.findById(1L));
        //then
        assertNotNull(listaProyectos);

    }
}