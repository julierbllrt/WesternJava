package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Julie Robillart
 */
public class MainStreet extends Lieux {

      Jail jail;

      /**
       * constructor
       *
       * @param name nom de la rue
       * @param people liste des gens dans la rue
       */
      public MainStreet(String name, ArrayList<Humain> people) {
            super(name, people);
            this.jail = jail;
      }

      /**
       * permet a un personnage de quitter le lieu
       *
       * @param perso personnage qui quitte le lieu
       */
      @Override
      public void exit(Humain perso) {
            people.remove(perso);
      }

      /**
       * permet à un personnage d'entrer dans le lieux
       *
       * @param perso perso personnage qui entre dans le lieu
       */
      @Override
      public void entrer(Humain perso) {
            perso.lieu = this;
            people.add(perso);
      }

}
