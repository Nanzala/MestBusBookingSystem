/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;


import java.util.Scanner;

/**
 * @author megyewodi
 */

public class Authentication {
    Scanner inp = new Scanner(System.in);
    boolean verified = false;
    String[] id = {"B3475", "B4753", "A7423", "A6577", "A8989", "A9788", "A4343", "A5468", "A8709", "B6670"};
    String[] name = {"Bernard", "Tabitha", "Julius", "Amanze", "Mukeli", "Patience", "Eric", "Henry", "Law", "Isaac"};

    public boolean authenticate() {
        System.out.print("Welcome to MEST Bus System\n\nPlease Enter your ID : ");
        boolean a = true;
        boolean b = verifyId();
        if (a != b) {
            System.out.println("\nYou have exhausted your number of trials.\n\nPlease try again later.");
            System.exit(0);
        }
        return b;
    }

    public boolean verifyId() {
        int j = 0;
        while (j < 3) {
            String myId = inp.nextLine();
            for (int i = 0; i < id.length; i++) {
                if (myId.equalsIgnoreCase(id[i])) {
                    System.out.println("\nWelcome " + name[i] + ",\n");
                    verified = true;
                    break;
                }
            }
            if (verified == true) {
                break;
            }
            if(j < 2){
                if((2 - j) == 1){
                    System.out.print("Your ID is wrong, you have " + (2 - j) + " trial remaining : ");
                }else{
                    System.out.print("Your ID is wrong, you have " + (2 - j) + " trials remaining : ");
                }
            }
            j++;
        }

        return verified;
    }


}