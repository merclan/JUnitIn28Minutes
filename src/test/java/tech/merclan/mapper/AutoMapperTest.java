package tech.merclan.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tech.merclan.model.Car;
import tech.merclan.model.Vehicle;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoMapperTest {
  Car expectedCar;
  Vehicle actualVehicle;

  @BeforeEach
  void setup() {
    expectedCar = new Car().setBrand("honda")
                           .setModel(2016)
                           .setVin("123456464878");
    actualVehicle = new Vehicle().setBrand("honda")
                                 .setModel(2016)
                                 .setSeries("LX");
  }

  @Test
  void mapVehicleToCarTest() {
    assertEquals(expectedCar, new AutoMapper().mapVehicleToCar(actualVehicle));
  }

  @ParameterizedTest(name = "{index} => actual={0}, expected={1}")
  @MethodSource("createVehicle")
  void mapVehicleToCarParamTest(Vehicle vehicle, Car car) {
    assertEquals(car, new AutoMapper().mapVehicleToCar(vehicle));
  }

  private static Stream<Arguments> createVehicle() {
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
    return Stream.of(Arguments.of(actualVehicle, expectedCar), Arguments.of(actualVehicle2, expectedCar2));
  }
}
