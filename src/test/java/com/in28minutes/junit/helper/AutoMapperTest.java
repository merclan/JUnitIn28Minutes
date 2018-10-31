package com.in28minutes.junit.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import tech.merclan.mapper.AutoMapper;
import tech.merclan.model.Car;
import tech.merclan.model.Vehicle;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class AutoMapperTest {
  private Car expectedCar;
  private Vehicle actualVehicle;

  public AutoMapperTest(Vehicle actualVehicle, Car expectedCar) {
    this.expectedCar = expectedCar;
    this.actualVehicle = actualVehicle;
  }

  @Test
  public void mapVehicleToCarTest() {
    assertEquals(expectedCar, new AutoMapper().mapVehicleToCar(actualVehicle));
  }

  @Parameters
  public static Collection<Object[]> createVehicle() {
    Car expectedCar = new Car().setBrand("honda")
                               .setModel(2016)
                               .setVin("123456464878");
    Car expectedCar2 = new Car().setBrand("toyota")
                                .setModel(2016)
                                .setVin("123456464878");
    Vehicle actualVehicle = new Vehicle().setBrand("honda")
                                         .setModel(2016)
                                         .setSeries("LX");
    Vehicle actualVehicle2 = new Vehicle().setBrand("toyota")
                                          .setModel(2016)
                                          .setSeries("Civic");
    return Arrays.asList(new Object[][]{{actualVehicle, expectedCar}, {actualVehicle2, expectedCar2}});
  }
}
