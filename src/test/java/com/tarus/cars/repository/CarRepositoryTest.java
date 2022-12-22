package com.tarus.cars.repository;

import com.tarus.cars.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Car car =
                Car.builder()
                        .make("Toyota")
                        .model("yaris")
                        .build();

        entityManager.persist(car);
    }
    @Test
public void whenFindById_thenReturnCar(){
        Car car = carRepository.findById(1L).get();

        assertEquals(car.getModel(),"yaris");
}
}