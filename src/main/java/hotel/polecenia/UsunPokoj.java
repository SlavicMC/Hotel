package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;
import java.util.Scanner;

public class UsunPokoj extends Polecenie
{
    public UsunPokoj()
    {
        nazwa = "up";
        opis = "usuwa pokoj, wymaga numeru";

    }

    /**
     * Polecenie usuwajace pokoj z hotelu
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
        if (p.uzyskajGosci() != null)
        {
            System.out.println("Nie mozna usunac zajetego pokoju");
            return;
        }
        hotel.uzyskajPokoje().usun(numer);
        System.out.println("Pomyslnie usunieto pokoj " + numer);
    }
}
