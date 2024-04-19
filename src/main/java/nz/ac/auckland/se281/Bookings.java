package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Bookings {
  private String venueName;
  private String currentDate;
  private String email;
  private int numberAttends;
  private String venueCode;
  private String referenceId;
  private String systemDate;
  private List<Services> services = new ArrayList<>();

  // existing constructor and methods

  public Bookings(
      String venueName,
      String currentDate,
      String systemDate,
      String email,
      int numberAttends,
      String venueCode,
      String refernceId) {

    this.venueName = venueName;
    this.currentDate = currentDate;
    this.systemDate = systemDate;
    this.email = email;
    this.numberAttends = numberAttends;
    this.venueCode = venueCode;
    this.referenceId = refernceId;
  }

  public String getVenueName() {
    return this.venueName;
  }

  public String getvenueCode() {
    return this.venueCode;
  }

  public String getSystemDate() {
    return this.systemDate;
  }

  public String getDateBooked() {
    return this.currentDate;
  }

  public String getEmail() {
    return this.email;
  }

  public int getNumberAttends() {
    return this.numberAttends;
  }

  public String getBookingReference() {
    return referenceId;
  }

  public void addService(Services service) {
    services.add(service);
  }

  public List<Services> getServices() {
    return services;
  }
}
