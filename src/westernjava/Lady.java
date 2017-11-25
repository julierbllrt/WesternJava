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
public class Lady extends Humain{
    boolean isKidnapped;
    String pantieColor;

    public Lady(boolean isKidnapped, String pantieColor, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.isKidnapped = isKidnapped;
        this.pantieColor = pantieColor;
    }

    
    public void getKidnapped(Thug badboy){
        action(badboy.name+" a kidnappé "+this.name);
        talk("Lâche-moi "+badboy.name+"!");
        isKidnapped = true;
    }
    
    public void getFree(Cowboy hero){
        action(hero.name+" a sauvé "+this.name);
        talk("Oooh merci "+hero.name+"!");
        isKidnapped = false;
    }
    
    public void getChanged(String color){
        pantieColor = color;
        action(this.name+" change de culotte");
        talk("Trop belle ma nouvelle culotte "+this.pantieColor+".");   
    }
    
    @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("Salut, je m'appelle "+name+". Je vais séduire toute la ville.");
    }
    
}
