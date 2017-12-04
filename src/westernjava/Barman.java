/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Barman
 *
 * @author Julie Robillart
 */
public class Barman extends Humain {

      /**
       * constructor
       *
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Barman(String name, String favoriteDrink, Lieux lieu) {
            super(name, favoriteDrink, lieu);
      }

      /**
       * ervir un verre à quelqu'un
       *
       * @param someone quelqu'un
       */
      public void serve(Humain someone) {
            action(this.name + " sert un verre à " + someone.name);
            talk("Tiens " + someone.name + " ton verre.");
      }

      /**
       * mise en forme de sa parole dans la console
       *
       * @param blablabla ce qu'il dit
       */
      @Override
      public void talk(String blablabla) {
            System.out.println("Barman " + name + ": " + blablabla);
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Hey, si tu veux un verre demande " + name + "!");
      }
}
