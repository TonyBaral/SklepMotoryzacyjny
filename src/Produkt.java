public class Produkt {
    private String nazwaProd;
    private String opis;
    private float cena;

    public Produkt(String nazwaProd, String opis, float cena) {
        this.nazwaProd = nazwaProd;
        this.opis = opis;
        this.cena = cena;
    }

    public String getNazwaProd() {
        return nazwaProd;
    }

    public void setNazwaProd(String nazwaProd) {
        this.nazwaProd = nazwaProd;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    public  Produkt(){
        this.nazwaProd = "Domyślna";
        this.opis = "Domyślna";
        this.cena = 0;

    }
    public void info() {
        String wiadomosc = "Produkt{" +
                "nazwa='" + nazwaProd + '\'' +
                ", opis='" + opis + '\'' +
                ", cena=" + cena +
                '}';
        System.out.println(wiadomosc);
    }
    public Produkt(String nazwa, String opis, Float cena) {
        this.nazwaProd = nazwa;
        this.opis = opis;
        this.cena = cena;
    }

}
