package skyPro.Certif;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * 3. общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного
 * сегмента и вылетом следующего за ним)
 */

public class FlightMoreTwoHoursGroundTime implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Полёты, в которых общее время, проведённое на земле, не превышает два часа: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> {
            int size = flight.getSegments().size();
            if (size > 1) {
                int countHours = 0;
                for (int i = 1; i < size; i++) {
                    countHours += transferTime(flight.getSegments().get(i - 1).getArrivalDate(),
                            flight.getSegments().get(i).getDepartureDate());
                }
                if (countHours <= 2) {
                    list.add(flight);
                }
            } else {
                list.add(flight);
            }
        });
        return list;
    }

    public int transferTime(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }




}