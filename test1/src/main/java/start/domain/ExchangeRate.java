package start.domain;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRate {
  private String country;
  private Double value;

  List<ExchangeRate> rateList = new ArrayList<>();

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
