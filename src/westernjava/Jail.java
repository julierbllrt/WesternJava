package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Julie Robillart
 */
public class Jail extends Lieux {

      MainStreet out;

      /**
       * constructor
       *
       * @param out objet de type MainStreet correspondant à la rue devant la prison
       * @param name nom de la prison
       * @param people liste des gens à l'intérieur
       */
      public Jail(MainStreet out, String name, ArrayList<Humain> people) {
            super(name, people);
            this.out = out;
      }

      /**
       * permet a un personnage de quitter le lieu
       *
       * @param perso personnage qui quitte le lieu
       */
      @Override
      public void exit(Humain perso) {
            people.remove(perso);
            out.entrer(perso);
      }

      /**
       * permet à un personnage d'entrer dans le lieux
       *
       * @param perso personnage qui entre dans le lieu
       */
      @Override
      public void entrer(Humain perso) {
            perso.lieu = this;
            people.add(perso);
      }

}
