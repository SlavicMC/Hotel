package hotel.polecenia;

import hotel.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZapiszTest
{
    private Hotel hotel;
    private Zapisz zapisz;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("TestHotel");
        zapisz = new Zapisz();
    }

    @Test
    void testUsunPokojGdyNumerIstnieje()
    {
        zapisz.wykonaj(null, hotel);
        Hotel nowyHotel = new Hotel("TestHotel");
        assertEquals(hotel.uzyskajPokoje().liczba(), nowyHotel.uzyskajPokoje().liczba(),"Liczba gości ma być równa.");
        assertEquals(hotel.uzyskajPokoje().znajdz(101).uzyskajGosci(), nowyHotel.uzyskajPokoje().znajdz(101).uzyskajGosci(),"W pokoju nie ma być gości.");
        assertEquals(hotel.uzyskajPokoje().znajdz(102).uzyskajGosci().uzyskajImiona().get(0), nowyHotel.uzyskajPokoje().znajdz(102).uzyskajGosci().uzyskajImiona().get(0),"W pokoju nie ma być gości.");
    }
}
