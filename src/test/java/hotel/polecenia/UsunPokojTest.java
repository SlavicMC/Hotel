package hotel.polecenia;

import hotel.Hotel;
import hotel.Pokoj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UsunPokojTest
{

    private Hotel hotel;
    private UsunPokoj usunPokoj;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("TestHotel");
        usunPokoj = new UsunPokoj();
    }

    @Test
    void testUsunPokojGdyNumerIstnieje() {
        Scanner skaner = new Scanner("507\n");
        usunPokoj.wykonaj(skaner, hotel);

        assertEquals(2, hotel.uzyskajPokoje().liczba(),"Pokój o numerze 101 powinien zniknąć.");
    }

    @Test
    void testUsunNowyPokoj() {
        Scanner skaner = new Scanner("101\n");
        usunPokoj.wykonaj(skaner, hotel);

        Pokoj pokoj = hotel.uzyskajPokoje().znajdz(101);
        assertNull(pokoj, "Pokój o numerze 101 powinien zniknąć.");
    }
}
