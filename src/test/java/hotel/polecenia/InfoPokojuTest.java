package hotel.polecenia;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import hotel.Hotel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InfoPokojuTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void testInfoPokoju()
    {
        Hotel hotel = new Hotel("TestHotel");
        InfoPokoju infoPokoju = new InfoPokoju();
        Scanner skaner = new Scanner("101\n");
        System.setOut(new PrintStream(outputStream));
        infoPokoju.wykonaj(skaner, hotel);
        String output = outputStream.toString();
        assertEquals("Podaj numer pokoju:" + System.lineSeparator() + "Pokoj 101: Miejsca: 0/2, Cena: 150 zl;" + System.lineSeparator(), output);
        System.setOut(originalOut);
    }
}
