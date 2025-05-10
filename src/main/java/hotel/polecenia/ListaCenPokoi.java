package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaCenPokoi extends Polecenie
{
    public ListaCenPokoi()
    {
        nazwa = "lcp";
        opis = "lista cen pokoi";
    }

    /**
     * Polecenie wyswietlajace liste cen pokoi
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        List<Integer> k = new ArrayList<>(hotel.uzyskajPokoje().klucze());
        if (k.isEmpty())
        {
            System.out.println("Nie ma pokoi w tym hotelu");
            return;
        }
        Collections.sort(k);
        for(Integer i : k)
        {
            Pokoj p = hotel.uzyskajPokoje().znajdz(i);
            System.out.println("Pokoj " + p.uzyskajNumer() + ": " + p.uzyskajCene() + " zl;");
        }
    }
}
