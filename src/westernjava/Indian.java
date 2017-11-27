/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 *
 * @author ISEN
 */
public class Indian extends Humain{
    int nbFeather;
    String totem;
    

    public Indian(int nbFeather, String totem, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.nbFeather = nbFeather;
        this.totem = totem;
    }

    @Override
    public void talk (String blablabla){
        System.out.println("L'indien "+name+": "+blablabla);
    }
    
    @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("Bonjour visage pâle, mon nom est "+name+" "+totem+". Je fais partie de la tribu à la sortie de la ville.");
    }
    
}
