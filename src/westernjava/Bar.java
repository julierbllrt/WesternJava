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

    public Bar(Boolean open, MainStreet out, Barman barman, String name, ArrayList people) {
        super(name, people);
        this.open = open;
        this.out = out;
        this.barman = barman;
    }

    public Barman getBarman() {
        return barman;
    }

    public void opening() {
        barman.lieu.exit(barman);
        open = true;
        entrer(barman);
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

    @Override
    public void goToJail(Humain perso) {
        people.remove(perso);
        jail.entrer(perso);
    }

}
