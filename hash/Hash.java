package hash;

public class Hash {

    int maxBoyut, elemanSayisi;
    int[] keys, values;

    public Hash(int maxBoyut) {
        this.maxBoyut = maxBoyut;
        keys = new int[maxBoyut];
        values = new int[maxBoyut];
        elemanSayisi = 0;
        diziDeger();
    }

    private void diziDeger() {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = -1;
        }
    }

    boolean bosMu() {
        return elemanSayisi == 0;
    }

    boolean doluMu() {
        return elemanSayisi == maxBoyut;
    }

    int hash(int x) {
        return x % maxBoyut; //basit bir hash fonksiyonu
    }

    void ekle(int k, int v) {
        int i = hash(k);
        if (keys[i] == -1) {
            keys[i] = k; 
            values[i] = v;
            elemanSayisi++;
        }
    }

    int get(int k) {
        int i = hash(k);
        if (keys[i] != k) {
            System.out.println("Eleman Bulunamadı :( ");
            return -1;
        } else {
            return values[i];
        }
    }

    public static void main(String[] args) {
        Hash h = new Hash(50);
        h.diziDeger();
        h.ekle(25, 37004338);
        h.ekle(53, 87451);
        h.ekle(4, 45523);
        System.out.println(h.get(25));
        System.out.println(h.get(6));
    }

}
