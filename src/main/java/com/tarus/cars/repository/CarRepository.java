package com.tarus.cars.repository;

import com.tarus.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    public Car findByModelIgnoreCase(String model);
}
