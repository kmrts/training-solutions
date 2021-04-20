package week06d03.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void testCalculateSeriesType() {
        Series ser= new Series();

        assertEquals(SeriesType.INCREASING, ser.calculateSeriesType(List.of(2, 4, 5, 9, 11, 123)));
        assertEquals(SeriesType.DECREASING, ser.calculateSeriesType(List.of(22, 14, 5, 2, -15)));
        assertEquals(SeriesType.MIXED, ser.calculateSeriesType(List.of(22, 14, 15, 2, -15)));
    }

    @Test
    void testExceptions(){
        Series series= new Series();

        assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(List.of()));
        assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(List.of(3)));

        assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(List.of(1, 3, 3, 5)));
    }
}