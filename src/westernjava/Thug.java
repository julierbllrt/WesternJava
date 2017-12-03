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

    public Thug(int nbKidnappedLady, int reward, String look, boolean isInJail, String name, String favoriteDrink, Lieux lieu) {
        super(name, favoriteDrink, lieu);
        this.nbKidnappedLady = nbKidnappedLady;
        this.reward = reward;
        this.look = look;
        this.isInJail = isInJail;
    }
   
    
    @Override
    public void escape(){
        if(this.isInJail){
            isInJail = false;
            this.goOut();
            action(this.name+" s'échappe");
            talk("Je suis liiibre!!!");
        }
    }
    
    @Override
    public void introduceYourself(){
        action(this.name+" se présente.");
        talk("J'suis "+ name +". Je vais mettre cette ville à feu et à sang.");
    }

    @Override
    public void kidnappedLady(Lady girl) {
        if(!girl.isKidnapped){
            action(this.name+" kidnappe "+girl.name);
            talk(girl.name+", tu es à moi maintenant!");
            nbKidnappedLady++;
            girl.getKidnapped(this);
        }        
    }

    @Override
    public void getInJail(Sherif boy) {
        action(boy.name+" a mis "+this.name+" en prison");
        talk("Merde! Je me vengerais "+boy.name+"!");
        isInJail=true;
        this.lieu.goToJail(this);
        boy.money+=reward;
    }
    @Override
    public void addReward(int money) {
        reward+=money;
        action("money="+reward);
    }
    
}
