package skyPro.Certif;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlights(flights);
        printFlightList(flights);

        flightFilter.setFilter(new UpcomingFlights());
        printFlightList(flightFilter.executeFilter());

        flightFilter.setFilter(new FlightDepartsBeforeArrives());
        printFlightList(flightFilter.executeFilter());

        flightFilter.setFilter(new    FlightMoreTwoHoursGroundTime());
        printFlightList(flightFilter.executeFilter());
    }

    public static void printFlightList(List<Flight>list) {
        list.forEach(System.out::println);
        System.out.println("=================================");
    }



}