package model;

import game.Enemy;
import game.Heiltrank;
import game.Inventar;
import game.NrGuessing;
import game.Riese;
import game.Rüstung;
import game.Skeleton;
import game.Spieler;
import game.Spinne;
import game.Waffe;
import game.gewöhnlicheKiste;
import java.util.Arrays;
import java.util.Scanner;



public class Spiel {

    
    
    public static void main(String[] args) {

        
        
        showMenu();
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Willkommen zum Spiel!");
        System.out.println();
        System.out.println("1. Menü");
        System.out.println("2. Spiel starten.");
        System.out.println("3. Spielanleitung.");
        System.out.println("4. Playground");
        System.out.println("5. Beenden");

        int ersteWahl = sc.nextInt();

        switch (ersteWahl) {
            
            case 1: showMenu();
            break;
            case 2: spielStart();
            break;
            case 3: Spielanleitung();
            break;
            case 4: 
            Spieler spieler = new Spieler(null, 10000, 0, null, 0, 0);
            Inventar inventar = new Inventar();
            Enemy enemy = new Enemy(null, 0, 10000, 0, null);
            playground(sc, spieler, enemy);
            optionenFürPlayground();
            break;
            case 5: System.out.println("Vielen Dank fürs Spielen. Bis bald!");
                    System.exit(0);
            break;
            default: System.out.println("Ungültige Eingabe");
            break;
        }

    }

    public static void spielStart() {
        Scanner sc = new Scanner(System.in);

        
        System.out.println();
        System.out.println("Wie lautet dein Name, tapferer Held?");
        System.out.println();

        String name = sc.nextLine();
        System.out.println();

        System.out.println("Sei gegrüßt " + name + "!. Du befindest dich gerade mitten in einem dunklen Wald, vor einem Grubenloch...");
        System.out.println();
        System.out.println("Der böse Kobold Winky hat dir gerade eben noch deine ganzen 14 Goldmünzen gestohlen.");
        System.out.println("und ist damit in die Grube geflüchtet. Du hast keine Wahl außer ihm zu folgen, wenn du dein Gold zurückhaben willst.");
        System.out.println("Als Spieler hast du gewisse Eigenschaften, die dir bei deiner Aufgabe, dein Gold zurückzubekommen helfen können.");
        System.out.println();
        System.out.println("Willst du diese einsehen? Ja oder nein?");

        Spieler spieler = new Spieler(name, 0, 0, "Faust", 10, 0);
        Inventar inventar = new Inventar();
        Enemy enemy = new Enemy(null, 0, 0, 0, null);

        

        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("ja")) {
            System.out.println();
            spieler.print();
            System.out.println();
            inventar.showInventory();
            System.out.println();
            System.out.println("Drücke eine beliebige Taste um fortzufahren:");
            sc.nextLine();

            abenteuer(sc, spieler, enemy, inventar);

        } else if (choice.equalsIgnoreCase("nein")) {
            System.out.println("Dann kann dein Abenteuer losgehen!");
            abenteuer(sc, spieler, enemy, inventar);

        } else {
            System.out.println("Ungültige Eingabe.");
            System.exit(0);
        }
    }



    public static void abenteuer(Scanner sc, Spieler spieler, Enemy enemy, Inventar inventar) {
        
        System.out.println("Du betrittst den Eingang der Grube");
        Waffe rostigesSchwert = new Waffe(15, "rostiges Schwert");
        System.out.println("Auf dem Boden findest du ein rostiges Schwert. Willst du es aufheben und als neue Waffe ausrüsten? Ja oder Nein?");
        System.out.println();

        String auswahl = sc.nextLine();

        if (auswahl.equalsIgnoreCase("ja")) {
            rostigesSchwert.ausrüsten(spieler);
            
            

            System.out.println("Du hast nun das " + spieler.getweapon() + " als deine neue Waffe ausgerüstet.");
            

            
            System.out.println("Du verursachst nun " + spieler.getdamage() + " Schaden");
            System.out.println();

            System.out.println("Wirf einen Blick in dein Inventar, indem du eine beliebige Taste drückst: ");
            sc.nextLine();
            inventar.showInventory();
            System.out.println();

        } else if (auswahl.equalsIgnoreCase("nein")) {
            System.out.println("Du fährst mit deinen Fäusten als einzige Waffe fort...ob das eine gute Entscheidung war?");
        } else {
            System.out.println("Ungültige Eingabe");
            abenteuer(sc, spieler, enemy, inventar);
        }

        System.out.println("Gehe weiter, indem du eine beliebige Taste drückst...");
            sc.nextLine();

        System.out.println("Du gehst tiefer in die Grube...");
        System.out.println();

        Skeleton skeleton = new Skeleton();

        System.out.println("Klapper, Klapper...");
        System.out.println();
        System.out.println("Du triffst auf ein Larry...ein Skelett um genau zu sein. Sie sind die schwächsten Gegner, denen man im Laufe der Reise über den Weg laufen wird. ");
        System.out.println();
        System.out.println("Willst du mehr über Larrys Eigenschaften erfahren? Ja oder Nein?");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("ja")) {
            skeleton.print();
            System.out.println();
            System.out.println("Drücke eine beliebige Taste um fortzufahren:");
            sc.nextLine();
        } else if (choice.equalsIgnoreCase("nein")) {
            System.out.println("Dann kann dein Abenteuer losgehen!");
        } else {
            System.out.println("Ungültige Eingabe.");
            System.exit(0);
        }

        System.out.println("Willst du diesen Larry bekämpfen? Falls du ihn besiegst, wird er dir Hinweise über Winkys Fluchtweg geben.");
        System.out.println("Ja oder Nein?");

        String auswahlLarrybekämpfen = sc.nextLine();

        if (auswahlLarrybekämpfen.equalsIgnoreCase("ja")) {
            
            spieler.fight(spieler, skeleton);

            if (enemy.gethealth() <= 0 && enemy.gethealth() < spieler.gethealth()) {
                System.out.println("Der Larry gibt dir, wie versprochen, die Informationen: ");
                System.out.println();
                skeleton.gebeInformationen1();
                System.out.println("Was tust du? Die Leiter nehmen (1). Dem Grubenpfad folgen (2)");

                int auswahlLeiterOderPfad = sc.nextInt();

                switch (auswahlLeiterOderPfad) {
                    case 1:
                        abenteuerLeiter(sc, spieler, enemy, inventar);
                        break;
                    case 2:
                        abenteuerGang(sc, spieler, enemy, inventar);
                        break;
                    default:
                        System.out.println("Ungültige Eingabe");
                        abenteuer(sc, spieler, enemy, inventar);
                        break;
                }
            }

        } else if (auswahlLarrybekämpfen.equalsIgnoreCase("nein")) {
            System.out.println("Du gehst weiter.");
            System.out.println("Du stehst vor einer Leiter. Willst du diese hochklettern (1) oder weiter dem Grubenpfad folgen (2) ?");

            int auswahl2 = sc.nextInt();

            switch (auswahl2) {
                case 1:
                    abenteuerLeiter(sc, spieler, enemy, inventar);
                    break;
                case 2:
                    abenteuerGang(sc, spieler, enemy, inventar);
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
                    abenteuer(sc, spieler, enemy, inventar);
                    break;
            }

        } else {
            System.out.println("Ungültige Eingabe");
            abenteuer(sc, spieler, enemy, inventar);
        }
    }

    public static void Spielanleitung() {
        
            
            System.out.println("========== SPIELANLEITUNG ==========");
            System.out.println("Willkommen, tapferer Held! Dein Ziel ist es, dein gestohlenes Gold zurückzuholen.");
            System.out.println("Dazu musst du gefährliche Gegner besiegen und wertvolle Gegenstände sammeln.");
            System.out.println();
            System.out.println("### STEUERUNG ###");
            System.out.println("- Du triffst Entscheidungen durch Eingabe von 'Ja' oder 'Nein' oder Zahlen.");
            System.out.println("- Kämpfe gegen Gegner, um Hinweise und Beute zu erhalten.");
            System.out.println("- Nutze Heiltränke, um deine Lebenspunkte zu regenerieren.");
            System.out.println();
            System.out.println("### KÄMPFE ###");
            System.out.println("- Du kämpfst rundenbasiert gegen Feinde.");
            System.out.println("- Deine Waffe bestimmt deinen Schaden.");
            System.out.println("- Besiege Gegner, um neue Wege zu entdecken.");
            System.out.println();
            System.out.println("Viel Erfolg auf deiner Reise!");
            System.out.println("=====================================");
        }

        public static void playground(Scanner sc, Spieler spieler, Enemy enemy) {
        String[] waffen = {"1.Feuerklinge", "2.Frostaxt", "3.BlutKlinge", "4.mythisches Diamantschwert", "5.Admin-Schwert" };
        System.out.println("System.out.println(\"========== PLAYGROUND ==========\");");
        System.out.println();
        System.out.println("Wähle deine Ausrüstung");
        System.out.println("Waffen: " + Arrays.toString(waffen));
        int auswahl = sc.nextInt();
        
        switch (auswahl) {  // Umwandeln in Kleinbuchstaben
            case 1:
            Waffe Feuerklinge = new Waffe(150, "Feuerklinge");
            Feuerklinge.ausrüsten(spieler);
                break;
            case 2:
            Waffe Frostaxt = new Waffe(150, "Frostaxt");
            Frostaxt.ausrüsten(spieler);
                break;
            case 3:
            Waffe Blutklinge = new Waffe(200, "Blutklinge");
            Blutklinge.ausrüsten(spieler);
                break;
            case 4:
            Waffe Diamantenschwert = new Waffe(500, "Diamantenschwert");
            Diamantenschwert.ausrüsten(spieler);
                break;
            case 5:
            Waffe Adminschwert = new Waffe(enemy.gethealth(), "Adminschwert");
            Adminschwert.ausrüsten(spieler);
                break;
            default:
            
                System.out.println("Unbekannte Waffe! Wähle eine gültige Waffe.");
                break;
        }

        String[] rüstung = {"1.Holzrüstung", "2.nerfer", "3.Titanenrüstung", "4.Umhang der Unsterblichkeit"};
        System.out.println();
        System.out.println("Wähle deine Ausrüstung");
        System.out.println("Rüstungen: " + Arrays.toString(rüstung));
        int auswahl1 = sc.nextInt();
        
        switch (auswahl1) {  // Umwandeln in Kleinbuchstaben
            case 1:
            Rüstung Holzrüstung = new Rüstung(20, "Holzrüstung");
            Holzrüstung.rüstungAufsetzen(spieler);
                break;
            case 2:
            Rüstung Nerfer = new Rüstung(0, "Nerfer");
            Nerfer.rüstungAufsetzen(spieler);
                break;
            case 3:
            Rüstung Titanenrüstung = new Rüstung(500, "Titanenrüstung");
            Titanenrüstung.rüstungAufsetzen(spieler);
                break;
            case 4:
            Rüstung UmhangDerUnsterblichkeit = new Rüstung(10000, "UmhangDerUnsterblichkeit");
            UmhangDerUnsterblichkeit.rüstungAufsetzen(spieler);
                break;
            default:
                System.out.println("Unbekannte Rüstung! Wähle eine gültige Rüstung.");
                break;
        }

      System.out.println("Wähle deinen Gegner aus: ");
      System.out.println("1. Golem ");
      System.out.println("2. Trainingsdummy");
      System.out.println("3. Riese");
      System.out.println("4. Spinne");
      System.out.println("5. Larry");
      System.out.println("6. gebuffter Larry");

      int auswahl3 = sc.nextInt();

      switch (auswahl3) {  // Umwandeln in Kleinbuchstaben
        case 1:
        Enemy golem = new Enemy("Golem", 50, 1000, 0, null);
        spieler.fight(spieler, golem);
            break;
        case 2:
        Enemy trainingsdummy = new Enemy("Trainingsdummy", 0, 20000, 0, null);
        spieler.fight(spieler, trainingsdummy);
        break;
        case 3:
        Riese riese = new Riese();
        spieler.fight(spieler, riese);
            break;
        case 4:
        Spinne spinne = new Spinne();
        spieler.fight(spieler, spinne);
            break;
        case 5:
        Skeleton larry = new Skeleton();
        spieler.fight(spieler, larry);
        break;
        case 6:
        Enemy gebuffterLarry = new Enemy("gebuffterLarry", 1000, 5000, 0, null);
        spieler.fight(spieler, gebuffterLarry);
            break;
        default:
            System.out.println("Unbekannter Gegner! Wähle einen gültigen Gegner.");
            break;
    }


      

        
    }


    
        public static void optionenFürPlayground() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Verlassen");
        System.out.println();
        System.out.println("2. Weiter");
        int auswahl = sc.nextInt();
        if (auswahl == 1) {
            showMenu();
        } else if (auswahl == 2) {
            playground(sc, null, null);
        }
}


        public static void abenteuerGang(Scanner sc, Spieler spieler, Enemy enemy, Inventar inventar) {
        
            Spinne spinne = new Spinne();
            
            System.out.println("Der Gang ist dunkel und überall wimmelt es von Spinnennetzen.");
            System.out.println("Vor dir eröffnen sich 8 gelbe Augen...");
            System.out.println();
            
            spieler.fight(spieler, spinne);
            System.exit(0);
        }
        
    

    public static void abenteuerLeiter(Scanner sc, Spieler spieler, Enemy enemy, Inventar inventar) {
        Heiltrank gewöhnlicherHeiltrank = new Heiltrank(5, false);

        

        System.out.println();
        System.out.println("Du findest einen gewöhnlichen Heiltrank! Dieser heilt dein Leben um 5. Hebe ihn auf, indem du eine beliebige Taste drückst: ");
        sc.nextLine();
        Inventar.addItem("gewöhnlicher Heiltrank");

        System.out.println("Der Heiltrank wurde deinem Inventar hinzugefügt!");
        inventar.showInventory();

        System.out.println("Drücke eine beliebige Taste, um den Heiltrank zu nutzen.");
        sc.nextLine();

        gewöhnlicherHeiltrank.trinken(spieler, false);
        inventar.removeItem(1);
        //wenn ich schwert nicht aufnehem funktioniert das nicht mehr
        System.out.println("Sobald du Verbrauchsgegenstände nutzt werden sie aus deinem Inventar genommen.");
        sc.nextLine();
        inventar.showInventory();

        System.out.println("Dein Leben: " + spieler.gethealth());

        System.out.println("Du findest eine alte mit spinnennetzen bedeckte Kiste.");
        System.out.println("Drücke eine beliebige Taste um sie zu öffnen");
        sc.nextLine();
        System.out.println("Oh nein! Die Kiste scheint magisch versiegelt zu sein.");
        System.out.println("Wenn du das folgende Zahlenraten Spiel gewinnst, wird sich die Kist öffnen. Andernfalls verlierst du 5 Leben.");
        System.out.println("Du darfst das Spiel jedoch so oft du möchtest wiederholen, solange es dir dein Leben erlaubt.");

        NrGuessing spiel = new NrGuessing(false);
        gewöhnlicheKiste gewöhnlicheKiste = new gewöhnlicheKiste();
        spiel.start(spieler);

        if(spiel.isWon()) {
            gewöhnlicheKiste.öffneKiste();
        }
        

        
        System.out.println();

        inventar.showInventory();

       
        

        
        

        



        

        







    }

    
//fackel
   
}
