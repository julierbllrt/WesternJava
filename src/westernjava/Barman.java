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
public class Barman extends Humain {

      /**
       *
       * @param name
       * @param favoriteDrink
       * @param lieu
       */
      public Barman(String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
    }

      /**
       *
       * @param someone
       */
      public void serve(Humain someone) {
        action(this.name + " sert un verre à " + someone.name);
        talk("Tiens " + someone.name + " ton verre.");
    }

      /**
       *
       * @param blablabla
       */
      @Override
    public void talk(String blablabla) {
        System.out.println("Barman " + name + ": " + blablabla);
    }

      /**
       *
       */
      @Override
    public void introduceYourself() {
        action(this.name + " se présente.");
        talk("Hey, si tu veux un verre demande " + name + "!");
    }
}
