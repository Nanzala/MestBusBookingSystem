package bookingsystem;

import java.util.List;
import java.util.Scanner;

/**
 * Created by law on 9/24/15.
 */
public class MainApp {

    static Authentication authentication;
    static MestBus mestBus;
    static Reservation reservation;
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String seatNo;

        /*
        Authenticate user
         */
        authentication = new Authentication();
        if(authentication.authenticate() == true){
            /*
            Check for availability of bus
             */
            mestBus = new MestBus();
            //List<String> busAvailability = mestBus.checkBusAvailability();
            List<String> busAvailability = mestBus.checkBusAvailabilityFromDB();

            reservation = new Reservation();
            reservation.reserveSeat(mestBus, scanner, busAvailability);
        }
    }
}
