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
                obj.lieu.Exit(obj);
                obj.lieu=list_lieux[0];
                break;
                
             case(1):
                //kidnapp a lady 
                //(ThugLady)obj 
                break;
        
            case(2):
                obj.getChanged();
                break;

            case(3):
                talkToSomeone(choice, obj, list);
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
                obj.shoot(list);
                break;

            case(1):
                obj.freeTheLady(list);
                break;

            case(2):
                obj.introduceYourself();
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
                
                obj.kidnappedLady(list);
                break;
                   
            case(2):
                obj.introduceYourself();
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
                obj.introduceYourself();
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
   
    
    
    
    
    
    public void talkToSomeone(int choice, Humain obj, ArrayList<ArrayList<ArrayList<Humain>>> list){
        Humain someone = perso.randomHumain(0, 0, list);
        while(someone==obj){
            someone = perso.randomHumain(0, 0, list);
        }
        obj.introduceYourself();
        someone.introduceYourself();
        
    
    }
}
