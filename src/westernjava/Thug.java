/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Thug
 *
 * @author Julie Robillart
 */
public class Thug extends Humain implements OutTheLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      boolean isInJail;

      /**
       * constructor
       *
       * @param nbKidnappedLady nombre de fille kidnappées
       * @param reward récompense sur sa tête
       * @param look attitude
       * @param isInJail true si emprisonné
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Thug(int nbKidnappedLady, int reward, String look, boolean isInJail, String name, String favoriteDrink, Lieux lieu) {
            super(name, favoriteDrink, lieu);
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       * s'echapper de prison
       */
      @Override
      public void escape() {
            if (this.isInJail) {
                  isInJail = false;
                  action(this.name + " s'échappe");
                  talk("Je suis liiibre!!!");
                  this.goOut();
            }
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("J'suis " + name + ". Je vais mettre cette ville à feu et à sang.");
      }

      /**
       * kidnapper une fille
       *
       * @param girl la fille à kidnapper
       */
      @Override
      public void kidnappedLady(Lady girl) {
            if (!girl.isKidnapped) {
                  action(this.name + " kidnappe " + girl.name);
                  talk(girl.name + ", tu es à moi maintenant!");
                  nbKidnappedLady++;
                  girl.getKidnapped(this);
            }
      }

      /**
       * se faire mettre en prison
       *
       * @param boy le sherif qui te met en prison
       * @param lieux liste des lieux disponible
       */
      @Override
      public void getInJail(Sherif boy, Lieux[] lieux) {
            action(boy.name + " a mis " + this.name + " en prison");
            talk("Merde! Je me vengerais " + boy.name + "!");
            isInJail = true;
            this.goTo(lieux[1]);
            boy.money += reward;
      }

      /**
       * ajoute money à la récompense déjà sur la tête du personnage
       *
       * @param money la récompense ajoutée
       */
      @Override
      public void addReward(int money) {
            reward += money;
            action("money = " + reward);
      }

}
