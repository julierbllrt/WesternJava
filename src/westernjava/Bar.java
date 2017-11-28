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
public class Bar extends Lieux{
    Boolean open;
    MainStreet out;
    Barman barman;

    public Bar(Boolean open, MainStreet out, Barman barman, String name, ArrayList people) {
        super(name, people);
        this.open = open;
        this.out = out;
        this.barman = barman;
    }
    
    public Barman getBarman(){
        return barman;
    }
    
    
    public void opening(){
        barman.lieu.exit(barman);
        open=true;
        entrer(barman);
    }
    
    @Override
    public void exit(Humain perso){
        people.remove(perso);
        out.entrer(perso);
    }
    
    @Override
    public void entrer(Humain perso){
        perso.lieu = this;
        people.add(perso);
    }
    
}
