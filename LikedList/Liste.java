package bagliliste;

class Ogrenci {

    int not;
    String ogrNo;
    String isim;
    Ogrenci ileri;

    public Ogrenci(int not, String isim, String ogrNO) {
        this.not = not;
        this.isim = isim;
        this.ogrNo = ogrNO;
        ileri = null;
    }

}

public class Liste {

    Ogrenci bas, son;

    public Liste() { //Listenin başı ve sonu null olarak tanımla
        bas = null;
        son = null;
    }

    void ogrEkle(Ogrenci yeni) { //Listenin başına ekleme metodu
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            yeni.ileri = bas;
            bas = yeni;
        }
    }

    String notDuzeltme(Ogrenci o) {
        Ogrenci tmp = bas;

        while (tmp != null) { //tmp değişkeni null olana kadar ilerletilecektir
            if (tmp.ogrNo.equals(o.ogrNo)) {
                tmp.not = o.not;
                return "Öğrenci Notu Başarıyla Düzeltilmiştir";
            }
            tmp = tmp.ileri; //ilerletmek için tmp'in ilerisi tmp olarak tanımlamak
        }
        return "Öğrenci Bulunamadı";
    }

    int notSorgulama(String x) {
        Ogrenci tmp = bas;

        while (tmp != null) {
            if(tmp.ogrNo.equals(x)){
                return tmp.not;
        }
            tmp = tmp.ileri;
        }
        return 0;
    }

    int ogrSayisi() {
        Ogrenci tmp = bas;
        int sayac = 0;

        while (tmp != null) {
            sayac++;
            tmp = tmp.ileri;
        }
        return sayac;
    }

    double ogrNotOrt() {
        Ogrenci tmp = bas;
        int toplam = 0;

        while (tmp != null) {
            toplam += tmp.not;
            tmp = tmp.ileri;
        }
        return toplam / (double) ogrSayisi();
    }

    int sinavGecme() {
        Ogrenci tmp = bas;
        int gecenler = 0;

        while (tmp != null) {
            if (tmp.not >= 50) {
                gecenler++;
            }
            tmp = tmp.ileri;
        }
        return gecenler;
    }

    int sinavKalma() {
        Ogrenci tmp = bas;
        int kalanlar = 0;

        while (tmp != null) {
            if (tmp.not < 50) {
                kalanlar++;
            }
            tmp = tmp.ileri;
        }
        return kalanlar;
    }

    String enYuksekNot() {
        Ogrenci tmp = bas.ileri;
        int enb = bas.not;
        String name = "";

        while (tmp != null) {
            if (tmp.not > enb) {
                enb = tmp.not;
                name = tmp.isim;
            }
            tmp = tmp.ileri;
        }
        return name;
    }

    void bastanSil() {
        bas = bas.ileri;
        if (bas == null) {
            son = null;
        }
    }

    void sondanSil() {
        Ogrenci tmp = bas;
        Ogrenci once = null;

        while (tmp != son) {
            once = tmp;
            tmp = tmp.ileri;
        }
        if (once == null) {
            bas = null;
        } else {
            once.ileri = null;
            son = once;
        }
    }

    void listedenSil(Ogrenci ogr) {
        Ogrenci once;
        Ogrenci tmp;

        if (ogr.ogrNo.equals(bas.ogrNo)) {
            bastanSil();
        } else if (ogr.ogrNo.equals(son.ogrNo)) {
            sondanSil();
        } else {
            tmp = bas;
            once = null;
            while (tmp != ogr) {
                once = tmp;
                tmp = tmp.ileri;
            }
            once.ileri = tmp.ileri;
        }
    }

    String report(){
        return "Sınava giren öğrenci sayısı : "+ogrSayisi()+"\n"+
               "Sınavdan geçen öğrenci sayısı : "+sinavGecme()+"\n"+
               "Sınavdan kalan öğrenci sayısı : "+sinavKalma()+"\n"+
               "Sınıf ortalaması : "+ogrNotOrt()+"\n"+
               "Sınavda en yüksek not alan Öğrenci ismi"+enYuksekNot();
                
    }
}
