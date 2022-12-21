package com.tarus.cars.service;

import com.tarus.cars.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
   public Car saveCar(Car car);

  public List<Car> fetchCarList();

  public Car fetchCarById(Long carId);

   public void deleteCarById(Long carId);

    public Car updateCarById(Long carId, Car car);

   public Car findCarByModel(String model);
}
