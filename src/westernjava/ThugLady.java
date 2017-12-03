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
public class ThugLady extends Lady implements OutTheLaw{
    int nbKidnappedLady;
    int reward;
    String look;
    Boolean isInJail;

      /**
       *
       * @param nbKidnappedLady
       * @param reward
       * @param look
       * @param isInJail
       * @param isKidnapped
       * @param pantieColor
       * @param name
       * @param favoriteDrink
       * @param lieu
       */
      public ThugLady(int nbKidnappedLady, int reward, String look, Boolean isInJail, 
            boolean isKidnapped, String pantieColor, String name, String favoriteDrink, Lieux lieu) {
        super(isKidnapped, pantieColor, name, favoriteDrink, lieu);
        this.nbKidnappedLady = nbKidnappedLady;
        this.reward = reward;
        this.look = look;
        this.isInJail = isInJail;
    }

      /**
       *
       * @param girl
       */
      @Override
    public void kidnappedLady(Lady girl) {
        nbKidnappedLady++;
        talk("Enfin, je t'attrape "+girl.name);
        girl.getKidnapped(this);
    }
    
      /**
       *
       */
      @Override
    public void escape(){
        if(this.isInJail){
            isInJail = false;
            action(this.name+" s'échappe");
            talk("Enfin!");
            this.goOut();
        }
    }

      /**
       *
       * @param boy
       * @param lieux
       */
      @Override
    public void getInJail(Sherif boy,Lieux[] lieux) {
        talk("Merde! Je me vengerais "+boy.name+"!");
        isInJail=true;
        this.goTo(lieux[1]);
        boy.money+=reward;
    }

      /**
       *
       * @param money
       */
      @Override
    public void addReward(int money){
        reward+=money;
    }
    
    
}
