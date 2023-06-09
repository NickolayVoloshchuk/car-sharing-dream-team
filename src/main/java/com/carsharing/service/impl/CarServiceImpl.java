package com.carsharing.service.impl;

import com.carsharing.model.Car;
import com.carsharing.repository.CarRepository;
import com.carsharing.service.CarService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final TelegramNotificationService telegramNotificationService;
    private final CarRepository carRepository;

    @Override
    public Car save(Car car) {
        Car savedCar = carRepository.save(car);
        telegramNotificationService.generateMessageToAdministrators("Car was added to DB");
        return savedCar;
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find car by id: " + id));
    }

    @Override
    public Car update(Car car) {
        if (carRepository.existsById(car.getId())) {
            Car savedCar = carRepository.save(car);
            telegramNotificationService.generateMessageToAdministrators("Car: " + car
                    + " was updated in DB");
            return savedCar;
        }
        throw new RuntimeException("Can't find car by id: " + car.getId());
    }

    @Override
    public void delete(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            telegramNotificationService.generateMessageToAdministrators("Car by id:"
                    + id + " was deleted");
        } else {
            throw new RuntimeException("Can't find car by id: " + id);
        }
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
