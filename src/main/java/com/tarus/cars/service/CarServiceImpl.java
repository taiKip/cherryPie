package com.tarus.cars.service;

import com.tarus.cars.entity.Car;
import com.tarus.cars.error.CarNotFoundException;
import com.tarus.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> fetchCarList() {
        return carRepository.findAll();
    }

    @Override
    public Car fetchCarById(Long carId) throws CarNotFoundException {
        Optional<Car> carDB = carRepository.findById(carId);
        if(carDB.isEmpty()){
            throw new CarNotFoundException("Car Not Available");

        }
        return carDB.get();
    }

    @Override
    public void deleteCarById(Long carId) {
         carRepository.deleteById(carId);
    }

    @Override
    public Car updateCarById(Long carId, Car car) {
        Car carDB = carRepository.findById(carId).get();
        if(Objects.nonNull(car.getMake()) &&!"".equalsIgnoreCase(car.getMake())){
            carDB.setMake(car.getMake());
        }
        if(Objects.nonNull(car.getModel()) &&!"".equalsIgnoreCase(car.getModel())){
            carDB.setModel(car.getModel());
        }
        return carRepository.save(carDB);
    }

    @Override
    public Car findCarByModel(String model) {
        return carRepository.findByModelIgnoreCase(model);
    }


}
