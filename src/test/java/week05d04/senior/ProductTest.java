package week05d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void convertPrice() {
//        Product pr = new Product(150, "HUF");
//        Product pr1 = new Product(100, "USD");
//        Product pr2 = new Product(11, "USD");

        Product pr = new Product(150, Currency.HUF);
        Product pr1 = new Product(100, Currency.USD);
        Product pr2 = new Product(11, Currency.USD);

//        assertEquals(0.5, pr.convertPrice("USD"));
//        assertEquals(100.0, pr1.convertPrice("USD"));
//        assertEquals(3300.0, pr2.convertPrice("HUF"))

//        assertThrows(IllegalArgumentException.class, () -> new Product(111, "NOK"));

        assertEquals(0.5, pr.convertPrice(Currency.USD));
        assertEquals(100.0, pr1.convertPrice(Currency.USD));
        assertEquals(3300.0, pr2.convertPrice(Currency.HUF));

        assertThrows(IllegalArgumentException.class, ()-> new Product(222, Currency.NOK));


    }
}