package westernjava;

/**
 * caractérise l'Humain de type ThugLady
 *
 * @author Julie Robillart
 */
public class ThugLady extends Lady implements OutTheLaw {

      int nbKidnappedLady;
      int reward;
      String look;
      Boolean isInJail;

      /**
       * constructor
       *
       * @param nbKidnappedLady nombre de fille kidnapper
       * @param reward récompense sur sa tête
       * @param look attitude
       * @param isInJail true si emprisonné
       * @param isKidnapped true si kidnapper
       * @param pantieColor la couleur de sa culotte
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public ThugLady(int nbKidnappedLady, int reward, String look, Boolean isInJail,
               boolean isKidnapped, String pantieColor, String name, String favoriteDrink, Lieux lieu) {
            super(isKidnapped, pantieColor, name, favoriteDrink, lieu);
            this.nbKidnappedLady = nbKidnappedLady;
            this.reward = reward;
            this.look = look;
            this.isInJail = isInJail;
      }

      /**
       * kidnapper une fille
       *
       * @param girl la fille à kidnapper
       */
      @Override
      public void kidnappedLady(Lady girl) {
            nbKidnappedLady++;
            talk("Enfin, je t'attrape " + girl.name);
            girl.getKidnapped(this);
      }

      /**
       * s'echapper de prison
       */
      @Override
      public void escape() {
            if (this.isInJail) {
                  isInJail = false;
                  action(this.name + " s'échappe");
                  talk("Enfin!");
                  this.goOut();
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

}
