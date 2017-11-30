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
 *
 * @author ISEN
 */
public class Choice {
    Perso perso = new Perso();
    Action action = new Action();
    
    public Humain humain(int choice, 
            ArrayList<ArrayList<ArrayList<Humain>>> list){

        Scanner scanner = new Scanner(System.in);   
        System.out.println("Choisis un type:\n1:lady\n2:cowboy\n3:thug\n"
                + "4:indian\n");
        String input;
        do{
            input = scanner.nextLine();
            switch(input){
                case "1":
                    return perso(choice,0 ,list);
                    
                case "2":
                    return perso(choice,1,list);
                   
                case "3":
                    return perso(choice,2, list);
                    
                case "4":
                    return perso(choice,3,list);
                default:
                    return list.get(3).get(0).get(0);
            }
        }while(!input.contains("q"));
        
    }
    
    public Humain perso(int choice,int y,
            ArrayList <ArrayList <ArrayList <Humain>>> list){
        
        Humain personnage;
        Scanner scanner = new Scanner(System.in); 
        printList(list.get(y));
        displayPerso(y);
        System.out.println("Entrer le numéro du personnage que vous avez "
            + "choisit.");

        String input;
        input = scanner.nextLine();
        int pos = Integer.parseInt(input);
        int n = pos/10;
        int i = pos%10;
        
        System.out.println("");

        personnage = list.get(y).get(n).get(i);
        return personnage;

    }
    
    
    public void mode(ArrayList<ArrayList<ArrayList<Humain>>> list, Lieux[] list_lieux){
        Humain personnage;
        Scanner scanner = new Scanner(System.in); 
        String input;
        do{
            System.out.println("\nEntrer 1 pour random; 2 pour choisir; "
                    + "3 pour histoire\n(taper 'quitter' pour sortir)");
            input = scanner.nextLine();
            int choice;
            switch(input){
                case "1":
                    choice = 0;
                    personnage = perso.randomHumain(0,0,list);
                    action.humain(choice,personnage,list_lieux,list);
                    break;

                case "2":
                    choice = 1;
                    do{
                        personnage = humain(choice, list);
                        
                        do{
                            action.humain(choice,personnage,list_lieux,list);
                        }while(!input.contains("autre"));
                    input = scanner.nextLine();
                    }while(!input.contains("mode"));
                    
                    break;
                    
                case "3":
                    choice = 2;
                    personnage = humain(choice, list);
                    
                    do{
                        personnage = action.humain(choice,personnage,list_lieux,list);
                        input = scanner.nextLine();
                    }while(!input.contains("quitter"));
                    break;
            }
        }while(!input.contains("quitter"));
    }
    
}
