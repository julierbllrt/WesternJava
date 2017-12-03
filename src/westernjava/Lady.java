/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.Random;

/**
 *
 * @author ISEN
 */
public class Lady extends Humain {

    boolean isKidnapped;
    String pantieColor;
    Random random = new Random();

      /**
       *
       * @param isKidnapped
       * @param pantieColor
       * @param name
       * @param favoriteDrink
       * @param lieu
       */
      public Lady(boolean isKidnapped, String pantieColor, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.isKidnapped = isKidnapped;
        this.pantieColor = pantieColor;
    }

      /**
       *
       * @param badboy
       */
      public void getKidnapped(Thug badboy) {
        action(badboy.name + " a kidnappé " + this.name);
        talk("Lâche-moi " + badboy.name + "!");
        isKidnapped = true;
    }

      /**
       *
       * @param badgirl
       */
      public void getKidnapped(ThugLady badgirl) {
        action(badgirl.name + " a kidnappé " + this.name);
        talk("Lâche-moi " + badgirl.name + "!");
        isKidnapped = true;
    }

      /**
       *
       * @param badgirl
       */
      public void getKidnapped(BadCop badgirl) {
        action(badgirl.name + " a kidnappé " + this.name);
        talk("Mais " + badgirl.name + " vous êtes un cowbow!!");
        isKidnapped = true;
    }

      /**
       *
       * @param hero
       */
      public void getFree(Cowboy hero) {
        action(hero.name + " a sauvé " + this.name);
        talk("Oooh merci " + hero.name + "!");
        isKidnapped = false;
    }

      /**
       *
       */
      public void getChanged() {
        String[] couleurTable = {"rose", "noire", "bleu", "blanche"};
        int chiffre = random.nextInt(couleurTable.length);
        pantieColor = couleurTable[chiffre];
        action(this.name + " change de culotte");
        talk("Trop belle ma nouvelle culotte " + this.pantieColor + ".");
    }

      /**
       *
       */
      @Override
    public void introduceYourself() {
        action(this.name + " se présente.");
        talk("Salut, je m'appelle " + name + ". Je vais séduire toute la ville.");
    }

}
