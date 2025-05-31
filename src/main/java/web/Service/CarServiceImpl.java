package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static CarDao carDao;


    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public List<Car> getCountCars(int count) {
        return carDao.getCountCar(count);
    }

    @Transactional
    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }
}
