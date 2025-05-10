package hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PokojTest {

    private Pokoj pokoj;

    @BeforeEach
    void setUp() {
        pokoj = new Pokoj(101, 2, 150);
    }

    @Test
    void testToStringBezGosci() {
        String expected = "Pokoj 101: Miejsca: 0/2, Cena: 150 zl;";
        assertEquals(expected, pokoj.toString(), "Reprezentacja pokoju bez gości jest niepoprawna.");
    }

    @Test
    void testToStringZGoscmi() {
        pokoj.goscie = new Goscie(101, LocalDate.of(2023, 11, 1), 5, Arrays.asList("Jan", "Anna"));
        String expected = "Pokoj 101: Miejsca: 2/2, Cena: 150 zl,\nGoscie w pokoju: Jan, Anna, \nData zameldowania: 01-11-2023, Data wymeldowania: 06-11-2023;";
        assertEquals(expected, pokoj.toString(), "Reprezentacja pokoju z gośćmi jest niepoprawna.");
    }


    @Test
    void testNumer() {
        assertEquals(101, pokoj.numer, "Numer pokoju powinien wynosić 101.");
    }

    @Test
    void testMiejsca() {
        assertEquals(2, pokoj.miejsca, "Liczba miejsc w pokoju powinna wynosić 2.");
    }

    @Test
    void testCena() {
        assertEquals(150, pokoj.cena, "Cena pokoju powinna wynosić 150.");
    }
}
