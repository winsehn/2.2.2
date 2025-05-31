package web.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.Service.CarService;
import web.model.Car;

import java.util.List;
import java.util.Random;


@Component
public class BdInit implements InitializingBean {
    private List<String> modelCars = List.of(
            "Toyota Supra",
            "BMW M3",
            "Ford Mustang GT",
            "Tesla Model S",
            "Honda Civic Type R",
            "Chevrolet Camaro SS",
            "Nissan GT-R",
            "Porsche 911 Carrera",
            "Audi RS5",
            "Mercedes-AMG C63"
    );
    private List<String> colorCars = List.of(
            "Red",
            "Yellow",
            "Black",
            "Gray",
            "Blue",
            "Pink",
            "White"
    );
    private List<Integer> yearsCars = List.of(2015, 2014, 2016, 2017, 2018, 2019, 2020);

    @Autowired
    CarService carService;

    private Random random = new Random();


    @Override
    @Transactional
    public void afterPropertiesSet() {
        for (int i = 0; i < 5; i++) {
            carService.addCar(getRandomCar());
        }
    }

    private Car getRandomCar() {
        Car car = new Car(modelCars.get(random.nextInt(modelCars.size())),
                colorCars.get(random.nextInt(colorCars.size())),
                yearsCars.get(random.nextInt(yearsCars.size()))
        );
        return car;
    }
}
