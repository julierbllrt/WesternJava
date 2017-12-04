/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise un Humain
 *
 * @author ISEN
 */
public class Humain {

      String name;
      String favoriteDrink;
      Lieux lieu;

      /**
       * constructor
       *
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Humain(String name, String favoriteDrink, Lieux lieu) {
            this.name = name;
            this.favoriteDrink = favoriteDrink;
            this.lieu = lieu;
            lieu.entrer(this);
      }

      /**
       * mets en forme sa parole dans la console
       *
       * @param blablabla ce qu'il dit
       */
      public void talk(String blablabla) {
            System.out.println(name + ": " + blablabla);
      }

      /**
       * mets en forme son action dans la console
       *
       * @param truc
       */
      public void action(String truc) {
            System.out.println("***" + truc + "***");
      }

      /**
       * permet de se présenter
       */
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Salut, je m'appelle " + name + ". Je suis nouveau en ville.");
      }

      /**
       * permet de parler à quelqu'un
       *
       * @param someone le compagnon de parole
       */
      public void talkToSomeone(Humain someone) {
            introduceYourself();
            someone.introduceYourself();

      }

      /**
       * permet d'obtenir le nom du personnage
       *
       * @return le nom du personnage
       */
      public String getName() {
            return name;
      }

      /**
       * permet d'aller à un endroit
       *
       * @param lieux la destination
       */
      public void goTo(Lieux lieux) {
            lieu.exit(this);
            lieu = lieux;
            lieu.entrer(this);
            action(name + " est entré dans " + lieu.name);
      }

      /**
       * permet de sortir d'un endroit
       */
      public void goOut() {
            lieu.exit(this);
            action(name + " est sorti sur " + lieu.name);
      }

      /**
       * permet de commander un verre au barman
       *
       * @param favoriteDrink le verre qu'il va commander
       */
      public void orderADrink(String favoriteDrink) {
            Bar bar = (Bar) this.lieu;
            Barman barman = bar.getBarman();
            action(name + " a commander un verre");
            talk("Hey " + barman.name + " donne moi un verre de " + favoriteDrink);
            barman.serve(this);

      }

}
