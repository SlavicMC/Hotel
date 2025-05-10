package niestandardowe;

import org.reflections.Reflections;

import hotel.Hotel;
import java.util.Scanner;
import java.util.Set;

import hotel.Polecenie;

public class Main
{
    /**
     * Klasa main, pozyskuje/tworzy hotel i wykonuje kolejne polecenia
     *
     */
    @SuppressWarnings("java:S2189")
    public static void main(String[] args)
    {
        System.out.println("Podaj nazwe hotelu do wczytania lub utworzenia:");
        Scanner skaner = new Scanner(System.in);
        String tekst = skaner.nextLine().trim();
        if(tekst.isEmpty())
        {
            System.out.println("Podana nazwa jest za krotka, uzyto 'hotel'");
            tekst = "hotel";
        }
        Hotel hotel = new Hotel(tekst);

        Reflections odbicia = new Reflections("hotel.polecenia");
        Set<Class<? extends Polecenie>> klasyPolecen = odbicia.getSubTypesOf(Polecenie.class);
        Mapa<String, Polecenie> obiektyPolecen = new Mapa<>();
        for (Class<? extends Polecenie> klasa : klasyPolecen)
        {
            try
            {
                Polecenie polecenie = klasa.getDeclaredConstructor().newInstance();
                obiektyPolecen.dodaj(polecenie.uzyskajNazwe(), polecenie);
            }
            catch (Exception e)
            {
                System.err.println("Nie można utworzyć instancji klasy: " + klasa.getName());
            }
        }

        //dp - dodaje pokoj, wymaga numeru, liczby miejsc i ceny
        //up - usuwa pokoj, wymaga numeru
        //ip - informacje o pokoju, wymaga numeru
        //lcp - lista cen pokoi
        //lp - lista pokoi
        //zm - melduje gosci, wymaga numeru pokoju, daty meldowania, liczby dni oraz listy gosci
        //wm - wymeldowywuje gosci z pokoju i podaje nalezna oplate, wymaga numeru pokoju
        //z - zapisuje obecny stan hotelu w pliku
        //wyjdz - konczy dzialanie
        System.out.println("Dostepne polecenia:");
        for(String n : obiektyPolecen.klucze)
        {
            System.out.println(obiektyPolecen.znajdz(n).naString());
        }
        System.out.println("\nPolecenie:");

        while (true)
        {
            tekst = skaner.nextLine().trim().toLowerCase();
            if(tekst.isEmpty()) continue;
            Polecenie p = obiektyPolecen.znajdz(tekst);
            if(p == null) System.out.println("Nie znaleziono hotel.polecenia");
            else p.wykonaj(skaner, hotel);
            System.out.println("\nPolecenie:");
        }
    }
}
