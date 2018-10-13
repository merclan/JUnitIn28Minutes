package tech.merclan.mapper;

import tech.merclan.model.Car;
import tech.merclan.model.Vehicle;

public class AutoMapper {
  public Vehicle mapCarToVehicle(Car car){
    return new Vehicle().setBrand(car.getBrand()).setModel(car.getModel()).setSeries("Default");
  }

  public Car mapVehicleToCar(Vehicle vehicle){
    return new Car().setBrand(vehicle.getBrand()).setModel(vehicle.getModel()).setVin("Data not available");
  }
}
