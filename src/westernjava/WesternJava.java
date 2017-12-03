/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ISEN
 */
public class WesternJava {

      static ArrayList<ArrayList<ArrayList<Humain>>> list = new ArrayList();
      static Choice choice = new Choice();

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

            //Lady louise = new Lady(false, "noire", "Louise", "vodka", saloon);
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

            Thug nick = new Thug(0, 0, "menaçant", false, "Nick", "rhum", street);
            simplethuglist.add(nick);

            Lady marie = new Lady(false, "rose", "Marie", "rhum", street);
            ThugLady rose = new ThugLady(1, 100, "terrible", false, false,
                     "violet", "Rose", "eau de prune", street);
            //simpleladylist.add(louise);
            simpleladylist.add(marie);
            thugladylist.add(rose);

            Cowboy james = new Cowboy(4, "celèbre", 200, "James", "scotch", saloon);
            simplecowboylist.add(james);

            Indian gary = new Indian(12, "l'aigle", "Gary", "eau de source", saloon);
            simpleindianlist.add(gary);

            BadCop eden = new BadCop(0, 0, "chauve", false, 2, "franc", 0, "Eden",
                     "whiskey", saloon);
            badcoplist.add(eden);

            String fileName = "initialisation.txt";
            FileReader in = new FileReader(fileName);

            List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
            int result = lines.size() + 1;
            System.out.println("nombre de ligne" + result);
            int i, c, n;

            String type = "";
            String para = "";
            ArrayList<String> parametre = new ArrayList();

            for (int m = 0; m < result; m++) {
                  
                  while ((c = in.read()) != 44) {
                        
                        String t = Character.toString((char) c);
                        type = type + t;
                  }

                  System.out.println("\ntype " + type);
                  if (type.equals("Lady")) {
                        parametre.clear();
                        for (i = 0; i < 5; i++) {
                              while ((n = in.read()) != 44 && n != 59) {
                                    String p = Character.toString((char) n);
                                    para = para + p;
                              }
                              parametre.add(para);
                              para = "";
                              System.out.println(parametre.get(i));
                        }

                        boolean bo = parametre.get(0).equals("true");
                        Lieux li;
                        if (parametre.get(4).equalsIgnoreCase(lieux[0].name)) {
                              li = lieux[0];
                        } else {
                              li = street;
                        }

                        simpleladylist.add(new Lady(bo, parametre.get(1), parametre.get(2), parametre.get(3), li));
                        type = "";
                  } else if (type.equals("Sherif")) {
                        parametre.clear();
                        for (i = 0; i < 7; i++) {
                              while ((n = in.read()) != 44) {
                                    String p = Character.toString((char) n);
                                    para = para + p;

                              }
                              System.out.println(para);
                              while ((n = in.read()) != 44 && n != 59) {
                                    String p = Character.toString((char) n);
                                    para = para + p;
                                    System.out.println(para);
                              }
                              parametre.add(para);
                              para = "";
                              System.out.println(parametre.get(i));
                        }

                        Lieux li;
                        if (parametre.get(6).equalsIgnoreCase(lieux[0].name)) {
                              li = lieux[0];
                        } else {
                              li = street;
                        }
                        sheriflist.add(new Sherif(Integer.parseInt(parametre.get(0)), Integer.parseInt(parametre.get(1)), parametre.get(2), Integer.parseInt(parametre.get(3)), parametre.get(4), parametre.get(5), li));
                        type = "";
                  }

            }

            list.add(ladylist);
            list.add(cowboylist);
            list.add(thuglist);
            list.add(indianlist);
            list.add(barmanlist);

            //choice.mode(list, lieux);
      }

}
