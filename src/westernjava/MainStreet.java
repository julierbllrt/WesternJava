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
public class MainStreet extends Lieux{
    Jail jail;

      /**
       *
       * @param name
       * @param people
       */
      public MainStreet( String name, ArrayList<Humain> people) {
        super(name, people);
        this.jail = jail;
    }
    
      /**
       *
       * @param perso
       */
      @Override
    public void exit(Humain perso){
        people.remove(perso);
    }
    
      /**
       *
       * @param perso
       */
      @Override
    public void entrer(Humain perso){
        perso.lieu=this;
        people.add(perso);
    }

   
    
}