package skyPro.Certif;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. вылет до текущего момента времени
 */
public class DepartureToTime implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        LocalDateTime timeNow =  LocalDateTime.now();
        System.out.println("1. вылет до текущего момента времени. Исключить из тестового набора перелёты. ");
        List<Flight> list = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (timeNow.isBefore(segment.getDepartureDate())) {
                    list.add(flight);
                    break;
                }
            }
        }
        return list;
    }
}