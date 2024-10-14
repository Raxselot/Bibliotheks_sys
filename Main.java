import java.util.ArrayList;

 class Buch {
    String title;
    String autor;
    Integer isbn;
    Boolean verfügbar;


    public Buch(String title, String autor, Integer isbn){
        this.title = title;
        this.autor = autor;
        this.isbn = isbn;
        this.verfügbar = true;
    }

    public void ausleihen() {
        if (verfügbar) {
            verfügbar = false;
            System.out.println("Das Buch " + title + " wurde ausgeliehen.");
        } else {
            System.out.println("Das Buch " + title + " ist bereits ausgeliehen.");
        }
    }

    public void zurückgeben() {
        verfügbar = true;
        System.out.println("Das buch" + title + "wurde Zurückgegeben");
        
    }
}



class Benutzer {
    String name;
    ArrayList<Buch> ausgelieheneBücher;

    public Benutzer(String name){
        this.name = name;
        this.ausgelieheneBücher = new ArrayList<>();
    }


    public  void buchAusleihen(Buch buch) {
        if(buch.verfügbar){
            buch.ausleihen();
            ausgelieheneBücher.add(buch);
        }else{
            System.out.println("Das Buch" + buch + "wurde bereits ausgeliehen");
        }
    }

    public  void buchZurückgeben(Buch buch) {
        if(!buch.verfügbar){
            buch.zurückgeben();
            ausgelieheneBücher.remove(buch);
        }else{
            System.out.println("Buch ist bereits Vorhanden!");
        }
    }

}



class Bibliothek {
    ArrayList<Buch> bucherListe;


    public Bibliothek(String bucherListe) {
        this.bucherListe = new ArrayList<>();
    }    


    public  void buchHinzufügen(Buch buch) {
        bucherListe.add(buch);
        System.out.println("Das Buch: "+ buch.title +" wurde hinzugefügt");
        
    }

    public  void buchAusleihen(Benutzer benutzer, Buch buch) {
        if(bucherListe.contains(buch) && buch.verfügbar){
            benutzer.buchAusleihen(buch);
        }else{
            System.out.println("Das buch: " + buch.title + "Wurde bereits ausgeliehen");
        }
        
    }


    public void buchZurückgeben(Benutzer benutzer, Buch buch){
        benutzer.buchZurückgeben(buch);
    }
}



public class Main{
    public static void main(String[] args) {
    Bibliothek bibliothek = new Bibliothek("Meine Bib");
    
    Buch buch1 = new Buch("How to be a Traitor", "Chris",203213);
    Buch buch2 = new Buch("Der Herr der Ringe", "J.R.R. Tolkien", 654321);
    Buch buch3 = new Buch("Harry Potter", "J.K. Rowling", 123456 );


    bibliothek.buchHinzufügen(buch1);
    bibliothek.buchHinzufügen(buch2);
    bibliothek.buchHinzufügen(buch3);

    Benutzer benutzer = new Benutzer("Max Musettenman");


    bibliothek.buchAusleihen(benutzer, buch3);
    bibliothek.buchAusleihen(benutzer, buch2);

    bibliothek.buchZurückgeben(benutzer, buch3);
}
}
