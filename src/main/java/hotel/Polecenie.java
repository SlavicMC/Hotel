package hotel;

import java.util.Scanner;

public abstract class Polecenie
{
    protected String nazwa = "";
    protected String opis = "";

    public String uzyskajNazwe()
    {
        return nazwa;
    }

    /**
     * Wykonuje polecenie
     *
     * @param skaner - skaner
     * @param hotel - hotel
     */
    public abstract void wykonaj(Scanner skaner, Hotel hotel);
    public String naString()
    {
        return nazwa + " - " + opis;
    }
}
