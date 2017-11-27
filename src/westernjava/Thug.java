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
public class Thug extends Humain implements OutTheLaw{
    int nbKidnappedLady;
    int reward;
    String look;
    boolean isInJail;
    Perso perso = new Perso();

    public Thug(int nbKidnappedLady, int reward, String look, boolean isInJail, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.nbKidnappedLady = nbKidnappedLady;
        this.reward = reward;
        this.look = look;
        this.isInJail = isInJail;
    }
   
    
    public void escape(){
        if(this.isInJail){
            isInJail = false;
            action(this.name+" s'échappe");
            talk("Je suis liiibre!!!");
        }
                      
    }
    
    @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("J'suis "+ name +". Je vais mettre cette ville à feu et à sang.");
    }

    public void kidnappedLady(ArrayList<ArrayList<ArrayList<Humain>>> list) {
        Lady girl = perso.randomLady(list.get(0));
        if(!girl.isKidnapped){
            action(this.name+" kidnappe "+girl.name);
            talk(girl.name+", tu es à moi maintenant!");
            nbKidnappedLady++;
            girl.getKidnapped(this);
        }        
    }

    @Override
    public void getInJail(Sherif boy) {
        action(boy.name+" a mis "+this.name+" en prison");
        talk("Merde! Je me vengerais "+boy.name+"!");
        isInJail=true;
        boy.money+=reward;
    }
    @Override
    public void addReward(int money) {
        reward+=money;
        action("money="+reward);
    }
    
}