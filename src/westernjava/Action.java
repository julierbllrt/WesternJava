/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
public class Action {
    Random random =new Random();
    Perso perso = new Perso();

    public Action() {
    }
    
     
    public void lady(int choice, Lady obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        Scanner scanner = new Scanner(System.in);
        String input;
        switch (choice) {
            case 0:
                chiffre=random.nextInt(3);
                break;
                
            case 1:
                System.out.println("Taper le numero de l'action que vous "
                        + "voulez.");
                System.out.println("0 se faire kidnapper");
                System.out.println("1 se faire libérer");
                System.out.println("2 changer de culotte");
                System.out.println("3 se présenter");
                input = scanner.nextLine();
                chiffre = Integer.parseInt(input);
                break;
                
            default:
                if(obj.lieu instanceof MainStreet){
                    //action dispo street
                    System.out.println(obj.name+" est sur "+obj.lieu.name);
                    System.out.println("Taper le numero de l'action que vous "
                            + "voulez.");
                    System.out.println("0 aller dans le bar");
                    System.out.println("1 kidnapper une fille");
                    System.out.println("2 changer de culotte");
                    System.out.println("3 parler à quelqu'un");
                    input = scanner.nextLine();
                    chiffre = Integer.parseInt(input);
                    
                    switch(chiffre){
                        case(0):
                            obj.goTo(list_lieux[0]);
                            break;
                    }
                }
                else if(obj.lieu instanceof Bar){
                    System.out.println(obj.name+" est dans  "+obj.lieu.name);
                    System.out.println("Taper le numero de l'action que vous "
                            + "voulez.");
                    System.out.println("0 sortir");
                    System.out.println("1 kidnapper une fille");
                    System.out.println("2 changer de culotte");
                    System.out.println("3 parler à quelqu'un");
                    System.out.println("4 commander à boire");
                    input = scanner.nextLine();
                    chiffre = Integer.parseInt(input);
                    
                    switch(chiffre){
                        case(0):
                            obj.goOut();
                            break;
                        case(4):
                            obj.orderADrink(obj.favoriteDrink);
                            break;
                    }
                }
                else{
                    //action autre
                    System.out.println(obj.name+" est dans "+obj.lieu.name);
                    chiffre=3;
                }   break;
        }

        switch(chiffre){
                
            case(1):
                ThugLady badlady = new ThugLady(0,0,"nouvelle",false,obj.isKidnapped,obj.pantieColor,obj.name,obj.favoriteDrink,obj.lieu);
                Lady girl = perso.randomLady(list.get(0));
                while(girl==obj){
                    girl = perso.randomLady(list.get(0));
                }
                badlady.kidnappedLady(girl);
                break;
        
            case(2):
                obj.getChanged();
                break;

            case(3):
                Humain someone = perso.randomHumain(0, 0, list);
                while(someone==obj){
                    someone = perso.randomHumain(0, 0, list);
                }
                obj.talkToSomeone(someone);
                break;
                
        }       
    }
    
    public void cowboy(int choice,Cowboy obj,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        if (choice==0){
            chiffre=random.nextInt(2);
        }
        else{
            System.out.println("Taper le numero de l'action que vous voulez.");
            System.out.println("0 tirer sur un méchant");
            System.out.println("1 libere une fille");
            System.out.println("2 se présenter");
            Scanner scanner = new Scanner(System.in);
               
            String input = scanner.nextLine();
            chiffre = Integer.parseInt(input);
            
        }
        
        switch(chiffre){
            case(0):
                if(list.get(2).size()>0&&list.get(1).size()>0){
                    Thug badboy = (Thug) perso.randomHumain(3, 5, list);
                    Sherif cop = (Sherif) perso.randomHumain(3, 3, list);
                    obj.shoot(badboy,cop);
                }
                break;

            case(1):
                Lady girl = (Lady) perso.randomHumain(3,0,list);
                obj.freeTheLady(girl);
                break;

            case(2):
                Humain someone = perso.randomHumain(0, 0, list);
                while(someone==obj){
                    someone = perso.randomHumain(0, 0, list);
                }
                obj.talkToSomeone(someone);
                break;

        }
    }
    
    public void thug(int choice,Thug obj,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        if (choice==0){
            chiffre=random.nextInt(2);
        }
        else{
            System.out.println("Taper le numero de l'action que vous voulez.");
            System.out.println("0 s'échapper de la prison");
            System.out.println("1 kidnapper une fille");
            System.out.println("2 se présenter");
            Scanner scanner = new Scanner(System.in);
               
            String input = scanner.nextLine();
            chiffre = Integer.parseInt(input);
            
        }
        
        switch(chiffre){
            case(0):
               obj.escape();
                break;

            case(1):
                Lady girl = perso.randomLady(list.get(0));
                obj.kidnappedLady(girl);
                break;
                   
            case(2):
                Humain someone = perso.randomHumain(0, 0, list);
                while(someone==obj){
                    someone = perso.randomHumain(0, 0, list);
                }
                obj.talkToSomeone(someone);
                break;

        }
    }
    
    public void indian(int choice,Indian obj,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        if(choice==0){
            //Random random =new Random();
            //chiffre=random.nextInt(0);
            chiffre = 0;
        }
        else{
            System.out.println("Taper le numero de l'action que vous voulez.");
            System.out.println("0 se présenter");
            Scanner scanner = new Scanner(System.in);
               
            String input = scanner.nextLine();
            chiffre = Integer.parseInt(input);
        }
        
        switch(chiffre){             
            case(0):
                Humain someone = perso.randomHumain(0, 0, list);
                while(someone==obj){
                    someone = perso.randomHumain(0, 0, list);
                }
                obj.talkToSomeone(someone);
                break;
        }
    }
    
    public void humain(int choice, Humain man,Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){
    
        if (man instanceof Lady){
            Lady personnage = (Lady) man;
            lady(choice,personnage,list_lieux,list);
        }
        
        if (man instanceof Cowboy){
            Cowboy personnage = (Cowboy) man;
            cowboy(choice,personnage,list);
        }
        
        if (man instanceof Thug){
            Thug personnage = (Thug) man;
            thug(choice,personnage,list);
        }
        
        if (man instanceof Indian){
            Indian personnage = (Indian) man;
            indian(choice,personnage,list);
        }
    }
   
    
    
}
