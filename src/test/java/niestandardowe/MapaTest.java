package niestandardowe;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {

    @Test
    void testDodaj() {
        Mapa<String, Integer> mapa = new Mapa<>();
        mapa.dodaj("klucz1", 10);
        assertEquals(1, mapa.liczba(), "Mapa powinna zawierać jeden element.");
        assertEquals(10, mapa.znajdz("klucz1"), "Wartość dla 'klucz1' powinna być 10.");
    }

    @Test
    void testZnajdz() {
        Mapa<String, String> mapa = new Mapa<>();
        mapa.dodaj("kluczA", "wartoscA");
        mapa.dodaj("kluczB", "wartoscB");

        assertEquals("wartoscA", mapa.znajdz("kluczA"), "Powinna zwrócić 'wartoscA' dla 'kluczA'.");
        assertEquals("wartoscB", mapa.znajdz("kluczB"), "Powinna zwrócić 'wartoscB' dla 'kluczB'.");
        assertNull(mapa.znajdz("nieIstnieje"), "Dla nieistniejącego klucza wynik powinien być null.");
    }

    @Test
    void testUsun() {
        Mapa<Integer, String> mapa = new Mapa<>();
        mapa.dodaj(1, "jeden");
        mapa.dodaj(2, "dwa");

        String usunietaWartosc = mapa.usun(1);
        assertEquals("jeden", usunietaWartosc, "Powinna zwrócić 'jeden' dla klucza 1.");
        assertNull(mapa.znajdz(1), "Po usunięciu klucza 1, wynik dla 'znajdz' powinien być null.");
        assertEquals(1, mapa.liczba(), "Po usunięciu liczba elementów powinna wynosić 1.");
    }

    @Test
    void testKlucze() {
        Mapa<String, Double> mapa = new Mapa<>();
        mapa.dodaj("klucz1", 1.1);
        mapa.dodaj("klucz2", 2.2);

        List<String> klucze = mapa.klucze();
        assertTrue(klucze.contains("klucz1"), "Lista kluczy powinna zawierać 'klucz1'.");
        assertTrue(klucze.contains("klucz2"), "Lista kluczy powinna zawierać 'klucz2'.");
        assertEquals(2, klucze.size(), "Liczba kluczy powinna wynosić 2.");
    }

    @Test
    void testLiczba() {
        Mapa<String, String> mapa = new Mapa<>();
        assertEquals(0, mapa.liczba(), "Początkowo mapa powinna być pusta.");

        mapa.dodaj("klucz1", "wartosc1");
        mapa.dodaj("klucz2", "wartosc2");
        assertEquals(2, mapa.liczba(), "Mapa powinna zawierać dwa elementy.");

        mapa.usun("klucz1");
        assertEquals(1, mapa.liczba(), "Po usunięciu elementu liczba elementów powinna wynosić 1.");
    }

    @Test
    void testZnajdzNieIstniejacyKlucz() {
        Mapa<String, Integer> mapa = new Mapa<>();
        mapa.dodaj("A", 1);
        mapa.dodaj("B", 2);

        // Przypadek: klucz nie istnieje
        assertNull(mapa.znajdz("C"), "Oczekiwano null dla nieistniejącego klucza");
    }

    @Test
    void testUsunNieIstniejacyKlucz() {
        Mapa<String, Integer> mapa = new Mapa<>();
        mapa.dodaj("A", 1);
        mapa.dodaj("B", 2);

        // Przypadek: próba usunięcia klucza, który nie istnieje
        assertNull(mapa.usun("C"), "Oczekiwano null dla próby usunięcia nieistniejącego klucza");
    }
}
