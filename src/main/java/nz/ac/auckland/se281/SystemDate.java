package nz.ac.auckland.se281;

public class SystemDate {
  private String currentDate;

  public SystemDate() {
    currentDate = "";
  }

  public SystemDate(String currentDate) {
    this.currentDate = currentDate;
  }

  public String getCurrentDate() {
    return currentDate;
  }
}
