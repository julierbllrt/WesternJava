/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.Random;

/**
 * caractérise l'Humain de type Lady
 *
 * @author Julie Robillart
 */
public class Lady extends Humain {

      boolean isKidnapped;
      String pantieColor;
      Random random = new Random();

      /**
       * constructor
       *
       * @param isKidnapped true si kidnapper
       * @param pantieColor la couleur de sa culotte
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Lady(boolean isKidnapped, String pantieColor, String name, String favoriteDrink, Lieux lieu) {
            super(name, favoriteDrink, lieu);
            this.isKidnapped = isKidnapped;
            this.pantieColor = pantieColor;
      }

      /**
       * se fait kidnaper par badboy
       *
       * @param badboy le kidnappeur
       */
      public void getKidnapped(Thug badboy) {
            action(badboy.name + " a kidnappé " + this.name);
            talk("Lâche-moi " + badboy.name + "!");
            isKidnapped = true;
      }

      /**
       * se fait kidnaper par badgirl
       *
       * @param badgirl la kidnappeuse
       */
      public void getKidnapped(ThugLady badgirl) {
            action(badgirl.name + " a kidnappé " + this.name);
            talk("Lâche-moi " + badgirl.name + "!");
            isKidnapped = true;
      }

      /**
       * se fait kidnaper par badboy
       *
       * @param badboy le kidnappeur
       */
      public void getKidnapped(BadCop badboy) {
            action(badboy.name + " a kidnappé " + this.name);
            talk("Mais " + badboy.name + " vous êtes un cowbow!!");
            isKidnapped = true;
      }

      /**
       * se faire liberer par hero
       *
       * @param hero le héro
       */
      public void getFree(Cowboy hero) {
            action(hero.name + " a sauvé " + this.name);
            talk("Oooh merci " + hero.name + "!");
            isKidnapped = false;
      }

      /**
       * changer de culotte
       */
      public void getChanged() {
            String[] couleurTable = {"rose", "noire", "bleu", "blanche"};
            int chiffre = random.nextInt(couleurTable.length);
            pantieColor = couleurTable[chiffre];
            action(this.name + " change de culotte");
            talk("Trop belle ma nouvelle culotte " + this.pantieColor + ".");
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Salut, je m'appelle " + name + ". Je vais séduire toute la ville.");
      }

}
