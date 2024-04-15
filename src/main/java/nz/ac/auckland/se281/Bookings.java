package nz.ac.auckland.se281;

public class Bookings{
  private String venueCode;
  private String currentDate;
  private String email;
  private int numberAttends;

  public Bookings(String venueCode, String currentDate, String email, int numberAttends) {
    this.venueCode = venueCode;
    this.currentDate = currentDate;
    this.email = email;
    this.numberAttends = numberAttends;
  }

  public String getVenueCode() {
    return venueCode;
  }
  
  public String getDateBooked() {
    return currentDate;
  }

  public String getEmail() {
    return email;
  }

  public int getNumberAttends() {
    return numberAttends;
  }
}
