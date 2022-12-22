package com.tarus.cars.controller;

import com.tarus.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(CarController.class)
class CarControllerTest {
@Autowired
private MockMvc mockMvc;

@MockBean
private CarService carService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void saveCar() {
    }

    @Test
    void fetchCarById() {
    }
}