package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Services {
  private CateringType CateringType;
  private String serviceType;

  public Catering(String referenceNumber, CateringType CateringType) {
    super(referenceNumber);
    this.CateringType = CateringType;
    this.serviceType = "Catering";
  }

  @Override
  public String getItemType() {
    return this.serviceType;
  }
}
