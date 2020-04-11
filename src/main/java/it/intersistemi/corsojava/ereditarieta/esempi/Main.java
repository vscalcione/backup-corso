package it.intersistemi.corsojava.ereditarieta.esempi;

public class Main {

    public static void main(String[] args) {


        Base b1 = new Base();

        stampaBase(b1);

        Base b2 = new Derivata();

        stampaBase(b2);


        stampaBase(new Derivata());
    }

    private static void stampaBase(Base b) {


        if (b instanceof Derivata) {
            Derivata d = (Derivata) b; // non posso farlo senza cast. conviene controllare con istance of
            d.eseguiAzione();
        } else {
            System.out.println(b);

        }
    }
}
