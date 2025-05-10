package hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GoscieTest {

    private Goscie goscie;

    @BeforeEach
    void setUp() {
        goscie = new Goscie(101, LocalDate.of(2023, 11, 1), 5, Arrays.asList("Jan", "Anna", "Krzysztof"));
    }

    @Test
    void testToString() {
        String expected = "Goscie w pokoju: Jan, Anna, Krzysztof, \nData zameldowania: 01-11-2023, Data wymeldowania: 06-11-2023;";
        assertEquals(expected, goscie.toString(), "Nieprawidłowa reprezentacja obiektu Goscie.");
    }

    @Test
    void testLiczbaDni() {
        assertEquals(5, goscie.uzyskajLiczbeDni(), "Liczba dni powinna wynosić 5.");
    }

    @Test
    void testDataMeldowania() {
        assertEquals(LocalDate.of(2023, 11, 1), goscie.uzyskajDateMeldowania(), "Data meldowania powinna wynosić 2023-11-01.");
    }

    @Test
    void testImiona() {
        assertEquals(Arrays.asList("Jan", "Anna", "Krzysztof"), goscie.uzyskajImiona(), "Lista imion powinna zawierać Jan, Anna, Krzysztof.");
    }
}
