package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  protected ArrayList<Venues> allVenues = new ArrayList<Venues>();
  protected ArrayList<SystemDate> dateStored = new ArrayList<SystemDate>();
  protected ArrayList<Bookings> bookings = new ArrayList<Bookings>();

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
    if (dateStored.isEmpty()) {
      dateStored.add(new SystemDate(dateInput));
    } else {
      dateStored.set(0, new SystemDate(dateInput));
    }
    String date = dateStored.get(0).getCurrentDate();
    MessageCli.DATE_SET.printMessage(date);
  }

  public void printSystemDate() {
    if (dateStored.isEmpty()) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      String date = dateStored.get(0).getCurrentDate();
      MessageCli.CURRENT_DATE.printMessage(date);
    }
  }

  public void makeBooking(String[] options) {
    boolean error = false;
    if (dateStored.isEmpty()) {
      error = true;
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
    } else if (allVenues.isEmpty()) {
      error = true;
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
    } else if (bookings.size() >= 1) {
      for (int i = 0; i < bookings.size(); i++) {
        if (bookings.get(i).getDateBooked().equals(options[1])) {
          MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(options);
        }
      }
    }
    if (!error) {
      boolean found = false;
      int indexOfVenue = 0;
      for (int i = 0; i < allVenues.size(); i++) {
        String storedVenue = allVenues.get(i).getAlias();
        if (storedVenue.contains(options[0])) {
          found = true;
          indexOfVenue = i;
        }
      }
      if (!found) {
        error = true;
        MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      }
      String date = dateStored.get(0).getCurrentDate();
      String[] datePartsC = date.split("/");
      int dayC = Integer.parseInt(datePartsC[0]); // "day"
      int monthC = Integer.parseInt(datePartsC[1]); // "month"
      int yearC = Integer.parseInt(datePartsC[2]); // "year"

      String dateI = options[1];
      String[] datePartsI = dateI.split("/");
      int dayI = Integer.parseInt(datePartsI[0]); // "day"
      int monthI = Integer.parseInt(datePartsI[1]); // "month"
      int yearI = Integer.parseInt(datePartsI[2]); // "year"

      if (yearI > yearC || monthI > monthC || dayI > dayC) {
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(dateI, date);
      }

      int inputCapacity = Integer.parseInt(options[3]);
      int venueCapacity = Integer.parseInt(allVenues.get(indexOfVenue).getCapacity());
      int attendeesLimits = (int) 0.25 * venueCapacity;
      if (inputCapacity < attendeesLimits) {
        inputCapacity = attendeesLimits;
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage();
      } else if (inputCapacity > venueCapacity) {
        inputCapacity = venueCapacity;
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage();
      }
      MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage();
    }
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
