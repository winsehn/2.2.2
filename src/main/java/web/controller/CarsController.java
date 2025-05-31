package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.model.Car;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
    public String cars(Model model, @RequestParam(name = "count", required = false, defaultValue = "0") int count) {
        List<Car> cars;
        if (count >= 1 && count < 5) {
            cars = carService.getCountCars(count);
            model.addAttribute("cars", cars);
        } else {
            cars = carService.getAllCars();
            model.addAttribute("cars", cars);
        }
        return "cars";
    }
}
