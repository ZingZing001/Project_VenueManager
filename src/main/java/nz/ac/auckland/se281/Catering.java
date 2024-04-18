package nz.ac.auckland.se281;

public class Catering extends Services {
  private String CateringType;

  public Catering(String referenceNumber, String CateringType) {
    super(referenceNumber);
    this.CateringType = CateringType;
  }
}
