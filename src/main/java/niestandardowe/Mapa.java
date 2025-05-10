package niestandardowe;

import java.util.ArrayList;
import java.util.List;


public class Mapa <K, W>
{
    List<K> klucze;
    List<W> wartosci;

    /**
     * Konstruktor klasy Mapa
     *
     */
    public Mapa()
    {
        klucze = new ArrayList<>();
        wartosci = new ArrayList<>();
    }

    /**
     * Dodaje wartosc do mapy
     *
     * @param klucz - klucz
     * @param wartosc - wartosc
     */
    public void dodaj(K klucz, W wartosc)
    {
        klucze.add(klucz);
        wartosci.add(wartosc);
    }

    /**
     * Znajduje wartosc w mapie po kluczu
     *
     * @param klucz - klucz
     * @return zwraca znaleziona warotsc lub null
     */
    public W znajdz(K klucz)
    {
        for (int i = 0; i < klucze.size(); i++)
        {
            if(klucze.get(i).equals(klucz)) return wartosci.get(i);
        }
        return null;
    }

    /**
     * Usuwa przedmiot z mapy
     *
     * @param klucz - klucz
     * @return zwraca usunieta warotsc lub null
     */
    public W usun(K klucz)
    {
        for (int i = 0; i < klucze.size(); i++)
        {
            if(klucze.get(i).equals(klucz))
            {
                klucze.remove(i);
                return wartosci.remove(i);
            }
        }
        return null;
    }

    /**
     * Klucze mapy
     *
     * @return zwraca liste kluczy
     */
    public List<K> klucze()
    {
        return klucze;
    }

    /**
     * Liczba kluczy mapy
     *
     * @return zwraca liczbe kluczy mapy
     */
    public int liczba()
    {
        return klucze.size();
    }
}