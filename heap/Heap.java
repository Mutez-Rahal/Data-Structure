package heap;

class Dugum {

    int icerik;
    int no;

    public Dugum(int icerik) {
        this.icerik = icerik;
    }
}

public class Heap {

    Dugum dizi[];
    int tane; // eleman sayısı

    public Heap(int N) {
        dizi = new Dugum[N];
        tane = -1;
    }

    boolean bosMu() {
        return tane == 0;
    }

    void yerDegistir(int bir, int iki) {
        Dugum tmp = dizi[bir];
        dizi[bir] = dizi[iki];
        dizi[iki] = tmp;
    }

    void insertHeap(Dugum yeni) {
        int i, ustDal;
        tane++;
        dizi[tane] = yeni;
        i = tane;
        while (i > 1) {
            ustDal = (i - 1) / 2;
            if (dizi[ustDal].icerik < dizi[i].icerik) {
                yerDegistir(ustDal, i);
                i = ustDal;
            } else {
                return;
            }
        }
    }

    void deleteHeap(int no) {
        dizi[0] = dizi[tane];
        int altSag, altSol;

        altSag = 2 * no + 2;
        altSol = 2 * no + 1;

        while (altSol < tane && dizi[altSol].icerik > dizi[no].icerik
                || altSag < tane && dizi[no].icerik < dizi[altSag].icerik) {
            System.out.println("---------1----------");
            if (altSag >= tane || dizi[altSag].icerik < dizi[altSol].icerik) {
                yerDegistir(no, altSol);
                no = altSol;
            } else {
                yerDegistir(no, altSag);
                no = altSag;
            }
            altSol = 2 * no + 1;
            altSag = 2 * no + 2;
        }
        tane--;
    }

    void printHeap() {
        for (int i = 0; i <= tane; i++) {
            System.out.print(dizi[i].icerik + " ");
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap(50);
        h.insertHeap(new Dugum(16));
        h.insertHeap(new Dugum(14));
        h.insertHeap(new Dugum(9));
        h.insertHeap(new Dugum(2));
        h.insertHeap(new Dugum(11));
        h.insertHeap(new Dugum(10));
        h.insertHeap(new Dugum(6));
        h.printHeap();
        h.deleteHeap(0);
        h.deleteHeap(0);
        h.deleteHeap(0);

        System.out.println("");
        h.printHeap();

    }
}
