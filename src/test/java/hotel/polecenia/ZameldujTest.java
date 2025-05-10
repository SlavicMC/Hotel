package hotel.polecenia;

import hotel.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ZameldujTest
{

    private Hotel hotel;
    private Zamelduj zamelduj;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("TestHotel");
        zamelduj = new Zamelduj();
    }

    @Test
    void testUsunPokojGdyNumerIstnieje() {
        Scanner skaner = new Scanner("101\n\n3\nMirek\n\n");
        zamelduj.wykonaj(skaner, hotel);

        assertEquals("Mirek", hotel.uzyskajPokoje().znajdz(101).uzyskajGosci().uzyskajImiona().get(0),"W pokoju powinien być Mirek.");
        assertEquals(1, hotel.uzyskajPokoje().znajdz(101).uzyskajGosci().uzyskajImiona().size(),"W pokoju powinien być jeden gość.");
    }
}
