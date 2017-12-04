package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Julie Robillart
 */
public class Bar extends Lieux {

      Boolean open;
      MainStreet out;
      Barman barman;
      Jail jail;

      /**
       *
       * @param open true si le bar est ouvert
       * @param out objet de type MainStreet correspondant à la rue devant le bar
       * @param barman Humain de type Barman qui sert
       * @param name nom de la prison
       * @param people liste des gens à l'intérieur
       */
      public Bar(Boolean open, MainStreet out, Barman barman, String name, ArrayList people) {
            super(name, people);
            this.open = open;
            this.out = out;
            this.barman = barman;
      }

      /**
       * permet de récuperer le personnage qui sert
       *
       * @return le barman de type Barman
       */
      public Barman getBarman() {
            return barman;
      }

      /**
       * permet d'ouvrir le bar
       */
      public void opening() {
            barman.lieu.exit(barman);
            open = true;
            entrer(barman);
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
