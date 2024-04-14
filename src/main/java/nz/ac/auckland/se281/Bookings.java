package nz.ac.auckland.se281;

public class Bookings extends Venues {
  private String venueCode;
  private String currentDate;
  private String email;
  private int numberAttends;

  public Bookings(String venueCode, String currentDate, String email, int numberAttends) {
    super(venueCode);
    this.venueCode = venueCode;
    this.currentDate = currentDate;
    this.email = email;
    this.numberAttends = numberAttends;
  }

  public String getVenueCode() {
    return venueCode;
  }
  
  public String getVenueName(){
    return venueName;
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
