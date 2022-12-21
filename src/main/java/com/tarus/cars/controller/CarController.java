package com.tarus.cars.controller;

import com.tarus.cars.entity.Car;
import com.tarus.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public Car saveCar(@RequestBody  Car car){
        return carService.saveCar(car);
    }

    @GetMapping("/cars")
    public List<Car> fetchCarList(){
        return carService.fetchCarList();
    }

    @GetMapping("/cars/{id}")
    public Car fetchCarById(@PathVariable("id") Long carId){
        return carService.fetchCarById(carId);
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCarById(@PathVariable("id") Long carId){
        carService.deleteCarById(carId);
        return  "Car has been deleted successfully";
    }

    @PutMapping("/cars/{id}")
    public Car updateCarById(@PathVariable("id") Long carId, @RequestBody Car car){
        return  carService.updateCarById(carId,car);
    }

    @GetMapping("/cars/model/{model}")
    public Car findCarByModel(@PathVariable("model") String model){
        return  carService.findCarByModel(model);
    }
}
