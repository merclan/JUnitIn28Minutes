package tech.merclan.model;

import java.util.Objects;

public class Car {
  private String vin;
  private Integer model;
  private String brand;

  public String getVin() {
    return vin;
  }

  public Car setVin(String vin) {
    this.vin = vin;
    return this;
  }

  public Integer getModel() {
    return model;
  }

  public Car setModel(Integer model) {
    this.model = model;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public Car setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == this) return true;
    if (!(obj instanceof Car)) {
      return false;
    }
    Car car = (Car) obj;
    return model == car.getModel() &&
        Objects.equals(brand, car.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(vin, model, brand);
  }

  @Override
  public String toString() {
    return model + " " + brand;
  }
}
