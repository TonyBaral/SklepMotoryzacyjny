import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sklep implements ISklep {
    private String nazwa;
    private String adres;
    private ArrayList<Produkt> listProduktow;

    public Sklep() {
        this.listProduktow = new ArrayList<>();
        this.nazwa = "Domyślna";
        this.adres = "Domyślny";
    }

    public Sklep(String nazwa, String adres, int liczbaProdktow) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.listProduktow = new ArrayList<>();
        for(int i=0; i<liczbaProdktow; i++){
            this.listProduktow.add(new Produkt());
        }

    }

    @Override
    public void wyswietl() {
        String wiadomosc = "Sklep "+this.nazwa+", adres: "+this.adres+":";
        System.out.println(wiadomosc);
        for (Produkt produkt : this.listProduktow) {
            produkt.info();
        }
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void dodaj(Produkt produkt) {
        this.listProduktow.add(produkt);
    }

    @Override
    public void usun(int index) {
        this.listProduktow.remove(index);
    }

    @Override
    public ArrayList<Produkt> szukaj(String nazwa, String opis) {
        Stream<Produkt> collection = this.listProduktow.stream();
        if(nazwa!=null && nazwa!="")
        {
            collection = collection.filter((Produkt -> Produkt.getNazwaProd().contains(nazwa)));
        }
        if(opis!=null && opis!="")
        {
            collection = collection.filter((Produkt -> Produkt.getOpis().contains(opis)));
        }
        List<Produkt> list = collection.collect(Collectors.toList());
        return new ArrayList<Produkt>(list);
    }

    @Override
    public void zapisz() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("sklep.txt"));
        writer.append(nazwa);
        writer.append('\n');
        writer.append(adres);
        writer.append('\n');
        writer.append(String.valueOf(this.listProduktow.size()));
        writer.append('\n');
        for (Produkt Produkt : this.listProduktow){
            writer.append(Produkt.getOpis());
            writer.append('\n');
            writer.append(Produkt.getNazwaProd());
            writer.append('\n');
            writer.append(String.valueOf(Produkt.getCena()));
            writer.append('\n');

        }
        writer.close();
    }

    @Override
    public void wczytaj() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("sklep.txt"));
        String st;
        int i = 0;
        this.setlistProduktow(new ArrayList<>());
        Produkt temp = new Produkt();
        while((st=br.readLine())!=null) {
            if(i==0) {
                this.setNazwa(st);
            }
            if(i==1) {
                this.setAdres(st);
            }
            if(i>2) {
                if((i-3)%6==0){
                    temp = new Produkt();
                    temp.setOpis(st);
                }
                if((i-3)%6==1){
                    temp.setNazwaProd(st);
                }
                if((i-3)%6==2){
                    temp.setCena(Float.parseFloat(st));
                }
            }
            i++;
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ArrayList<Produkt> getlistProduktow() {
        return listProduktow;
    }

    public void setlistProduktow(ArrayList<Produkt> listProduktow) {
        this.listProduktow = listProduktow;
    }
}