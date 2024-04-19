package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Services {
  private CateringType cateringType;

  public Catering(String bookingReference, CateringType cateringType) {
    super(bookingReference, cateringType.getCostPerPerson());
    this.cateringType = cateringType;
  }

  public CateringType getCateringType() {
    return cateringType;
  }

  public String getItemType() {
    return "Catering";
  }
}
