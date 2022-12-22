package com.tarus.cars.service;

import com.tarus.cars.entity.Car;
import com.tarus.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;
    @MockBean
    private CarRepository carRepository;
    @BeforeEach
    void setUp() {
Car  car =
        Car.builder()
                .make("Toyota")
                .model("auris")
                .carId(1L)
                .build();

        Mockito.when(carRepository.findByModelIgnoreCase("auris"))
                .thenReturn(car);
    }
    @Test
    @DisplayName("Get Data based on valid car model")
    public void whenValidCarModel_thenCarShouldFound(){
        String model = "auris";
        Car found =
                carService.findCarByModel(model);

        assertEquals(model,found.getModel());
    }


}