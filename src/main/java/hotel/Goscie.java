package hotel;

import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Goscie
{
    int pokoj;
    LocalDate dataMeldowania;
    int liczbaDni;
    List<String> imiona;

    public LocalDate uzyskajDateMeldowania()
    {
        return dataMeldowania;
    }

    public int uzyskajLiczbeDni()
    {
        return liczbaDni;
    }

    public List<String> uzyskajImiona()
    {
        return imiona;
    }

    /**
     * Konstruktor klasy Goscie
     *
     * @param pokoj - pokoj do ktorego przypisywani sa goscie
     * @param dataMeldowania - data meldowania
     * @param liczbaDni - liczba dni
     * @param imiona - lista imion gosci
     */
    public Goscie(int pokoj, LocalDate dataMeldowania, int liczbaDni, List<String> imiona)
    {
        this.pokoj = pokoj;
        this.dataMeldowania = dataMeldowania;
        this.liczbaDni = liczbaDni;
        this.imiona = imiona;
    }

    @Override
    public String toString()
    {
        String w = "Goscie w pokoju: ";
        StringBuilder bld = new StringBuilder();
        for (String s : imiona) {
            bld.append(s).append(", ");
        }
        w += bld.toString();
        return w + "\nData zameldowania: " + dataMeldowania.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", Data wymeldowania: " + dataMeldowania.plusDays(liczbaDni).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ";";
    }
}
