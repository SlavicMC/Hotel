package hotel.polecenia;

import hotel.Goscie;
import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zamelduj extends Polecenie
{
    public Zamelduj()
    {
        nazwa = "zm";
        opis = "melduje gosci, wymaga numeru pokoju, daty meldowania, liczby dni oraz listy gosci";
    }

    /**
     * Polecenie meldujace gosci w hotelu
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        System.out.println("Podaj numer pokoju:");
        int numer = skaner.nextInt();
        skaner.nextLine();
        Pokoj p = hotel.uzyskajPokoje().znajdz(numer);
        if (p == null)
        {
            System.out.println("Taki pokoj nie istnieje");
            return;
        }
        if(p.uzyskajGosci() != null)
        {
            System.out.println("Ten pokoj jest juz zajety");
            return;
        }
        System.out.println("Podaj date (dd-mm-yyyy) lub pomin by wpisac dzisiejsza:");
        String s = skaner.nextLine().trim();
        LocalDate data;
        if(s.isEmpty()) data = LocalDate.now();
        else data = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Podaj liczbe dni:");
        int liczbaDni = skaner.nextInt();
        skaner.nextLine();
        System.out.println("Podaj imiona gosci (maks " + p.uzyskajMiejsca() + ", pomin by zakonczyc):");
        List<String> goscie = new ArrayList<>();
        while(goscie.size() < p.uzyskajMiejsca())
        {
            s = skaner.nextLine().trim();
            if(s.isEmpty()) break;
            else goscie.add(s);
        }
        if(goscie.isEmpty())
        {
            System.out.println("Nalezy podac imie przynajmniej jednego goscia");
            return;
        }
        p.ustawGosci(new Goscie(numer, data, liczbaDni, goscie));
        System.out.println("Pomyslnie zameldowano gosci w pokoju " + p.uzyskajNumer());
    }
}
