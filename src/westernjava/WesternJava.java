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
 * @author Julie Robillart
 */
public class WesternJava {

      static ArrayList<ArrayList<ArrayList<Humain>>> list = new ArrayList();
      static Choice choice = new Choice();

      /**
       * affiche le numéro ainsi que le nom des personnage de la liste entré en paramètre
       *
       * @param list liste de personnage à afficher
       */
      public static void printList(ArrayList<ArrayList<Humain>> list) {

            for (int n = 0; n < list.size(); n++) {
                  for (int i = 0; i < list.get(n).size(); i++) {
                        System.out.println(n + "" + i + " " + list.get(n).get(i).name);
                  }
            }
      }

      /**
       * affiche le numéro le nom des personnage de la liste entré en paramètre ainsi que certain
       * paramètre en fonction du type de personnage
       *
       * @param c int correspondant au type à afficher (ex:0 pour Lady , 4 pour Indien)
       */
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

            //Creation liste personnage
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

            //Creation personnage par lecture fichier
            String fileName = "initialisation.txt";
            FileReader inp = new FileReader(fileName);
            int nb_line = 0;
            int r;
            while ((r = inp.read()) != 47) {
                  if (r == 59) {
                        nb_line++;
                  }

            }

            inp.close();
            FileReader in = new FileReader(fileName);

            //System.out.println("nombre de ligne" + result);
            int i, c, n;

            String type = "";
            String para = "";
            ArrayList<String> parametre = new ArrayList();

            for (int m = 0; m < nb_line; m++) {

                  while ((c = in.read()) != 44) {

                        String t = Character.toString((char) c);
                        type = type + t;
                  }

                  //System.out.println("\ntype " + type);
                  switch (type) {
                        case "Lady":
                              parametre.clear();
                              for (i = 0; i < 5; i++) {
                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;
                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
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
                              break;
                        case "Sherif":
                              parametre.clear();
                              for (i = 0; i < 7; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
                              }

                              if (parametre.get(6).equalsIgnoreCase(lieux[0].name)) {
                                    li = lieux[0];
                              } else {
                                    li = street;
                              }
                              sheriflist.add(new Sherif(Integer.parseInt(parametre.get(0)),
                                       Integer.parseInt(parametre.get(1)), parametre.get(2),
                                       Integer.parseInt(parametre.get(3)), parametre.get(4),
                                       parametre.get(5), li));
                              type = "";
                              break;
                        case "Thug":
                              parametre.clear();
                              for (i = 0; i < 7; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
                              }

                              bo = parametre.get(3).equals("true");
                              if (parametre.get(6).equalsIgnoreCase(lieux[0].name)) {
                                    li = lieux[0];
                              } else {
                                    li = street;
                              }
                              simplethuglist.add(new Thug(Integer.parseInt(parametre.get(0)),
                                       Integer.parseInt(parametre.get(1)), parametre.get(2),
                                       bo, parametre.get(4), parametre.get(5), li));
                              type = "";
                              break;
                        case "ThugLady":
                              parametre.clear();
                              for (i = 0; i < 9; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;
                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
                              }

                              bo = parametre.get(3).equals("true");
                              boolean bo2 = parametre.get(4).equals("true");
                              if (parametre.get(8).equalsIgnoreCase(lieux[0].name)) {
                                    li = lieux[0];
                              } else {
                                    li = street;
                              }
                              thugladylist.add(new ThugLady(Integer.parseInt(parametre.get(0)),
                                       Integer.parseInt(parametre.get(1)), parametre.get(2),
                                       bo, bo2, parametre.get(5), parametre.get(6), parametre.get(7), li));
                              type = "";
                              break;
                        case "Cowboy":
                              parametre.clear();
                              for (i = 0; i < 6; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
                              }

                              if (parametre.get(5).equalsIgnoreCase(lieux[0].name)) {
                                    li = lieux[0];
                              } else {
                                    li = street;
                              }
                              simplecowboylist.add(new Cowboy(Integer.parseInt(parametre.get(0)),
                                       parametre.get(1), Integer.parseInt(parametre.get(2)),
                                       parametre.get(3), parametre.get(4), li));
                              type = "";
                              break;
                        case "Indian":
                              parametre.clear();
                              for (i = 0; i < 5; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
                              }

                              if (parametre.get(4).equalsIgnoreCase(lieux[0].name)) {
                                    li = lieux[0];
                              } else {
                                    li = street;
                              }
                              simpleindianlist.add(new Indian(Integer.parseInt(parametre.get(0)),
                                       parametre.get(1), parametre.get(2),
                                       parametre.get(3), li));
                              type = "";
                              break;
                        case "BadCop":
                              parametre.clear();
                              for (i = 0; i < 10; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;
                                    }
                                    parametre.add(para);
                                    para = "";
                                    //System.out.println(parametre.get(i));
                              }

                              bo = parametre.get(3).equals("true");

                              if (parametre.get(9).equalsIgnoreCase(lieux[0].name)) {
                                    li = lieux[0];
                              } else {
                                    li = street;
                              }
                              badcoplist.add(new BadCop(Integer.parseInt(parametre.get(0)),
                                       Integer.parseInt(parametre.get(1)), parametre.get(2),
                                       bo, Integer.parseInt(parametre.get(4)), parametre.get(5),
                                       Integer.parseInt(parametre.get(6)), parametre.get(7),
                                       parametre.get(8), li));
                              type = "";
                              break;

                  }

            }

            list.add(ladylist);
            list.add(cowboylist);
            list.add(thuglist);
            list.add(indianlist);
            list.add(barmanlist);

            choice.mode(list, lieux);
      }

}
