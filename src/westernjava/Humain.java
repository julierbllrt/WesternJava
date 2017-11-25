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
public class Humain {
    String name;
    String favoriteDrink;
    Lieux lieu;

    public Humain(String name, String favoriteDrink, Lieux lieu) {
        this.name = name;
        this.favoriteDrink = favoriteDrink;
        this.lieu = lieu;
    }
    
    public void talk (String blablabla){
        System.out.println(name+": "+blablabla);
    }
    
    public void action (String truc){
        System.out.println("***"+truc+"***");
    }
    
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("Salut, je m'appelle "+name+". Je suis nouveau en ville.");
    }
    
    public String getName(){
        return name;
    }
    
    public String getDrink(Barman barman){
        barman.serve(this);
        return favoriteDrink;
    }
    
    public Lieux where(){
        return lieu;
    }
}
