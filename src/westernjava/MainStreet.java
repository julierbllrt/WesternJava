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

    public MainStreet(Jail jail, String name, ArrayList<Humain> people) {
        super(name, people);
        this.jail = jail;
    }
    
    

    @Override
    public void exit(Humain perso){
        people.remove(perso);
    }
    
    @Override
    public void entrer(Humain perso){
        perso.lieu=this;
        people.add(perso);
    }

    @Override
    public void goToJail(Humain perso) {
        people.remove(perso);
        jail.entrer(perso);
    }
    
}