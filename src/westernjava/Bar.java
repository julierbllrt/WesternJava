package westernjava;

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Bar extends Lieux {

    Boolean open;
    MainStreet out;
    Barman barman;
    Jail jail;

      /**
       *
       * @param open
       * @param out
       * @param barman
       * @param name
       * @param people
       */
      public Bar(Boolean open, MainStreet out, Barman barman, String name, ArrayList people) {
        super(name, people);
        this.open = open;
        this.out = out;
        this.barman = barman;
    }

      /**
       *
       * @return
       */
      public Barman getBarman() {
        return barman;
    }

      /**
       *
       */
      public void opening() {
        barman.lieu.exit(barman);
        open = true;
        entrer(barman);
    }

      /**
       *
       * @param perso
       */
      @Override
    public void exit(Humain perso) {
        people.remove(perso);
        out.entrer(perso);
    }

      /**
       *
       * @param perso
       */
      @Override
    public void entrer(Humain perso) {
        perso.lieu = this;
        people.add(perso);
    }

   
}
