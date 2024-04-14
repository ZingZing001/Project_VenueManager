package nz.ac.auckland.se281;

public class Venues {
  protected String venueName;
  protected String venueCode;
  protected String capacityInput;
  protected String hireFeeInput;

  public Venues(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
  }

  public Venues(String venueCode) {
    this.venueCode = venueCode;
  }

  public String getVenueName() {
    return venueName;
  }

  public String getAlias() {
    return venueCode;
  }

  public String getCapacity() {
    return capacityInput;
  }

  public String getFees() {
    return hireFeeInput;
  }
}
