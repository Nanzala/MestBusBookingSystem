package bookingsystem;

import java.util.List;
import java.util.Scanner;

/**
 * Created by law on 9/24/15.
 */
public class Reservation {
    /*
    In this class, Julius & Patience will implement bus reservation logic
     */

    String seatNo;

    public void reserveSeat(MestBus mestBus, Scanner scanner, List<String> busAvailability){

        if (busAvailability.size() > 0) {
            String message = "";
            for (String seat : busAvailability) {
                if (seat.contains("1")) {
                    message += seat + ", ";
                }
            }
            message = message.substring(0, message.length() - 2);
            System.out.println("Bus 1 : " + message);
            message = "";
            for (String seat : busAvailability) {
                if (seat.contains("2")) {
                    message += seat + ", ";
                }
            }
            message = message.substring(0, message.length() - 2);
            System.out.println("\nBus 2 : " + message);

            while(true){
                System.out.print("\nEnter a seat Number you would want to reserve : ");
                seatNo = scanner.nextLine();
                if (busAvailability.contains(seatNo.toUpperCase())) {
                    //mestBus.checkOutSeat(seatNo);
                    mestBus.checkOutSeatFromDB(seatNo.toUpperCase());
                    System.out.println("\nThanks! Seat " + seatNo.toUpperCase() + " has been reserved for you.");
                    System.exit(0);
                } else {
                    System.out.println("\nInvalid seat.");
                }
            }
        } else {
            System.out.print("Oops! Seems you're not in luck today.. All buses have been filled.");
        }
    }
}
