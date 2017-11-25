/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 *
 * @author ISEN
 */
public class BadCop extends Cowboy implements OutTheLaw{
    int nbKidnappedLady;
    int reward;
    String look;
    Boolean isInJail;

    public BadCop(int nbKidnappedLady, int reward, String look, Boolean isInJail, int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
        super(popularity, adjective, money, name, favoriteDrink, lieu);
        this.nbKidnappedLady = nbKidnappedLady;
        this.reward = reward;
        this.look = look;
        this.isInJail = isInJail;
    }

   

    


    public void getInJail(Sherif boy) {
        talk("Merde! Je me vengerais"+boy.name+"!");
        isInJail=true;
        boy.money+=reward;
    }


    public void addReward(int money) {
        reward+=money;
    }

    
    
    
}