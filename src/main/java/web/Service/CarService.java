package web.Service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCountCars(int x);

    List<Car> getAllCars();

    void addCar(Car car);
}
