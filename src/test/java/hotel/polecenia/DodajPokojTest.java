package hotel.polecenia;

import hotel.Hotel;
import hotel.Pokoj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DodajPokojTest {

    private Hotel hotel;
    private DodajPokoj dodajPokoj;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("TestowyHotel");
        dodajPokoj = new DodajPokoj();
    }

    @Test
    void testDodajNowyPokoj() {
        String daneWejscia = "101\n2\n150\n";
        Scanner skaner = new Scanner(daneWejscia);

        dodajPokoj.wykonaj(skaner, hotel);

        Pokoj pokoj = hotel.uzyskajPokoje().znajdz(101);
        assertNotNull(pokoj, "Pokój o numerze 101 powinien zostać dodany.");
        assertEquals(2, pokoj.uzyskajMiejsca(), "Pokój powinien mieć 2 miejsca.");
        assertEquals(150, pokoj.uzyskajCene(), "Pokój powinien mieć cenę 150.");
    }

    @Test
    void testDodajPokojGdyNumerIstnieje() {
        String daneWejscia = "101\n2\n150\n101\n3\n200\n";
        Scanner skaner = new Scanner(daneWejscia);

        dodajPokoj.wykonaj(skaner, hotel);

        dodajPokoj.wykonaj(skaner, hotel);

        Pokoj pokoj = hotel.uzyskajPokoje().znajdz(101);
        assertNotNull(pokoj, "Pokój o numerze 101 powinien istnieć.");
        assertEquals(2, pokoj.uzyskajMiejsca(), "Pierwsze dane powinny pozostać bez zmian.");
        assertEquals(150, pokoj.uzyskajCene(), "Pierwsza cena powinna pozostać bez zmian.");
    }

    @Test
    void testDodajPokojZNieprawidlowymiDanymi() {
        String daneWejscia = "abc\n";
        Scanner skaner = new Scanner(daneWejscia);

        assertThrows(java.util.InputMismatchException.class, () -> dodajPokoj.wykonaj(skaner, hotel),
                "Powinno zostać zgłoszone wyjątek przy błędnym wejściu (nie liczba).");
    }

    @Test
    void testOpisIPolecenie() {
        assertEquals("dp", dodajPokoj.nazwa, "Nazwa polecenia powinna być 'dp'.");
        assertEquals("dodaje pokoj, wymaga numeru, liczby miejsc i ceny", dodajPokoj.opis,
                "Opis polecenia powinien być zgodny z oczekiwaniami.");
    }
}
