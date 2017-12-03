package westernjava;

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Jail extends Lieux {

    MainStreet out;

      /**
       *
       * @param out
       * @param name
       * @param people
       */
      public Jail(MainStreet out, String name, ArrayList<Humain> people) {
        super(name, people);
        this.out = out;
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
