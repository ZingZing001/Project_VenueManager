package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

class Floral extends Services {
  private FloralType floralType;

  public Floral(String bookingReference, FloralType floralType) {
    super(bookingReference, floralType.getCost());
    this.floralType = floralType;
  }

  public FloralType getFloralType() {
    return floralType;
  }

  public String getItemType() {
    return "Floral";
  }
}
