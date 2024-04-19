package nz.ac.auckland.se281;

public class Music extends Services {
  private String serviceType;

  public Music(String referenceNumber,double cost) {
    super(referenceNumber,cost);
    this.serviceType = "Music";
  }

  @Override
  public String getItemType() {
    return this.serviceType;
  }
}
