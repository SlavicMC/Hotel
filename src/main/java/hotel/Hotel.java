package hotel;

import niestandardowe.Mapa;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hotel
{
    String nazwa;
    Mapa<Integer, Pokoj> pokoje;

    public String uzyskajNazwe()
    {
        return nazwa;
    }

    public Mapa<Integer, Pokoj> uzyskajPokoje()
    {
        return pokoje;
    }

    /**
     * Konstruktor klasy Hotel, znajduje lub tworzy nowy hotel
     *
     * @param nazwa - nazwa szukanego/tworzonego hotelu
     */
    public Hotel(String nazwa)
    {
        this.nazwa = nazwa;
        pokoje = new Mapa<>();
        List<String> linie;
        try
        {
            linie = Files.readAllLines(Paths.get(nazwa + ".csv"));
        }
        catch (IOException e)
        {
            System.out.println("Nie znaleziono pliku o tej nazwie, utworzono pusty hotel");
            return;
        }
        for (int i = 1; i < linie.size(); i++)
        {
            String[] wartosci = linie.get(i).split(",");
            if(wartosci.length < 3)
            {
                System.out.println("Plik jest uszkodzony, wstrzymano dodawanie danych");
                return;
            }
            int numer = Integer.parseInt(wartosci[0]);
            Pokoj p = new Pokoj(numer, Integer.parseInt(wartosci[1]), Integer.parseInt(wartosci[2]));
            if(wartosci.length > 3)
            {
                if (wartosci.length >= 6)
                {
                    List<String> imiona = new ArrayList<>(Arrays.asList(wartosci).subList(5, wartosci.length));
                    p.goscie = new Goscie(numer, LocalDate.parse(wartosci[3], DateTimeFormatter.ofPattern("dd-MM-yyyy")), Integer.parseInt(wartosci[4]), imiona);
                }
                else
                {
                    System.out.println("Plik jest uszkodzony, wstrzymano dodawanie danych");
                    return;
                }
            }
            pokoje.dodaj(p.numer, p);
        }
    }
}
