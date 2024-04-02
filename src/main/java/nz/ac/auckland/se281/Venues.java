package nz.ac.auckland.se281;

public class Venues {
  private String fullName;
  private String alias;
  private String maxAmmount;
  private String hiringFee;

  public Venues(String fullName, String alias, String maxAmmount, String hiringFee) {
    this.fullName = fullName;
    this.alias = alias;
    this.maxAmmount = maxAmmount;
    this.hiringFee = hiringFee;
  }

  public String getVenueName() {
    return fullName;
  }

  public String getAlias() {
    return alias;
  }

  public String getCapacity() {
    return maxAmmount;
  }

  public String getFees() {
    return hiringFee;
  }
}
