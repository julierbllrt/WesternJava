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
        lieu.entrer(this);
    }

    public void talk(String blablabla) {
        System.out.println(name + ": " + blablabla);
    }

    public void action(String truc) {
        System.out.println("***" + truc + "***");
    }

    public void introduceYourself() {
        action(this.name + " se présente.");
        talk("Salut, je m'appelle " + name + ". Je suis nouveau en ville.");
    }

    public void talkToSomeone(Humain someone) {
        introduceYourself();
        someone.introduceYourself();

    }

    public String getName() {
        return name;
    }

    public String getDrink(Barman barman) {
        barman.serve(this);
        return favoriteDrink;
    }

    public void goTo(Lieux lieux) {
        lieu.exit(this);
        lieu = lieux;
        lieu.entrer(this);
        action(name + " est entré dans " + lieu.name);
    }

    public void goOut() {
        lieu.exit(this);
        action(name + " est sorti sur " + lieu.name);
    }

    public void orderADrink(String favoriteDrink) {
        Bar bar = (Bar) this.lieu;
        Barman barman = bar.getBarman();
        action(name + " a commander un verre");
        talk("Hey " + barman.name + " donne moi un " + favoriteDrink);
        barman.serve(this);

    }

}
