package hotel;

public class Pokoj
{
    int numer;
    int miejsca;
    int cena;
    Goscie goscie;

    public int uzyskajNumer()
    {
        return numer;
    }

    public int uzyskajMiejsca()
    {
        return miejsca;
    }

    public int uzyskajCene()
    {
        return cena;
    }

    public void ustawGosci(Goscie goscie)
    {
        this.goscie = goscie;
    }

    public Goscie uzyskajGosci()
    {
        return goscie;
    }

    /**
     * Konstruktor klasy Pokoj
     *
     * @param numer - numer pokoju
     * @param miejsca - dostepne miejsca
     * @param cena - cena za dzien
     */
    public Pokoj(int numer, int miejsca, int cena)
    {
        this.numer = numer;
        this.miejsca = miejsca;
        this.cena = cena;
        this.goscie = null;
    }

    @Override
    public String toString()
    {
        if (goscie != null) return "Pokoj " + numer + ": Miejsca: " + goscie.imiona.size() + "/" + miejsca + ", Cena: " + cena + " zl,\n" + goscie;
        return "Pokoj " + numer + ": Miejsca: 0/" + miejsca + ", Cena: " + cena + " zl;";
    }
}
