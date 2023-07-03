package stack;

class Eleman {

    int icerik;

    public Eleman(int icerik) {
        this.icerik = icerik;
    }

}

public class Stack {

    Eleman dizi[];
    int boyut;
    int ust;

    public Stack(int boyut) {
        this.boyut = boyut;
        dizi = new Eleman[this.boyut];
        ust = -1;
    }

    boolean bosMu() {
        return ust == -1;
    }

    boolean doluMu() {
        return ust == boyut - 1;
    }

    void push(Eleman e) {
        if (!doluMu()) {
            ust++;
            dizi[ust] = e;
        }
    }

    Eleman pop() { //stack'ten çıkarma işlem, stack'in başından olur.
        if (!bosMu()) {
            ust--;
            return dizi[ust + 1];
        } else {
            return null;
        }
    }

    int peek() {
        return dizi[ust].icerik;
    }

    //Stack elemanları ekrana yazdıran method.
    void show() {
        System.out.print("Elemanları Stack'tan Çıkarttıktan sonra sırası : ");
        while (!bosMu()) {
            System.out.print(+pop().icerik + " ");
        }
    }

//------------------------------------------------------------------------------
//      --------------bir stackten başka stacke eleman atmak-----------
    void baskaStack() {
        Stack s2 = new Stack(boyut);
        while (!bosMu()) {
            s2.push(pop());
        }
        System.out.println("Yeni Stack Elemanları ...");
        while(!s2.bosMu()){
            System.out.println(s2.pop().icerik);
        }
    }
//------------------------------------------------------------------------------
//      --------------Girilen stringi ters yazan method.----------------
     void tersYaz(String str){
        Stack s3 = new Stack(str.length());
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            s3.push(new Eleman(c[i]));
        }
        
        while(!s3.bosMu()){
            System.out.print(s3.pop().icerik+" ");
        }
    }
//------------------------------------------------------------------------------    
//      ---------------Girilen sayılar sıralayan method---------------
//
    void sirala(int sayi) {
        Stack s2 = new Stack(10);
        while (!bosMu() && peek() < sayi) {
            s2.push(pop());
        }
        push(new Eleman(sayi));
        while (!s2.bosMu()) {
            push(s2.pop());
        }
    }
//------------------------------------------------------------------------------
    public static void main(String[] args) {
        Stack s = new Stack(10);
        System.out.println("Stack' a atanacak elemanlar sırasıyla : 5, 3, 6, 9, 1");
        s.push(new Eleman(5));
        s.push(new Eleman(3));
        s.push(new Eleman(6));
        s.push(new Eleman(9));
        s.push(new Eleman(1));
        s.show();
        System.out.println("\nBunun sebebi ise Stack'in LIFO olması");
    }
}
