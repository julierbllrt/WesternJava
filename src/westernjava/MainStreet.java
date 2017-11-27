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


    public MainStreet(String name, ArrayList people) {
        super(name, people);
    }
    
    @Override
    public void exit(Humain perso){
        people.remove(perso);
    }
    
    @Override
    public void entrer(Humain perso){
        people.add(perso);
        perso.lieu=this;
    }
    
}