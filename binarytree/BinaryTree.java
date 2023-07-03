package binarytree;

class Dugum {

    int icerik;
    Dugum sol, sag;

    public Dugum(int icerik) {
        this.icerik = icerik;
        sag = null;
        sol = null;
    }
}

public class BinaryTree {
    Dugum kok;

    public BinaryTree() {
        kok = null;
    }

    boolean bosMu() {
        return kok == null;
    }

    void agacaEkle(Dugum yeni) {
        Dugum once = null, tmp = kok;
        if (!bosMu()) {
            while (tmp != null) {
                once = tmp;
                if (yeni.icerik == tmp.icerik) {
                    System.out.println(yeni.icerik+" Elemanı Ağaçta mevcuttur");
                    return;
                } else if (yeni.icerik < tmp.icerik) {
                    tmp = tmp.sol;
                } else {
                    tmp = tmp.sag;
                }
            }
            if (yeni.icerik < once.icerik) {
                once.sol = yeni;
            } else {
                once.sag = yeni;
            }
        } else {
            kok = yeni;
        }
    }

    int arama(int eleman) {
        Dugum tmp = kok;
        if (!bosMu()) {
            while (tmp != null) {
                if (tmp.icerik == eleman) {
                    return tmp.icerik;
                } else if (eleman < tmp.icerik) {
                    tmp = tmp.sol;
                } else {
                    tmp = tmp.sag;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.agacaEkle(new Dugum(12));
        b.agacaEkle(new Dugum(1));
        b.agacaEkle(new Dugum(8));
        b.agacaEkle(new Dugum(2));
        b.agacaEkle(new Dugum(9));
        b.agacaEkle(new Dugum(3));
        if(b.arama(8) != -1){
        System.out.println("Aranan "+b.arama(8)+" Elemanı Ağaçta mevcuttur");
        }
    }
}
