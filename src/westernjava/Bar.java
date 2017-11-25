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
    
    public Bar(Boolean open, String name, ArrayList people, MainStreet out) {
        super(name, people);
        this.open = open;
        this.out = out;
    }
    
    public void Opening(){
        Barman pierre = new Barman("Pierre", "rhum",this);
        open=true;
        people.add(pierre);
    }
    
    @Override
    public void Exit(Humain perso){
        people.remove(perso);
        out.Entrer(perso);
    }
    
    @Override
    public void Entrer(Humain perso){
        perso.lieu = this;
        people.add(perso);
    }
    
}
