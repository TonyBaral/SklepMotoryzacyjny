import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Sklep sklep = new Sklep();
        while (true){
            try {
                System.out.println("Sklep:");
                System.out.println("1.Wyświetl");
                System.out.println("2.Dodaj");
                System.out.println("3.Usuń");
                System.out.println("4.Szukaj");
                System.out.println("5.Zapisz");
                System.out.println("6.Wczytaj");
                System.out.println("7.Zmień nazwę sklepu");
                System.out.println("8.Wyjdź");
                System.out.print("Wybierz: ");
                int wybor = Integer.parseInt(br.readLine());
                switch (wybor){
                    case 1:
                        sklep.wyswietl();
                        break;
                    case 2:
                        System.out.print("Nazwa: ");
                        String nazwaProduktu = br.readLine();
                        System.out.print("Opis: ");
                        String opis = br.readLine();
                        System.out.print("Cena: ");
                        Float cena = Float.parseFloat(br.readLine());
                        sklep.dodaj(new Produkt(nazwaProduktu,opis,cena));
                        break;
                    case 3:
                        System.out.print("Podaj indeks: ");
                        int index = Integer.parseInt(br.readLine());
                        sklep.usun(index);
                        break;
                    case 4:
                        System.out.print("nazwa: ");
                        String szukananazwa = br.readLine();
                        System.out.print("opis: ");
                        String szukanyopis = br.readLine();
                        System.out.println("Wyniki wyszukiwania: ");
                        for (Produkt produkt : sklep.szukaj(szukanyopis,szukananazwa)){
                            produkt.info();
                        }
                        break;
                    case 5:
                        sklep.zapisz();
                        System.out.println("Zapisano");
                        break;
                    case 6:
                        sklep.wczytaj();
                        System.out.println("Wczytano");
                        break;
                    case 7:
                        System.out.print("Nazwa sklepu: ");
                        String nazwa = br.readLine();
                        System.out.print("Adres sklepu: ");
                        String adres = br.readLine();
                        sklep.setNazwa(nazwa);
                        sklep.setAdres(adres);
                        break;
                    case 8:
                        System.exit(0);

                }
            }
            catch (Exception ex){
                System.out.println("Coś poszło nie tak...");
            }

        }
    }
}