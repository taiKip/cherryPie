package com.tarus.cars.controller;

import com.tarus.cars.entity.Car;
import com.tarus.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
class CarControllerTest {
@Autowired
private MockMvc mockMvc;

private Car car;
@MockBean
private CarService carService;
    @BeforeEach
    void setUp() {
        car = Car.builder()
                .make("Toyota")
                .model("yaris")
                .carId(1L)
                .build();
    }

    @Test
    void saveCar() throws Exception {
        Car inputCar = Car.builder()
                .make("Toyota")
                .model("yaris")
                .build();

        Mockito.when(carService.saveCar(inputCar))
                .thenReturn(car);
        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"make\":\"Renault\",\n" +
                        "\t\"model\":\"clio\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchCarById() throws Exception {
        Mockito.when(carService.fetchCarById(1L))
                .thenReturn(car);

        mockMvc.perform(get("/cars/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.make").value(car.getMake()));

    }
}