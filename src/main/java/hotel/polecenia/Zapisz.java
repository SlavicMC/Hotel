package hotel.polecenia;

import hotel.Polecenie;
import hotel.Hotel;
import hotel.Pokoj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Zapisz extends Polecenie
{
    public Zapisz()
    {
        nazwa = "z";
        opis = "zapisuje obecny stan hotelu w pliku";
    }

    /**
     * Polecenie zapisujace obecny stan hotelu do pliku
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public void wykonaj(Scanner skaner, Hotel hotel)
    {
        File plik = new File(hotel.uzyskajNazwe() + ".csv");
        try
        {
            if (!plik.exists())
            {
                boolean wyn = plik.createNewFile();
                if(!wyn)
                {
                    System.out.println("Nie udało się utworzyć pliku zapisu.");
                    return;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Wystapil blad: " + e.getMessage());
            return;
        }
        String w = "Numer,Miejsca,Cena,Data meldowania,Liczba dni,Imiona\n";
        List<Integer> k = new ArrayList<>(hotel.uzyskajPokoje().klucze());
        Collections.sort(k);
        StringBuilder bld = new StringBuilder();
        for(Integer i : k)
        {
            Pokoj p = hotel.uzyskajPokoje().znajdz(i);
            bld.append(p.uzyskajNumer()).append(",").append(p.uzyskajMiejsca()).append(",").append(p.uzyskajCene());
            if(p.uzyskajGosci() != null)
            {
                bld.append(",").append(p.uzyskajGosci().uzyskajDateMeldowania().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).append(",").append(p.uzyskajGosci().uzyskajLiczbeDni()).append(",").append(String.join(",", p.uzyskajGosci().uzyskajImiona()));
            }
            bld.append("\n");
        }
        w += bld;
        try (FileWriter fw = new FileWriter(plik, false))
        {
            fw.write(w);
            System.out.println("Pomyslnie zapisano " + hotel.uzyskajNazwe() + ".csv");
        }
        catch (IOException e)
        {
            System.out.println("Wystapil blad: " + e.getMessage());
        }

    }
}
