package bookingsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by law on 9/24/15.
 */
public class MestBus {

    String[] bus1 = new String[]{"1A", "1B", "1C", "1D", "1E", "1F", "1G", "1H", "1I", "1J", "1K", "1L", "1M", "1N", "1O", "1P", "1Q"};
    String[] bus2 = new String[]{"2A", "2B", "2C", "2D", "2E", "2F", "2G", "2H", "2I", "2J", "2K", "2L", "2M", "2N", "2O", "2P", "2Q"};
    List<String> list1, list2;

    public MestBus(){
        list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(bus1));
        list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(bus2));
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

}
