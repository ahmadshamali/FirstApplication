package com.example.firstapplication.dataaccess;

import java.util.ArrayList;
import java.util.List;

public class CarDA {
    private List<Car> Cars = new ArrayList<Car>();


    public CarDA() {

        Cars.add(new Car(1, "Mercedes-Benz", "C-Class", 68000, 5, "Reliable family car with low fuel consumption."));
        Cars.add(new Car(2, "Mercedes-AMG", "C63", 87000, 4, "Sporty car with strong performance."));
        Cars.add(new Car(3, "Mercedes-Benz", "GLS", 89000, 7, "Large SUV suitable for families and long travel."));
        Cars.add(new Car(4, "Mercedes-AMG", "GT", 150000, 2, "Luxury sports car with premium design."));
        Cars.add(new Car(5, "Mercedes-Benz", "E-Class", 76000, 5, "Comfortable and practical car for daily use."));

    }

    public List<Car> getCars() {
        return Cars;
    }

}
