
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface ISklep {
    void wyswietl();

    void dodaj(Produkt produkt);

    void usun(int index);

    ArrayList<Produkt> szukaj(String nazwa, String opis);

    void zapisz() throws IOException;

    void wczytaj() throws FileNotFoundException, IOException;


}
