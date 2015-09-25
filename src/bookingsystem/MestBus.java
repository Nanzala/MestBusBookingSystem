package bookingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by law on 9/24/15.
 */
public class MestBus {

    String[] bus1 = new String[]{"1A", "1B", "1C", "1D", "1E", "1F", "1G", "1H", "1I", "1J", "1K", "1L", "1M", "1N", "1O", "1P", "1Q"};
    String[] bus2 = new String[]{"2A", "2B", "2C", "2D", "2E", "2F", "2G", "2H", "2I", "2J", "2K", "2L", "2M", "2N", "2O", "2P", "2Q"};
    List<String> list1, list2;

    FileWriter fileWriter;
    Scanner scanner;

    public MestBus(){
        list1 = new ArrayList<>();
        //list1.addAll(Arrays.asList(bus1));
        list2 = new ArrayList<>();
        //list2.addAll(Arrays.asList(bus2));
    }

    public List<String> checkBusAvailability(){
        List<String> list = new ArrayList<>();
        int i = 0;
        if(list1.size() > 0 || list2.size() > 0){
            for(String x: list1){
                list.add(x);
                i++;
            }
            i += i;
            for(String x: list2){
                list.add(x);
                i++;
            }
        }
        return list;
    }

    public void checkOutSeat(String seatNo){
        if(list1.contains(seatNo)){
            list1.remove(seatNo);
        }else{
            list2.remove(seatNo);
        }
    }

    public List<String> checkBusAvailabilityFromDB(){
        List<String> combinedList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("bus1.txt"));
            while(scanner.hasNext()){
                list1.add(scanner.nextLine());
            }
            scanner = new Scanner(new File("bus2.txt"));
            while(scanner.hasNext()){
                list2.add(scanner.nextLine());
            }
            combinedList.addAll(list1);
            combinedList.addAll(list2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return combinedList;
    }

    public void checkOutSeatFromDB(String seatNo){
        try {
            if(list1.contains(seatNo)){
                fileWriter = new FileWriter(new File("bus1.txt"));
                list1.remove(seatNo);
                for(String x: list1){
                    fileWriter.write(x + "\n");
                }

            }else{
                fileWriter = new FileWriter(new File("bus2.txt"));
                list2.remove(seatNo);
                for(String x: list2){
                    fileWriter.write(x + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
