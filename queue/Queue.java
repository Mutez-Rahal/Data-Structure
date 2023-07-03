package queue;

class Eleman {

    int icerik;

    public Eleman(int icerik) {
        this.icerik = icerik;
    }

}

public class Queue {

    Eleman dizi[];
    int son;
    int elemanSay;
    int boyut;

    public Queue(int boyut) {
        this.boyut = boyut;
        dizi = new Eleman[boyut];
        son = -1;
        elemanSay = 0;
    }

    boolean kuyrukBosMu() {
        return son == -1;
    }

    boolean kuyrukDoluMu() {
        return son == boyut - 1;
    }

    void enqueue(Eleman e) {
        if (!kuyrukDoluMu()) {
            son++;
            dizi[son] = e;
            elemanSay++;
        } else {
            System.out.println("Kuyruk Dolu");
        }
    }

    Eleman dequeue() {
        Eleman sonuc = null;
        if (!kuyrukBosMu()) {
            sonuc = dizi[0];
            for (int i = 1; i <= son; i++) {
                dizi[i - 1] = dizi[i];
            }
            son--;
            elemanSay--;
            return sonuc;
        } else {
            System.out.println("1");
            return null;
        }
    }

    void show() {
        for (int i = 0; i <= son; i++) {
            System.out.println(dequeue().icerik);
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(10);

        q.enqueue(new Eleman(3));
        q.enqueue(new Eleman(5));
        q.enqueue(new Eleman(9));
        q.enqueue(new Eleman(7));
        q.enqueue(new Eleman(6));
        System.out.println("Eleman Sayısı : "+q.elemanSay);
        q.show();

    }

}
