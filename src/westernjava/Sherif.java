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
public class Sherif extends Cowboy {

    int nbCatchedThug;

      /**
       *
       * @param nbCatchedThug
       * @param popularity
       * @param adjective
       * @param money
       * @param name
       * @param favoriteDrink
       * @param lieu
       */
      public Sherif(int nbCatchedThug, int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
        super(popularity, adjective, money, name, favoriteDrink, lieu);
        this.nbCatchedThug = nbCatchedThug;
    }

      /**
       *
       * @param badboy
       * @param lieux
       */
      public void catchAThug(Thug badboy , Lieux[] lieux) {
        action(this.name + " capture " + badboy.name);
        badboy.getInJail(this,lieux);
    }

      /**
       *
       * @param badgirl
       * @param lieux
       */
      public void catchAThug(ThugLady badgirl, Lieux[] lieux) {
        action(this.name + " capture " + badgirl.name);
        talk("Je te pensais mieux que ça " + badgirl.name + "...");
        badgirl.getInJail(this,lieux);
    }

      /**
       *
       * @param badcop
       * @param lieux
       */
      public void catchAThug(BadCop badcop, Lieux[] lieux) {
        action(this.name + " capture " + badcop.name);
        talk("Je te pensais mieux que ça " + badcop.name + "...");
        badcop.getInJail(this,lieux);
    }

      /**
       *
       * @param badboy
       * @param money
       */
      public void searchAThug(Thug badboy, int money) {
        action(this.name + " met une récompence sur le tête de " + badboy.name);
        badboy.addReward(money);
        talk("Oyé oyé, " + badboy.name + " est recherché pour " + badboy.reward + " dollars!");
    }

      /**
       *
       */
      @Override
    public void introduceYourself() {
        action(this.name + " se présente.");
        talk("Hey, je suis le nouveau shérif en ville! " + name + " à votre service!");
    }
}
