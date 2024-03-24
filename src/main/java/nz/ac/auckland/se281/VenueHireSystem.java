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
    // Check if theres any venue allready existed
    if (venueArrayName.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
      // Print all the venues out
    } else {
      for (int i = 0; i < venueArrayName.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(
            venueArrayName.get(i),
            venueArrayCode.get(i),
            venueArrayCap.get(i),
            venueArrayFee.get(i));
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method
    // Check for venueName is empty or not
    boolean flag = true;
    if (venueName == null
        || venueName.trim().isEmpty()
        || venueName.isBlank()
        || venueName.charAt(0) == ' ') {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    // Check if this venueCode is unique throughout the system
    if (venueArrayCode.size() >= 1) {
      if (venueArrayCode.contains(venueCode)) {
        flag = false;
        int pos = venueCode.indexOf(venueCode);
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venueArrayName.get(pos));
      }
    }
    // Check if capacityInput is valid or not
    if (Integer.valueOf(capacityInput) <= 0) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
    } else if (capacityInput.contains(".")) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " whole");
    }

    // Check if venueFees is valid or not
    if (Integer.valueOf(hireFeeInput) <= 0) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "positive");
    } else if (capacityInput.contains(".")) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("Capacity", "number");
    }

    if (flag == true) {
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
      venueArrayName.add(venueName);
      venueArrayCode.add(venueCode);
      venueArrayCap.add(capacityInput);
      venueArrayFee.add(hireFeeInput);
    }
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
