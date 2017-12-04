/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Julie Robillart
 */
public abstract class Lieux {

      String name;
      ArrayList<Humain> people = new ArrayList();

      /**
       * constructor
       *
       * @param name nom du lieux
       * @param people liste des gens dans ce lieux
       */
      public Lieux(String name, ArrayList<Humain> people) {
            this.name = name;
            this.people = people;
      }

      /**
       * permet à un personnage d'entrer dans le lieux
       *
       * @param perso personnage qui entre dans le lieu
       */
      public abstract void entrer(Humain perso);

      /**
       * permet a un personnage de quitter le lieu
       *
       * @param perso personnage qui quitte le lieu
       */
      public abstract void exit(Humain perso);

}
