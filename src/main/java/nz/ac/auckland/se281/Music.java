package nz.ac.auckland.se281;

public class Music extends Services {
  private String serviceType;

  public Music(String referenceNumber) {
    super(referenceNumber);
    this.serviceType = "Music";
  }

  @Override
  public String getItemType() {
    return this.serviceType;
  }
}
