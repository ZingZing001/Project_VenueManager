package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Services {
  private String FloralType;

  public Floral(String referenceNumber, String FloralType) {
    super(referenceNumber);
    this.FloralType = FloralType;
  }

  @Override
  public String getItemType() {
    // Add implementation here
    return null;
  }
}
