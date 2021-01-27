package week13d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FlightStatTest {

    @Test
    void loadFlights() {
        FlightStat fs= new FlightStat();
        fs.loadFlights(Path.of("cities.txt"));

        assertEquals(100, fs.getFlightList().size());
        assertEquals("Ankara", fs.getFlightList().get(19-1).getCity() );
        assertEquals("15:20", fs.getFlightList().get(77-1).getTime() );
        assertEquals(FlightType.DEPARTURE, fs.getFlightList().get(77-1).getType() );
        assertEquals("MB5081", fs.getFlightList().get(77-1).getNumber() );
    }

    @Test
    void countArrivalVsDeparture() {
        FlightStat fs= new FlightStat();
        fs.loadFlights(Path.of("cities.txt"));

        assertEquals("Arrivals: 46, Departures: 54", fs.countArrivalVsDeparture());
    }

    @Test
    void flightFromNumber() {
        FlightStat fs= new FlightStat();
        fs.loadFlights(Path.of("cities.txt"));

        assertEquals("Bucharest", fs.flightFromNumber("JO3963").getCity() );
        assertEquals("20:50", fs.flightFromNumber("GP0840").getTime() );

    }

    @Test
    void flightsFromCityAndType() {
        FlightStat fs= new FlightStat();
        fs.loadFlights(Path.of("cities.txt"));

        assertEquals(2, fs.flightsFromCityAndType("Zurich", FlightType.DEPARTURE).size());
    }

    @Test
    void earlyestFlight() {
        FlightStat fs= new FlightStat();
        fs.loadFlights(Path.of("cities.txt"));

        assertEquals("Zurich", fs.earliestDepFlight().getCity());
        assertEquals("FG3210", fs.earliestDepFlight().getNumber());
    }
}