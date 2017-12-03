/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class WesternJava {

      static ArrayList<ArrayList<ArrayList<Humain>>> list = new ArrayList();

      public static void printList(ArrayList<ArrayList<Humain>> list) {

            for (int n = 0; n < list.size(); n++) {
                  for (int i = 0; i < list.get(n).size(); i++) {
                        System.out.println(n + "" + i + " " + list.get(n).get(i).name);
                  }
            }
      }

      public static void displayPerso(int c) {
            for (int n = 0; n < list.get(c).size(); n++) {
                  for (int i = 0; i < list.get(c).get(n).size(); i++) {
                        Humain man = list.get(c).get(n).get(i);
                        System.out.println("\n" + n + "" + i + " " + man.name);
                        System.out.println("Boisson favorite: " + man.favoriteDrink);

                        if (man instanceof Lady) {
                              Lady personnage = (Lady) man;
                              System.out.println("Couleur de culotte: " + personnage.pantieColor);
                              System.out.println("Classe: " + personnage.getClass());
                        }

                        if (man instanceof Cowboy) {
                              Cowboy personnage = (Cowboy) man;
                              System.out.println("Popularité: " + personnage.popularity);
                              System.out.println("Classe: " + personnage.getClass());
                        }

                        if (man instanceof Thug) {
                              Thug personnage = (Thug) man;
                              System.out.println("Alure: " + personnage.look);
                              System.out.println("Classe: " + personnage.getClass());
                        }

                        if (man instanceof Indian) {
                              Indian personnage = (Indian) man;
                              System.out.println("Totem: " + personnage.totem);
                              System.out.println("Classe: " + personnage.getClass());
                        }

                  }
            }
      }

      /**
       * @param args the command line arguments
       * @throws java.io.IOException
       */
      public static void main(String[] args) throws IOException {

            Choice choice = new Choice();

            FileReader in = new FileReader("initialisation.txt");
            int c;
            while ((c = in.read()) != 59) {
                  System.out.print(c + " ");
            }

            //FileWriter out = new FileWriter("C:\\java\\hello");
            //Creation lieux
            ArrayList<Humain> bar_people = new ArrayList();
            ArrayList<Humain> street_people = new ArrayList();
            ArrayList<Humain> jail_people = new ArrayList();

            MainStreet street = new MainStreet("Oak Street", street_people);

            Barman pierre = new Barman("Pierre", "eau", street);
            Bar saloon = new Bar(false, street, pierre, "Saloon", bar_people);

            Jail prison = new Jail(street, "prison", jail_people);
            Lieux[] lieux = {saloon, prison};

            saloon.opening();

            ArrayList<ArrayList<Humain>> ladylist = new ArrayList();
            ArrayList<Humain> simpleladylist = new ArrayList();
            ladylist.add(simpleladylist);
            ArrayList<Humain> thugladylist = new ArrayList();
            ladylist.add(thugladylist);

            ArrayList<ArrayList<Humain>> cowboylist = new ArrayList();
            ArrayList<Humain> simplecowboylist = new ArrayList();
            cowboylist.add(simplecowboylist);
            ArrayList<Humain> sheriflist = new ArrayList();
            cowboylist.add(sheriflist);
            ArrayList<Humain> badcoplist = new ArrayList();
            cowboylist.add(badcoplist);

            ArrayList<ArrayList<Humain>> thuglist = new ArrayList();
            ArrayList<Humain> simplethuglist = new ArrayList();
            thuglist.add(simplethuglist);

            ArrayList<ArrayList<Humain>> indianlist = new ArrayList();
            ArrayList<Humain> simpleindianlist = new ArrayList();
            indianlist.add(simpleindianlist);

            ArrayList<ArrayList<Humain>> barmanlist = new ArrayList();
            ArrayList<Humain> simplebarmanlist = new ArrayList();
            barmanlist.add(simplebarmanlist);

            Sherif john = new Sherif(3, 5, "rapide", 0, "John", "whiskey", saloon);
            sheriflist.add(john);

            Thug nick = new Thug(0, 0, "menaçant", false, "Nick", "rhum", street);
            simplethuglist.add(nick);

            Lady louise = new Lady(false, "noire", "Louise", "vodka", saloon);
            Lady marie = new Lady(false, "rose", "Marie", "rhum", street);
            ThugLady rose = new ThugLady(1, 100, "terrible", false, false,
                     "violet", "Rose", "eau de prune", street);
            simpleladylist.add(louise);
            simpleladylist.add(marie);
            thugladylist.add(rose);

            Cowboy james = new Cowboy(4, "celèbre", 200, "James", "scotch", saloon);
            simplecowboylist.add(james);

            Indian gary = new Indian(12, "l'aigle", "Gary", "eau de source", saloon);
            simpleindianlist.add(gary);

            BadCop eden = new BadCop(0, 0, "chauve", false, 2, "franc", 0, "Eden",
                     "whiskey", saloon);
            badcoplist.add(eden);

            list.add(ladylist);
            list.add(cowboylist);
            list.add(thuglist);
            list.add(indianlist);
            list.add(barmanlist);

            choice.mode(list, lieux);
      }

}
