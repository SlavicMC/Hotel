package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;

import java.util.Scanner;

public class Wymelduj extends Polecenie
{
    public Wymelduj()
    {
        nazwa = "wm";
        opis = "wymeldowywuje gosci z pokoju i podaje nalezna oplate, wymaga numeru pokoju";
    }

    /**
     * Polecenie wymeldowywujace gosci z pokoju i podajace nalezna oplate
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        System.out.println("Podaj numer pokoju:");
        int numer = skaner.nextInt();
        Pokoj p = hotel.uzyskajPokoje().znajdz(numer);
        if(p == null)
        {
            System.out.println("Taki pokoj nie istnieje");
            return;
        }
        if(p.uzyskajGosci() == null)
        {
            System.out.println("Ten pokoj jest pusty");
            return;
        }
        System.out.println("Wymeldowano gosci z pokoju. Za pobyt nalezy sie " + p.uzyskajCene() * p.uzyskajGosci().uzyskajLiczbeDni() + " zl");
        p.ustawGosci(null);
    }
}
