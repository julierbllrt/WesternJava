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
public class Sherif extends Cowboy{
    int nbCatchedThug;

    public Sherif(int nbCatchedThug, int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
        super(popularity, adjective, money, name, favoriteDrink, lieu);
        this.nbCatchedThug = nbCatchedThug;
    }
    
    public void catchAThug(Thug badboy){
        action(this.name+" capture "+badboy.name);
        talk("Enfin je t'attrape "+badboy.name+"!");
        badboy.getInJail(this);
    }
    
    public void searchAThug(Thug badboy,int money){
        action(this.name+" met une récompence sur le tête de "+badboy.name);
        badboy.addReward(money);
        talk("Oyé oyé, "+badboy.name+" est recherché pour "+badboy.reward+" dollars!");
    }
    
    @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("Hey, je suis le nouveau shérif en ville! "+name+" à votre service!");
    }
}
