/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Scanner;
import static westernjava.WesternJava.printList;
import static westernjava.WesternJava.displayPerso;

/**
 * permet d'effectuer des choix dans la console
 *
 * @author Julie Robillart
 */
public class Choice {

      Perso perso = new Perso();
      Action action = new Action();

      /**
       * permet de choisir un type donc la console retourne un personnage au hasard ou choisit en
       * fonction de choice
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param list liste des personnages disponibles
       * @return un personnage de type Humain
       */
      public Humain humain(int choice,
               ArrayList<ArrayList<ArrayList<Humain>>> list) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisis un type:\n1:lady\n2:cowboy\n3:thug\n"
                     + "4:indian\n");
            String input;
            do {
                  input = scanner.nextLine();
                  switch (input) {
                        case "1":
                              return perso(choice, 0, list);

                        case "2":
                              return perso(choice, 1, list);

                        case "3":
                              return perso(choice, 2, list);

                        case "4":
                              return perso(choice, 3, list);
                        default:
                              return list.get(3).get(0).get(0);
                  }
            } while (!input.contains("quitter"));

      }

      /**
       * après affichage des personnage disponible en fonction de y retrourne le personnage choisit
       * d'après le nombre en input
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param y int correspondant au type à afficher (ex:0 pour Lady , 4 pour Indien)
       * @param list liste des personnages disponibles
       * @return un personnage de type Humain
       */
      public Humain perso(int choice, int y,
               ArrayList<ArrayList<ArrayList<Humain>>> list) {

            Humain personnage;
            Scanner scanner = new Scanner(System.in);
            printList(list.get(y));
            displayPerso(y);
            System.out.println("Entrer le numéro du personnage que vous avez choisit.");

            String input;
            input = scanner.nextLine();
            int pos = Integer.parseInt(input);
            int n = pos / 10;
            int i = pos % 10;

            System.out.println("");

            personnage = list.get(y).get(n).get(i);
            return personnage;

      }

      /**
       * permet de choisir dans la console le mode souhaité pour le déroulement du projet pour
       * chaque mode, permet de choisir le personnage et l'action dans la console
       *
       * @param list liste des personnages disponibles
       * @param list_lieux liste des lieux implémentés
       */
      public void mode(ArrayList<ArrayList<ArrayList<Humain>>> list, Lieux[] list_lieux) {
            Humain personnage;
            Scanner scanner = new Scanner(System.in);
            String input;
            do {
                  System.out.println("\nEntrer 1 pour random; 2 pour choisir; "
                           + "3 pour histoire\n(taper 'quitter' pour sortir)");
                  input = scanner.nextLine();
                  int choice;
                  switch (input) {
                        case "1":
                              choice = 0;
                              personnage = perso.randomHumain(0, 0, list);
                              action.humain(choice, personnage, list_lieux, list);
                              break;

                        case "2":
                              choice = 1;
                              do {
                                    personnage = humain(choice, list);

                                    do {
                                          action.humain(choice, personnage, list_lieux, list);
                                          System.out.println("autre pour un autre personnage sinon n'importe quoi");
                                          input = scanner.nextLine();
                                    } while (!input.contains("autre"));
                                    input = scanner.nextLine();
                              } while (!input.contains("mode"));

                              break;

                        case "3":
                              choice = 2;
                              personnage = humain(choice, list);

                              do {
                                    personnage = action.humain(choice, personnage, list_lieux, list);

                              } while (!input.contains("quitter"));
                              break;
                  }
            } while (!input.contains("quitter"));
      }

}
