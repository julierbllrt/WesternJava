/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public abstract class Lieux {

    String name;
    ArrayList<Humain> people = new ArrayList();

      /**
       *
       * @param name
       * @param people
       */
      public Lieux(String name, ArrayList<Humain> people) {
        this.name = name;
        this.people = people;
    }

      /**
       *
       * @param perso
       */
      public abstract void entrer(Humain perso);

      /**
       *
       * @param perso
       */
      public abstract void exit(Humain perso);

}
