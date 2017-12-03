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
public class Thug extends Humain implements OutTheLaw{
    int nbKidnappedLady;
    int reward;
    String look;
    boolean isInJail;

      /**
       *
       * @param nbKidnappedLady
       * @param reward
       * @param look
       * @param isInJail
       * @param name
       * @param favoriteDrink
       * @param lieu
       */
      public Thug(int nbKidnappedLady, int reward, String look, boolean isInJail, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.nbKidnappedLady = nbKidnappedLady;
        this.reward = reward;
        this.look = look;
        this.isInJail = isInJail;
    }
   
      /**
       *
       */
      @Override
    public void escape(){
        if(this.isInJail){
            isInJail = false;
            action(this.name+" s'échappe");
            talk("Je suis liiibre!!!");
            this.goOut();
        }
    }
    
      /**
       *
       */
      @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("J'suis "+ name +". Je vais mettre cette ville à feu et à sang.");
    }

      /**
       *
       * @param girl
       */
      @Override
    public void kidnappedLady(Lady girl) {
        if(!girl.isKidnapped){
            action(this.name+" kidnappe "+girl.name);
            talk(girl.name+", tu es à moi maintenant!");
            nbKidnappedLady++;
            girl.getKidnapped(this);
        }        
    }

      /**
       *
       * @param boy
       * @param lieux
       */
      @Override
    public void getInJail(Sherif boy, Lieux[] lieux){
        action(boy.name+" a mis "+this.name+" en prison");
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
    public void addReward(int money) {
        reward+=money;
        action("money="+reward);
    }
    
}
