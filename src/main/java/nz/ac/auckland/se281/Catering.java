package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Services {
  private CateringType inputCatering;
  private String serviceType;

  public Catering(String referenceNumber, CateringType inputCatering) {
    super(referenceNumber);
    this.inputCatering = inputCatering;
    this.serviceType = "Catering";
  }

  @Override
  public String getItemType() {
    return this.serviceType;
  }
}
