package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAll();

    List<Car> getCountCar(int count);

    void addCar(Car car);
}
