package com.in28minutes.junit.helper;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;
import tech.merclan.mapper.AutoMapper;
import tech.merclan.model.Car;
import tech.merclan.model.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AutoMapperJUnitParametersTest {

  @Test
  @Parameters(source = TestDataProvider.class, method = "provideBasicData")
  @TestCaseName("Verify that vehicle {1} can turn into car {0}")
  public void mapVehicleToCarTest(Vehicle actualVehicle, Car expectedCar) {
    assertEquals(expectedCar, new AutoMapper().mapVehicleToCar(actualVehicle));
  }

  public static class TestDataProvider {

    public static Object[] provideBasicData() {
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
      return new Object[][]{{actualVehicle, expectedCar}, {actualVehicle2, expectedCar2}};
    }

    public static Object[] provideEdgeCaseData() {
      Car expectedCar = new Car().setBrand("honda")
                                 .setModel(2016);
      Vehicle actualVehicle = new Vehicle().setBrand("honda")
                                           .setModel(2016);
      return new Object[][]{{actualVehicle, expectedCar}};
    }
  }
}
