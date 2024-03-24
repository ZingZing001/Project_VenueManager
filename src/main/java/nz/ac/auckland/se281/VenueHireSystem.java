package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  ArrayList<String> venueArrayName = new ArrayList<String>();
  ArrayList<String> venueArrayCode = new ArrayList<String>();
  ArrayList<String> venueArrayCap = new ArrayList<String>();
  ArrayList<String> venueArrayFee = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
    // TODO implement this method
    if (venueArrayName.size() <= 0) {
      MessageCli.NO_VENUES.printMessage();
    } else {
      System.out.println(venueArrayName);
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method
    // Check for venueName is empty or not
    if (venueName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    // Check if this venueCode is unique throughout the system
    if (venueArrayCode.size() >= 1) {
      if (venueArrayCode.contains(venueCode)) {
        int pos = venueCode.indexOf(venueCode);
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venueArrayName.get(pos));
      }
    }
    //
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
