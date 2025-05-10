package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;
import java.util.Scanner;

public class InfoPokoju extends Polecenie
{
    public InfoPokoju()
    {
        nazwa = "ip";
        opis = "informacje o pokoju, wymaga numeru";
    }

    /**
     * Polecenie wyswietlajace informacje o pokoju
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        System.out.println("Podaj numer pokoju:");
        int numer = skaner.nextInt();
        Pokoj p = hotel.uzyskajPokoje().znajdz(numer);
        if (p == null)
        {
            System.out.println("Taki pokoj nie istnieje");
            return;
        }
        System.out.println(p);
    }
}
