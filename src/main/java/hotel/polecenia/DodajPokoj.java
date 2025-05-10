package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;
import java.util.Scanner;

public class DodajPokoj extends Polecenie
{
    public DodajPokoj()
    {
        nazwa = "dp";
        opis = "dodaje pokoj, wymaga numeru, liczby miejsc i ceny";
    }

    /**
     * Polecenie dodajace pokoj do hotelu
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        System.out.println("Podaj numer pokoju:");
        int numer = skaner.nextInt();
        Pokoj p = hotel.uzyskajPokoje().znajdz(numer);
        if (p != null)
        {
            System.out.println("Taki pokoj juz istnieje");
            return;
        }
        System.out.println("Podaj liczbe miejsc:");
        int miejsca = skaner.nextInt();
        System.out.println("Podaj cene:");
        int cena = skaner.nextInt();
        hotel.uzyskajPokoje().dodaj(numer, new Pokoj(numer, miejsca, cena));
        System.out.println("Utworzono " + hotel.uzyskajPokoje().znajdz(numer));
    }
}
