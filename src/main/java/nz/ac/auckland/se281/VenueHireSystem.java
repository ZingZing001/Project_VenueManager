package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  ArrayList<Venues> allVenues = new ArrayList<Venues>();

  // ArrayList<String> venueArrayCode = new ArrayList<String>();
  // ArrayList<String> venueArrayCap = new ArrayList<String>();
  // ArrayList<String> venueArrayFee = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
    String[] strArr = {
      "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    if (allVenues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    } else {
      if (allVenues.size() == 1) {
        MessageCli.NUMBER_VENUES.printMessage("is", strArr[1], "");
        for (Venues venues : allVenues) {
          String vName = venues.getVenueName();
          String vCode = venues.getAlias();
          String vCapacity = venues.getCapacity();
          String vFees = venues.getFees();
          MessageCli.VENUE_ENTRY.printMessage(vName, vCode, vCapacity, vFees);
        }
      } else if (allVenues.size() > 1 && allVenues.size() < 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", strArr[allVenues.size()], "s");
        for (Venues venues : allVenues) {
          String vName = venues.getVenueName();
          String vCode = venues.getAlias();
          String vCapacity = venues.getCapacity();
          String vFees = venues.getFees();
          MessageCli.VENUE_ENTRY.printMessage(vName, vCode, vCapacity, vFees);
        }
      } else {
        MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(allVenues.size()), "s");
        for (Venues venues : allVenues) {
          String vName = venues.getVenueName();
          String vCode = venues.getAlias();
          String vCapacity = venues.getCapacity();
          String vFees = venues.getFees();
          MessageCli.VENUE_ENTRY.printMessage(vName, vCode, vCapacity, vFees);
        }
      }
    }
  }

  //   String[] strArr = {
  //     "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
  //   };
  //   // TODO implement this method
  //   // Check if theres any venue allready existed
  //   if (venueArrayName.isEmpty()) {
  //     MessageCli.NO_VENUES.printMessage();
  //     // Print all the venues out
  //   } else {
  //     if (venueArrayName.size() == 1) {
  //       MessageCli.NUMBER_VENUES.printMessage("is", strArr[1], "");
  //       for (int i = 0; i < venueArrayName.size(); i++) {
  //         MessageCli.VENUE_ENTRY.printMessage(
  //             venueArrayName.get(i),
  //             venueArrayCode.get(i),
  //             venueArrayCap.get(i),
  //             venueArrayFee.get(i));
  //       }
  //     } else if (venueArrayName.size() > 1 && venueArrayName.size() < 10) {
  //       MessageCli.NUMBER_VENUES.printMessage("are", strArr[venueArrayName.size()], "s");
  //       for (int i = 0; i < venueArrayName.size(); i++) {
  //         MessageCli.VENUE_ENTRY.printMessage(
  //             venueArrayName.get(i),
  //             venueArrayCode.get(i),
  //             venueArrayCap.get(i),
  //             venueArrayFee.get(i));
  //       }
  //     } else {
  //       MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venueArrayName.size()), "s");
  //       for (int i = 0; i < venueArrayName.size(); i++) {
  //         MessageCli.VENUE_ENTRY.printMessage(
  //             venueArrayName.get(i),
  //             venueArrayCode.get(i),
  //             venueArrayCap.get(i),
  //             venueArrayFee.get(i));
  //       }
  //     }
  //   }
  // }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method
    boolean flag = true;
    if (venueName == null
        || venueName.trim().isEmpty()
        || venueName.isBlank()
        || venueName.charAt(0) == ' ') {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    if (allVenues.size() >= 1) {
      for (int i = 0; i < allVenues.size(); i++) {
        if (allVenues.get(i).getAlias().equals(venueCode)) {
          flag = false;
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
              venueCode, allVenues.get(i).getVenueName());
        }
      }
    }

    try {
      Integer.parseInt(capacityInput);
      if (Integer.valueOf(capacityInput) <= 0) {
        flag = false;
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      } else if (capacityInput.contains(".")) {
        flag = false;
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " whole");
      }
    } catch (NumberFormatException e) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
    }

    if (!hireFeeInput.matches(".*\\d+.*")) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
    } else if (Integer.valueOf(hireFeeInput) <= 0) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
    } else if (hireFeeInput.contains(".")) {
      flag = false;
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
    }

    if (flag == true) {
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
      allVenues.add(new Venues(venueName, venueCode, capacityInput, hireFeeInput));
    }
  }

  //   // Check for venueName is empty or not
  //   boolean flag = true;
  //   if (venueName == null
  //       || venueName.trim().isEmpty()
  //       || venueName.isBlank()
  //       || venueName.charAt(0) == ' ') {
  //     flag = false;
  //     MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
  //   }
  //   // Check if this venueCode is unique throughout the system
  //   if (venueArrayCode.size() >= 1) {
  //     if (venueArrayCode.contains(venueCode)) {
  //       flag = false;
  //       int pos = venueCode.indexOf(venueCode);
  //       MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode,
  // venueArrayName.get(pos));
  //     }
  //   }
  //   // Check if capacityInput is valid or not
  //   try {
  //     Integer.parseInt(capacityInput);
  //     if (Integer.valueOf(capacityInput) <= 0) {
  //       flag = false;
  //       MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
  //     } else if (capacityInput.contains(".")) {
  //       flag = false;
  //       MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " whole");
  //     }
  //   } catch (NumberFormatException e) {
  //     flag = false;
  //     MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
  //   }

  //   // Check if venueFees is valid or not
  //   if (!hireFeeInput.matches(".*\\d+.*")) {
  //     flag = false;
  //     MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
  //   } else if (Integer.valueOf(hireFeeInput) <= 0) {
  //     flag = false;
  //     MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
  //   } else if (hireFeeInput.contains(".")) {
  //     flag = false;
  //     MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
  //   }

  //   if (flag == true) {
  //     MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  //     venueArrayName.add(venueName);
  //     venueArrayCode.add(venueCode);
  //     venueArrayCap.add(capacityInput);
  //     venueArrayFee.add(hireFeeInput);
  //   }
  // }

  public void setSystemDate(String dateInput) {
    String Date = new SystemDate(dateInput).getCurrentDate();
    MessageCli.DATE_SET.printMessage(Date);
  }

  public void printSystemDate() {}

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
