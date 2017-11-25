/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Scanner;
import static westernjava.WesternJava.printList;

/**
 *
 * @author ISEN
 */
public class Choice {
    
    public static Humain humain(int choice, 
            ArrayList<ArrayList<ArrayList<Humain>>> list){

        Scanner scanner = new Scanner(System.in);   
        System.out.println("Choisis un type:\n1:lady\n2:cowboy\n3:thug\n"
                + "4:indian\n");
        String input;
        do{
            input = scanner.nextLine();
            switch(input){
                case "1":
                    return Choice.perso(choice,0 ,list);
                    
                case "2":
                    return Choice.perso(choice, 1,list);
                   
                case "3":
                    return Choice.perso(choice,2, list);
                    
                case "4":
                    return Choice.perso(choice,3,list);
                default:
                    return list.get(3).get(0).get(0);
            }
        }while(!input.contains("q"));
        
    }
    
    public static Humain perso(int choice,int y,
            ArrayList <ArrayList <ArrayList <Humain>>> list){
        
        Humain personnage;
        Scanner scanner = new Scanner(System.in); 
        printList(list.get(y));
        System.out.println("Entrer le numéro du personnage que vous avez "
            + "choisit.");

        String input;
        input = scanner.nextLine();
        int pos = Integer.parseInt(input);
        int n = pos/10;
        int i = pos%10;

        personnage = list.get(y).get(n).get(i);
        return personnage;

    }
    
    
    public static void mode(ArrayList<ArrayList<ArrayList<Humain>>> list){
        Humain personnage;
        Scanner scanner = new Scanner(System.in); 
        String input;
        do{
            System.out.println("\nEntrer 1 pour random; 2 pour choisir; "
                    + "3 pour histoire (taper 'quitter' pour sortir)");
            input = scanner.nextLine();
            int choice;
            switch(input){
                case "1":
                    choice = 0;
                    personnage = Perso.randomHumain(0,0,list);
                    Action.humain(choice,personnage,list);
                    break;

                case "2":
                    choice = 1;
                    do{
                        personnage = Choice.humain(choice, list);
                        
                        do{
                            Action.humain(choice,personnage,list);
                            System.out.println("Entrer 'autre' pour choisir un "
                                    + "autre perso ou n'importe quoi si vous "
                                    + "voulez continuer.");
                            input = scanner.nextLine();
                        }while(!input.contains("autre"));
                        
                    }while(!input.contains("mode"));
                    
                    break;
                    
                case "3":
                    choice = 2;
                    do{
                        personnage = Choice.humain(choice, list);
                        //displayPerso(choice, list);
                        do{
                            Action.humain(choice,personnage,list);
                            input = scanner.nextLine();
                        }while(!input.contains("autre"));
                        
                    }while(!input.contains("mode"));
                    
                    break;
            }
        }while(!input.contains("quitter"));
    }
    
}
