/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static westernjava.Perso.randomHumain;

/**
 *
 * @author ISEN
 */
public class Action {
    static Random random =new Random();

    public Action() {
    }
    
     
    public static void lady(int choice, Lady obj,
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
                }
                else{
                    //action autre
                    System.out.println(obj.name+" est dans "+obj.lieu.name);
                    chiffre=3;
                }   break;
        }

        switch(chiffre){
            
            case(0):
                Action.getChanged(obj);
                break;

            case(1):
                Action.talkToSomeone(choice, obj, list);
                obj.introduceYourself();
                break;
            case(2):
                obj.lieu.Exit(obj);
                break;
            case(3):
                //kidnapp a lady 
                //(ThugLady)obj 
            
        }
    }
    
    public static void cowboy(int choice,Cowboy obj,
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
                Action.shootSomeone(obj, list);
                break;

            case(1):
                Action.freeTheLady(choice, obj, list);
                break;

            case(2):
                obj.introduceYourself();
                break;

        }
    }
    
    public static void thug(int choice,Thug obj,
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
                if(obj.isInJail){
                    obj.escape();
                }
                else{
                    thug(choice,obj, list);
                }
                break;

            case(1):
                Lady girl;
                girl = Perso.randomLady(list.get(0));
                if(!girl.isKidnapped){
                    obj.kidnappedLady(girl);
                }
                else{
                    thug(choice,obj,list);
                }
                break;
                   
            case(2):
                obj.introduceYourself();
                break;

        }
    }
    
    public static void indian(int choice,Indian obj,
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
                obj.introduceYourself();
                break;
        }
    }
    
    public static void humain(int choice, Humain man,
            ArrayList<ArrayList<ArrayList<Humain>>> list){
    
        if (man instanceof Lady){
            Lady personnage = (Lady) man;
            lady(choice,personnage,list);
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
   
    public static void getChanged(Lady obj){
        String couleur;
        String[] couleurTable={"rose", "noire","bleu","blanche"};
        int chiffre=random.nextInt(couleurTable.length);
        couleur = couleurTable[chiffre];
        obj.getChanged(couleur);
    }
    public static void shootSomeone(Cowboy obj,ArrayList<ArrayList<ArrayList<Humain>>> list){
        if(list.get(2).size()>0&&list.get(1).size()>0){
            Thug badboy = (Thug) randomHumain(3, 2, list);
            Sherif cop = (Sherif) randomHumain(3, 1, list);
            obj.shoot(badboy,cop);
        }
        else{
            System.out.println("try again");
        }
    }
    
    public static void freeTheLady(int choice, Cowboy obj, ArrayList<ArrayList<ArrayList<Humain>>> list){
        Lady girl;
        girl = (Lady) randomHumain(3,0,list);
        if(!girl.isKidnapped){
            obj.freeTheLady(girl);
        }
        else{
            cowboy(choice,obj, list);
        }
    
    }
    
    public static void talkToSomeone(int choice, Humain obj, ArrayList<ArrayList<ArrayList<Humain>>> list){
        Humain someone = randomHumain(0, 0, list);
        obj.introduceYourself();
        someone.introduceYourself();
        
    
    }
}
