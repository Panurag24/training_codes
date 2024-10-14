package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class HealthBox {
    private LocalDateTime appointmentDateTime;
    private ZoneId zoneId;

    public void scheduleAppointment(LocalDate date, LocalTime time, ZoneId zoneId) {
        appointmentDateTime = LocalDateTime.of(date, time);
        this.zoneId = zoneId;
        System.out.println("Successfully Booked");
    }

    public void printAppointmentDetails() {
        if (appointmentDateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy hh:mm a");
            System.out.println(appointmentDateTime.atZone(zoneId).format(formatter));
        } else {
            System.out.println("Appointment not booked yet.");
        }
    }

    public void rescheduleAppointment(int days, LocalTime newTime) {
        if (appointmentDateTime != null) {
            appointmentDateTime = appointmentDateTime.plusDays(days).withHour(newTime.getHour())
                    .withMinute(newTime.getMinute());
            System.out.println("Your Appointment has been rescheduled to");
            System.out.println(appointmentDateTime.atZone(zoneId)
                    .format(DateTimeFormatter.ofPattern("EEE, MMM dd yyyy hh:mm a")));
        } else {
            System.out.println("No appointment to reschedule.");
        }
    }

    public void getReminder() {
        if (appointmentDateTime != null) {
            System.out.println("Reminder: Your appointment is on "
                    + appointmentDateTime.minusDays(1).atZone(zoneId).format(DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm a")));
        } else {
            System.out.println("No appointment scheduled for a reminder.");
        }
    }

    public void cancelAppointment() {
        if (appointmentDateTime != null) {
            appointmentDateTime = null;
            System.out.println("Appointment has been cancelled !!");
        } else {
            System.out.println("No appointment to cancel.");
        }
    }
}

public class TestHealthBox {
    public static void main(String[] args) {
        HealthBox healthBox = new HealthBox();
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option != 6) {
            System.out.println("=========================");
            System.out.println("1. Schedule an Appointment");
            System.out.println("2. Print Appointment Details");
            System.out.println("3. Reschedule an Appointment");
            System.out.println("4. Get Reminder");
            System.out.println("5. Cancel the Appointments");
            System.out.println("6. Exit");
            System.out.println("=========================");
            System.out.println("Enter an Option:");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Date (dd/mm/yyyy):");
                    int day = scanner.nextInt();
                    int month = scanner.nextInt();
                    int year = scanner.nextInt();
                    System.out.println("Enter Time (hh:mm):");
                    int hour = scanner.nextInt();
                    int minute = scanner.nextInt();
                    System.out.println("Available Zones are:");
                    System.out.println("A: America/Anchorage");
                    System.out.println("B: Europe/Paris");
                    System.out.println("C: Asia/Tokyo");
                    System.out.println("D: America/Phoenix");
                    System.out.println("=================");
                    System.out.println("Select the Zone:");
                    String zoneInput = scanner.next();
                    ZoneId zoneId = null;
                    switch (zoneInput) {
                        case "A":
                            zoneId = ZoneId.of("America/Anchorage");
                            break;
                        case "B":
                            zoneId = ZoneId.of("Europe/Paris");
                            break;
                        case "C":
                            zoneId = ZoneId.of("Asia/Tokyo");
                            break;
                        case "D":
                            zoneId = ZoneId.of("America/Phoenix");
                            break;
                        default:
                            System.out.println("Invalid Zone selection");
                            break;
                    }
                    healthBox.scheduleAppointment(LocalDate.of(year, month, day),
                            LocalTime.of(hour, minute), zoneId);
                    break;
                case 2:
                    healthBox.printAppointmentDetails();
                    break;
                case 3:
                    System.out.println("Current Appointment Date is:");
                    healthBox.printAppointmentDetails();
                    System.out.println("Kindly Enter Number of Days to be postponed:");
                    int days = scanner.nextInt();
                    System.out.println("Enter the new time in HH:mm:");
                    int newHour = scanner.nextInt();
                    int newMinute = scanner.nextInt();
                    healthBox.rescheduleAppointment(days, LocalTime.of(newHour, newMinute));
                    break;
                case 4:
                    healthBox.getReminder();
                    break;
                case 5:
                    healthBox.cancelAppointment();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }
        scanner.close();
    }
}

