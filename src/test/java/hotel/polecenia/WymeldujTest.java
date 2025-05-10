package hotel.polecenia;

import hotel.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WymeldujTest
{

    private Hotel hotel;
    private Wymelduj wymelduj;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("TestHotel");
        wymelduj = new Wymelduj();
    }

    @Test
    void testUsunPokojGdyNumerIstnieje() {
        Scanner skaner = new Scanner("102");

        wymelduj.wykonaj(skaner, hotel);
        assertNull(hotel.uzyskajPokoje().znajdz(102).uzyskajGosci(),"W pokoju nie ma być gości.");
    }
}
