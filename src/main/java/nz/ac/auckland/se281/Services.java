package nz.ac.auckland.se281;

public abstract class Services {
  protected String referenceNumber;
  protected double cost;

  public Services(String referenceNumber, double cost) {
    this.referenceNumber = referenceNumber;
    this.cost = cost;
  }

  protected abstract String getItemType();

  public String getBookingReference() {
    return referenceNumber;
  }

  public double getCost() {
    return cost;
  }
}
