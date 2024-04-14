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

  public void setCurrentDate(String setDate) {
    currentDate = setDate;
  }

  public String getCurrentDate() {
    if (currentDate == null) {
      return null;
    } else {
      return currentDate;
    }
  }
}
