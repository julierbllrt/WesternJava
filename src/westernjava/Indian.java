/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain de type Indian
 *
 * @author Julie Robillart
 */
public class Indian extends Humain {

      int nbFeather;
      String totem;

      /**
       * construtor
       *
       * @param nbFeather nombre de plume sur sa coiffe
       * @param totem nom de son totem
       * @param name nom du personnage
       * @param favoriteDrink boisson favorite du personnage
       * @param lieu lieu actuel du personnage
       */
      public Indian(int nbFeather, String totem, String name, String favoriteDrink, Lieux lieu) {
            super(name, favoriteDrink, lieu);
            this.nbFeather = nbFeather;
            this.totem = totem;
      }

      /**
       * met en forme lors que le personnage parle
       *
       * @param blablabla ce qu'il dit
       */
      @Override
      public void talk(String blablabla) {
            System.out.println("L'indien " + name + ": " + blablabla);
      }

      /**
       * le personnage se présente
       */
      @Override
      public void introduceYourself() {
            action(this.name + " se présente.");
            talk("Bonjour visage pâle, mon nom est " + name + " " + totem + ". Je fais partie de la tribu à la sortie de la ville.");
      }

}
