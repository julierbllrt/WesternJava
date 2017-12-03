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
public class BadCop extends Cowboy implements OutTheLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      Boolean isInJail;

      /**
       *
       * @param nbKidnappedLady
       * @param reward
       * @param look
       * @param isInJail
       * @param popularity
       * @param adjective
       * @param money
       * @param name
       * @param favoriteDrink
       * @param lieu
       */
      public BadCop(int nbKidnappedLady, int reward, String look, Boolean isInJail,
               int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
            super(popularity, adjective, money, name, favoriteDrink, lieu);
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       *
       * @param boy
       * @param lieux
       */
      @Override
      public void getInJail(Sherif boy, Lieux[] lieux) {
            talk("Merde! Je me vengerais " + boy.name + "!");
            isInJail = true;
            this.goTo(lieux[1]);
            boy.money += reward;
      }

      /**
       *
       * @param money
       */
      @Override
      public void addReward(int money) {
            reward += money;
      }

      /**
       *
       * @param girl
       */
      @Override
      public void kidnappedLady(Lady girl) {
            if (!girl.isKidnapped) {
                  talk("Enfin, je t'attrape " + girl.name);
                  nbKidnappedLady++;
                  girl.getKidnapped(this);
            }
      }

      /**
       *
       */
      @Override
      public void escape() {
            if (this.isInJail) {
                  isInJail = false;
                  action(this.name + " s'échappe");
                  talk("Ca a ses avantages de connaître du monde.");
                  this.goOut();
            }
      }

}
