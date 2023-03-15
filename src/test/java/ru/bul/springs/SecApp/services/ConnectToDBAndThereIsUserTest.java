package ru.bul.springs.SecApp.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ConnectToDBAndThereIsUserTest {

    @Autowired
    private PersonService personService;

    @Autowired
    DataSource dataSource;



    @BeforeAll
    public static void show(){
        System.out.println("Показываю работу данного метода");
    }

    @AfterAll
    public static void showTwo(){
        System.out.println("Показываю работу данного метода");
    }


    @Test
    void findByName() {
        boolean ex = personService.isTherePerson("admin");
        assertTrue(ex);

    }

    @Test
    void findByNameTwo() {
        boolean ex = personService.isTherePerson("prosto");
        assertTrue(ex);


    }

    @Test
    public void testConnect() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection.getCatalog());
            assertEquals("projectest",connection.getCatalog());
        }


    }
}