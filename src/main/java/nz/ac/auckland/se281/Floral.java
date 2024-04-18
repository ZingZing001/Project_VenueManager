package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Services {
  private String serviceType;

  public Floral(String referenceNumber, FloralType FloralType) {
    super(referenceNumber);
    this.serviceType = "Floral";
  }

  @Override
  public String getItemType() {
    // Add implementation here
    return this.serviceType;
  }
}
