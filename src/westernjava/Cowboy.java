/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Cowboy
 *
 * @author Julie Robillart
 */
public class Cowboy extends Humain {

      int popularity;
      String adjective;
      int money;

      /**
       * constructor
       *
       * @param popularity popularité
       * @param adjective adjectif
       * @param money argent gagné avec les récompenses
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Cowboy(int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
            super(name, favoriteDrink, lieu);
            this.popularity = popularity;
            this.adjective = adjective;
            this.money = money;
      }

      /**
       * tirer sur un méchant et l'emprisonner
       *
       * @param badboy le méchant
       * @param cop le sherif qui va l'emprissoner
       * @param lieux liste des lieux disponibles
       */
      public void shoot(Thug badboy, Sherif cop, Lieux[] lieux) {
            action(this.name + " tir sur " + badboy.name);
            action("Bang!!!");
            talk("Enfin je t'ai eu " + badboy.name + ".");
            cop.catchAThug(badboy, lieux);
            getReward(badboy);
      }

      /**
       * tirer sur un méchant et l'emprisonner
       *
       * @param badboy le méchant
       * @param cop le sherif qui va l'emprissoner
       * @param lieux liste des lieux disponibles
       */
      public void shoot(BadCop badboy, Sherif cop, Lieux[] lieux) {
            action(this.name + " tir sur " + badboy.name);
            action("Bang!!!");
            talk("Je ne pensais pas en arrivez là " + badboy.name + ".");
            cop.catchAThug(badboy, lieux);
            getReward(badboy);
      }

      /**
       * liberer une fille kidnapper
       *
       * @param girl la fille kidnappée
       */
      public void freeTheLady(Lady girl) {
            if (girl.isKidnapped) {
                  action(this.name + " libère " + girl.name);
                  talk("Je vous libère " + girl.name + "!!");
                  girl.getFree(this);
            }

      }

      /**
       * obtenir la récompense
       *
       * @param badboy le méchant d'où vient la récompense
       */
      public void getReward(Thug badboy) {
            action(this.name + " obtient la récompence sur la tête de " + badboy.name);
            money += badboy.reward;
            badboy.reward = 0;
      }

      /**
       * obtenir la récompense
       *
       * @param badboy le méchant d'où vient la récompense
       */
      public void getReward(BadCop badboy) {
            action(this.name + " obtient la récompence sur la tête de " + badboy.name);
            money += badboy.reward;
            badboy.reward = 0;
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Salut, je m'appelle " + name + ". Je suis le nouveau cowboy.");
      }

}
