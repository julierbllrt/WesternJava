/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Cowboy extends Humain {
    int popularity;
    String adjective;
    int money;
    Perso perso =new Perso();

    public Cowboy(int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.popularity = popularity;
        this.adjective = adjective;
        this.money = money;
    }
    
    public void shoot(ArrayList<ArrayList<ArrayList<Humain>>> list){
        if(list.get(2).size()>0&&list.get(1).size()>0){
            Thug badboy = (Thug) perso.randomHumain(3, 5, list);
            Sherif cop = (Sherif) perso.randomHumain(3, 3, list);
            action(this.name+" tir sur "+badboy.name);
            action("Bang!!!");
            talk("Enfin je t'ai eu "+ badboy.name+".");
            cop.catchAThug(badboy);
            getReward(badboy);
        }
        
    }
    
    public void freeTheLady(ArrayList<ArrayList<ArrayList<Humain>>> list){
        Lady girl = (Lady) perso.randomHumain(3,0,list);
         if(!girl.isKidnapped){
            action(this.name+" libère "+girl.name);
            talk("Je vous libère "+girl.name+"!!");
            girl.getFree(this);  
        }
              
    }
    
    public void getReward(Thug badboy){
        action(this.name+" obtient la récompence de "+badboy.name);
        money+=badboy.reward;
        badboy.reward=0;
    }
    
    @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("Salut, je m'appelle "+name+". Je suis le nouveau cowboy.");
    }
    
}