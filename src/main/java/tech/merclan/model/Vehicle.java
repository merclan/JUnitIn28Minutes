package tech.merclan.model;

public class Vehicle {
  String brand;
  String series;
  Integer model;

  public String getBrand() {
    return brand;
  }

  public Vehicle setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public String getSeries() {
    return series;
  }

  public Vehicle setSeries(String series) {
    this.series = series;
    return this;
  }

  public Integer getModel() {
    return model;
  }

  public Vehicle setModel(Integer model) {
    this.model = model;
    return this;
  }

  @Override
  public String toString() {
    return model + " " + brand;
  }
}
