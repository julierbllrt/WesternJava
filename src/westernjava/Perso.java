/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ISEN
 */
public class Perso {
    
     public static Lady randomLady(ArrayList <ArrayList <Humain>>ladyTable){
        int colonne,ligne;
        Random random =new Random();
        Lady personnage;
        if(ladyTable.size()>0){
            colonne=random.nextInt(ladyTable.size());
            ligne=random.nextInt(ladyTable.get(colonne).size());
            personnage = (Lady) ladyTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    public static ThugLady randomThugLady(
            ArrayList <ArrayList <Humain>>ladyTable){
        int colonne,ligne;
        Random random =new Random();
        ThugLady personnage;
        if(ladyTable.size()>0){
            colonne=1;
            ligne=random.nextInt(ladyTable.get(colonne).size());
            personnage = (ThugLady) ladyTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    public static Cowboy randomCowboy(
            ArrayList <ArrayList <Humain>> cowboyTable){
        int colonne,ligne;
        Random random =new Random();
        Cowboy personnage;
        if(cowboyTable.size()>0){
            colonne=random.nextInt(cowboyTable.size());
            ligne=random.nextInt(cowboyTable.get(colonne).size());
            personnage = (Cowboy) cowboyTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    public static Sherif randomSherif(
            ArrayList <ArrayList <Humain>> cowboyTable){
        int colonne,ligne;
        Random random =new Random();
        Sherif personnage;
        if(cowboyTable.size()>0){
            colonne=1;
            ligne=random.nextInt(cowboyTable.get(colonne).size());
            personnage = (Sherif) cowboyTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    public static BadCop randomBadCop(
            ArrayList <ArrayList <Humain>> cowboyTable){
        int colonne,ligne;
        Random random =new Random();
        BadCop personnage;
        if(cowboyTable.size()>0){
            colonne=2;
            ligne=random.nextInt(cowboyTable.get(colonne).size());
            personnage = (BadCop) cowboyTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    public static Thug randomThug(ArrayList <ArrayList <Humain>> thugTable){
        int colonne,ligne;
        Random random =new Random();
        Thug personnage;
        if(thugTable.size()>0){
            colonne=random.nextInt(thugTable.size());
            ligne=random.nextInt(thugTable.get(colonne).size());
            personnage = (Thug) thugTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    public static Indian randomIndian(
            ArrayList <ArrayList <Humain>> indianTable){
        int colonne,ligne;
        Random random =new Random();
        Indian personnage;
        if(indianTable.size()>0){
            colonne=random.nextInt(indianTable.size());
            ligne=random.nextInt(indianTable.get(colonne).size());
            personnage = (Indian) indianTable.get(colonne).get(ligne);
            System.out.println(personnage.name);
            return personnage;
        }
        else{
            System.out.println("try again");
        }
        return(null);
    }
    
    
    public static Humain randomHumain(int choice,int chiffre,
            ArrayList<ArrayList<ArrayList<Humain>>> list){
        if (choice==0){
            String[] type={"Lady","Cowboy","Thug","Indian"};
            Random random =new Random();
            chiffre=random.nextInt(type.length);
        }
               
        switch (chiffre)
        {
            case 0:
                return(randomLady(list.get(0)));
      
            case 1:
                return(randomCowboy(list.get(1)));
                
            case 2:
                return(randomThug(list.get(2)));
               
            case 3:
                return(randomIndian(list.get(3)));
              
            default:
                System.out.println("bug non supporté");
                return(null);
        }    
    }
    
    
}