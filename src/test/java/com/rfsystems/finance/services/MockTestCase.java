package com.rfsystems.finance.services;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.enterprise.context.ApplicationScoped;

@QuarkusTest
public class MockTestCase {

    @InjectMock
    MockableBean1 mockableBean1;

    @InjectMock
    MockableBean2 mockableBean2;

    @BeforeEach
    public void setup() {
        Mockito.when(mockableBean1.greet("Stuart")).thenReturn("A mock for Stuart");
    }

    @Test
    public void firstTest() {
        Assertions.assertEquals("A mock for Stuart", mockableBean1.greet("Stuart"));
        Assertions.assertEquals(null, mockableBean2.greet("Stuart"));
    }

    @Test
    public void secondTest() {
        Mockito.when(mockableBean2.greet("Stuart")).thenReturn("Bonjour Stuart");
        Assertions.assertEquals("A mock for Stuart", mockableBean1.greet("Stuart"));
        Assertions.assertEquals("Bonjour Stuart", mockableBean2.greet("Stuart"));
    }

    @ApplicationScoped
    public static class MockableBean1 {

        public String greet(String name) {
            return "Hello " + name;
        }
    }

    @ApplicationScoped
    public static class MockableBean2 {

        public String greet(String name) {
            return "Hello " + name;
        }
    }
}