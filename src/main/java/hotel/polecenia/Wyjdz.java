package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import java.util.Scanner;

public class Wyjdz extends Polecenie
{
    public Wyjdz()
    {
        nazwa = "wyjdz";
        opis = "konczy dzialanie";
    }

    /**
     * Polecenie konczace program
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        System.exit(0);
    }
}
