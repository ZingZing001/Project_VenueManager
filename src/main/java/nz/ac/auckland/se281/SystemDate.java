package nz.ac.auckland.se281;

public class SystemDate {
  private String setDate;
  private String currentDate;

  public SystemDate() {
    setDate = null;
    currentDate = null;
  }

  public SystemDate(String setDate) {
    this.setDate = setDate;
    currentDate = null;
  }
}
