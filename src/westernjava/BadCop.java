package westernjava;

/**
 * caractérise l'Humain de type BadCop
 *
 * @author Julie Robillart
 */
public class BadCop extends Cowboy implements OutTheLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      Boolean isInJail;

      /**
       * constructor
       *
       * @param nbKidnappedLady nombre de fille kidnappées
       * @param reward récompense sur sa tête
       * @param look attitude
       * @param isInJail true si emprisonné
       * @param popularity popularité
       * @param adjective adjectif
       * @param money argent gagné avec les récompenses
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
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
       * se faire mettre en prison
       *
       * @param boy le sherif qui te met en prison
       * @param lieux liste des lieux disponible
       */
      @Override
      public void getInJail(Sherif boy, Lieux[] lieux) {
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
      }

      /**
       * kidnapper une fille
       *
       * @param girl la fille à kidnapper
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
       * s'echapper de prison
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
