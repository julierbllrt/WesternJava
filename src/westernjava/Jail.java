package westernjava;

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Jail extends Lieux {

    MainStreet out;

    public Jail(MainStreet out, String name, ArrayList<Humain> people) {
        super(name, people);
        this.out = out;
    }

    @Override
    public void exit(Humain perso) {
        people.remove(perso);
        out.entrer(perso);
    }

    @Override
    public void entrer(Humain perso) {
        perso.lieu = this;
        people.add(perso);
    }

    
}
