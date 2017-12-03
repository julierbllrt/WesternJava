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
public interface OutTheLaw {

      /**
       *
       * @param girl
       */
      void kidnappedLady(Lady girl);

      /**
       *
       * @param boy
       * @param lieux
       */
      void getInJail(Sherif boy,Lieux[] lieux);

      /**
       *
       * @param money
       */
      void addReward(int money);

      /**
       *
       */
      void escape();

}
