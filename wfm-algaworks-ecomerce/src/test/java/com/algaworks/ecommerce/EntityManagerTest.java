package com.algaworks.ecommerce;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    @BeforeAll
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    @BeforeEach
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        entityManager.close();
    }

}
