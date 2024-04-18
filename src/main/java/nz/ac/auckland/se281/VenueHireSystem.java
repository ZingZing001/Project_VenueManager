package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  protected ArrayList<Venues> allVenues = new ArrayList<Venues>();
  protected ArrayList<SystemDate> dateStored = new ArrayList<SystemDate>();
  protected ArrayList<Bookings> bookings = new ArrayList<Bookings>();
  protected ArrayList<String> references = new ArrayList<String>();

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
      } else if (allVenues.size() > 1 && allVenues.size() < 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", strArr[allVenues.size()], "s");
      } else {
        MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(allVenues.size()), "s");
      }
      for (Venues venues : allVenues) {
        String vName = venues.getVenueName();
        String vCode = venues.getAlias();
        String vCapacity = venues.getCapacity();
        String vFees = venues.getFees();
        if (!dateStored.isEmpty()) {
          String systemdate = dateStored.get(0).getCurrentDate();
          String currentDate = systemdate;
          if (bookings.isEmpty()) {
            MessageCli.VENUE_ENTRY.printMessage(vName, vCode, vCapacity, vFees, systemdate);
          } else {
            for (int i = 0; i < bookings.size(); i++) {
              String occupiedDates = bookings.get(i).getDateBooked();
              String byWhichCompany = bookings.get(i).getvenueCode();
              boolean daybooked = true;
              while (daybooked) {
                if (occupiedDates.equals(currentDate) && byWhichCompany.equals(vCode)) {
                  String[] currentDateInParts = currentDate.split("/");
                  int day = Integer.parseInt(currentDateInParts[0]); // "day"
                  int month = Integer.parseInt(currentDateInParts[1]); // "month"
                  int year = Integer.parseInt(currentDateInParts[2]); // "year"
                  day = day + 1;
                  if (day > 31) {
                    day = 1;
                    month++;
                  }
                  if (month > 12) {
                    month = 1;
                    year++;
                  }
                  if (day < 10 && month > 10) {
                    currentDate = "0" + day + "/" + month + "/" + year;
                  } else if (month < 10 && day > 10) {
                    currentDate = day + "/" + "0" + month + "/" + year;
                  } else if (day < 10 && month < 10) {
                    currentDate = "0" + day + "/" + "0" + month + "/" + year;
                  } else {
                    currentDate = day + "/" + month + "/" + year;
                  }
                } else {
                  daybooked = false;
                  MessageCli.VENUE_ENTRY.printMessage(vName, vCode, vCapacity, vFees, currentDate);
                }
              }
            }
          }
        } else {
          MessageCli.VENUE_ENTRY.printMessage(vName, vCode, vCapacity, vFees);
        }
      }
    }
  }

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
          error = true;
          MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(
              bookings.get(i).getVenueName(), bookings.get(i).getDateBooked());
        }
      }
    } else if (!dateStored.isEmpty()) {
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

      if ((yearI < yearC)
          || (monthI < monthC) && (dayI < dayC)
          || (monthI == monthC) && (dayI < dayC)) {
        error = true;
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(dateI, date);
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

      int inputCapacity = Integer.parseInt(options[3]);
      int venueCapacity = Integer.parseInt(allVenues.get(indexOfVenue).getCapacity());
      double attendeesLimits = 0.25 * venueCapacity;
      if (inputCapacity < attendeesLimits) {
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
            "" + inputCapacity, "" + (int) attendeesLimits, "" + venueCapacity);
        inputCapacity = (int) attendeesLimits;

      } else if (inputCapacity > venueCapacity) {
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
            "" + inputCapacity, "" + venueCapacity, "" + venueCapacity);
        inputCapacity = venueCapacity;
      }
      String venueNameBooked = allVenues.get(indexOfVenue).getVenueName();
      bookings.add(
          new Bookings(
              venueNameBooked,
              options[1],
              options[2],
              inputCapacity,
              allVenues.get(indexOfVenue).getAlias(),
              BookingReferenceGenerator.generateBookingReference()));
      for (int i = 0; i < bookings.size(); i++) {
        if (bookings.get(i).getVenueName().equals(venueNameBooked)) {
          int venueindex = i;
          MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
              bookings.get(venueindex).getBookingReference(),
              allVenues.get(indexOfVenue).getVenueName(),
              options[1],
              "" + inputCapacity);
        }
      }
    }
  }

  public void printBookings(String venueCode) {
    int indexOfVenue = 0;
    String venueStored;
    int errorNoneFound = 0;
    String nameOfVenue;
    for (int i = 0; i < allVenues.size(); i++) {
      venueStored = allVenues.get(i).getAlias();
      if (!venueStored.equals(venueCode)) {
        errorNoneFound++;
      } else {
        indexOfVenue = i;
        nameOfVenue = allVenues.get(indexOfVenue).getVenueName();
        MessageCli.PRINT_BOOKINGS_HEADER.printMessage(nameOfVenue);
        if (bookings.isEmpty()) {
          MessageCli.PRINT_BOOKINGS_NONE.printMessage(nameOfVenue);
          break;
        }
      }
    }
    if (errorNoneFound == allVenues.size()) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    }
    // } else {
    //   for (Bookings allbooking : bookings) {
    //     if (allbooking.getvenueCode().equals(venueCode)) {
    //       String bookingReference = allbooking.getBookingReference();
    //       MessageCli.PRINT_BOOKINGS_ENTRY.printMessage();
    //     }
    //   }
    // }
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
