package westernjava;

/**
 * caractérise l'Humain de type Sherif
 *
 * @author Julie Robillart
 */
public class Sherif extends Cowboy {

      int nbCatchedThug;

      /**
       * constructor
       *
       * @param nbCatchedThug nombre de méchant attrapés
       * @param popularity popularité
       * @param adjective adjectif
       * @param money argent gagné avec les récompenses
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Sherif(int nbCatchedThug, int popularity, String adjective, int money, String name, String favoriteDrink, Lieux lieu) {
            super(popularity, adjective, money, name, favoriteDrink, lieu);
            this.nbCatchedThug = nbCatchedThug;
      }

      /**
       * attraper un méchant et le mettre en prison
       *
       * @param badboy le méchant
       * @param lieux liste des lieux disponibles
       */
      public void catchAThug(Thug badboy, Lieux[] lieux) {
            action(this.name + " capture " + badboy.name);
            badboy.getInJail(this, lieux);
      }

      /**
       * attraper un méchant et le mettre en prison
       *
       * @param badgirl la méchante
       * @param lieux liste des lieux disponibles
       */
      public void catchAThug(ThugLady badgirl, Lieux[] lieux) {
            action(this.name + " capture " + badgirl.name);
            talk("Je te pensais mieux que ça " + badgirl.name + "...");
            badgirl.getInJail(this, lieux);
      }

      /**
       * attraper un méchant et le mettre en prison
       *
       * @param badcop le méchant
       * @param lieux liste des lieux disponibles
       */
      public void catchAThug(BadCop badcop, Lieux[] lieux) {
            action(this.name + " capture " + badcop.name);
            talk("Je te pensais mieux que ça " + badcop.name + "...");
            badcop.getInJail(this, lieux);
      }

      /**
       * mettre une récompense sur la tête d'un méchant
       *
       * @param badboy le méchant
       * @param money la récompense
       */
      public void searchAThug(Thug badboy, int money) {
            action(this.name + " met une récompence sur le tête de " + badboy.name);
            badboy.addReward(money);
            talk("Oyé oyé, " + badboy.name + " est recherché pour " + badboy.reward + " dollars!");
      }
      
       /**
       * mettre une récompense sur la tête d'un méchant
       *
       * @param badboy le méchant
       * @param money la récompense
       */
      public void searchAThug(BadCop badboy, int money) {
            action(this.name + " met une récompence sur le tête de " + badboy.name);
            badboy.addReward(money);
            talk("Oyé oyé, " + badboy.name + " est recherché pour " + badboy.reward + " dollars!");
      }

      /**
       * se présenter
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Hey, je suis le nouveau shérif en ville! " + name + " à votre service!");
      }
}
