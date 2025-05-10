package hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    private Hotel hotel;

    @BeforeEach
    void setUp() throws Exception {
        String hotelFile = "TestHotel.csv";
        try (FileWriter writer = new FileWriter(hotelFile)) {
            writer.write("Numer,Miejsca,Cena,Data meldowania,Liczba dni,Imiona\n");
            writer.write("101,2,150\n");
            writer.write("102,3,200,01-11-2023,5,Jan,Anna\n");
        }
        hotel = new Hotel("TestHotel");
    }

    @Test
    void testLoadFromFile() {
        assertNotNull(hotel.pokoje.znajdz(101), "Pokój 101 powinien zostać załadowany z pliku.");
        assertNotNull(hotel.pokoje.znajdz(102), "Pokój 102 powinien zostać załadowany z pliku.");
    }

    @Test
    void testDodajPokoj() {
        hotel.pokoje.dodaj(103, new Pokoj(103, 4, 300));
        assertNotNull(hotel.pokoje.znajdz(103), "Pokój 103 powinien zostać dodany.");
    }

    @Test
    void testNazwaHotelu() {
        assertEquals("TestHotel", hotel.nazwa, "Nazwa hotelu powinna wynosić 'TestHotel'.");
    }

    @Test
    void testPlikNieIstnieje() throws Exception {
        Files.deleteIfExists(Paths.get("NowyHotel.csv"));
        Hotel nowyHotel = new Hotel("NowyHotel");
        assertEquals(0, nowyHotel.pokoje.liczba(), "Nowy hotel powinien być pusty, jeśli plik nie istnieje.");
    }
}
