package ru.igor.metroproject.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.igor.metroproject.exception.NotFoundEntity;
import ru.igor.metroproject.model.Rout;
import ru.igor.metroproject.util.RoutTestData;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application-test.properties")
//@Sql(scripts = "classpath:db/populate.sql", config = @SqlConfig(encoding = "UTF-8"))
class RoutServiceTest {

    @Autowired
    RoutService routService;

    @BeforeEach
    void setUp() {
        RoutTestData.getRouts().forEach(rout -> routService.save(rout));
    }

    @AfterEach
    void tearDown() {
        routService.clean();
    }

    @Test
    void getAll() {
        assertThat(routService.getAll().size()).isEqualTo(5);
    }

    @Test
    void get() {
        Integer id = routService.getAll().get(0).getId();
        assertThat(routService.get(id).getCode()).isEqualTo(123);
    }

    @Test
    void getException() {
        org.junit.jupiter.api.Assertions.assertThrows(NotFoundEntity.class,
                () -> routService.get(10000));
    }

    @Test
    void save() {
        routService.save(new Rout(777, "H-T"));
        assertThat(routService.getAll().size()).isEqualTo(6);
    }


    @Test
    void delete() {
        routService.delete(5);
        assertThat(routService.getAll().size()).isEqualTo(4);
    }
}