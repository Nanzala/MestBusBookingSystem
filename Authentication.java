/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mestbus;


import java.util.Scanner;

/**
 *
 * @author megyewodi
 */
public class Authentication2 {
    boolean verified =false;
    String [] id = {"B3475","B4753","A7423","A6577","A8989","A9788","A4343","A5468","A8709","B6670"};
    String [] name = {"Bernard","Tabitha","Julius","Amanze","Mukeli","Patience","Eric","Henry","Law","Isaac"};

	 public void authenticate(){
            System.out.println("Welcome to MEST Bus System \n Please Enter your ID : ");
            boolean a = true;
            boolean b = verifyId();
            if(a != b){  
                System.out.println("You have exhausted your number of trials.\nPlease try again later.");
                System.exit(0);
            }
         }
         
         
	public String retry(){
           Scanner inp = new Scanner(System.in);
           String input =  inp.nextLine();
           return input;
	}

	public boolean verifyId(){
                int j = 0;
                String myId;
		while(j < 3){
                    myId = retry();
                    for(int i = 0; i < id.length ;i++ ){
                        if (myId.equals(id[i])){
                            System.out.println("Welcome " + name[i]);  
                            verified = true;
                            break;
                        }
                    }
                    if(verified == true){
                        break;
                    } 
                    System.out.println("Your ID is wrong, try again.");
                    j++;
                }
                
              return verified; 
        } 
        
        
        
    
}