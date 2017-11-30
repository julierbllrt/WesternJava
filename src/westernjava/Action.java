
package westernjava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
public class Action {
    Random random =new Random();
    Perso perso = new Perso();

    public Action() {
    }
    
     
    public Lady lady(int choice, Lady obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list) { 
        try {
            int chiffre;
            System.out.println(obj.getClass());
            Scanner scanner = new Scanner(System.in);
            String input;
            switch (choice) {
                case 0:
                    chiffre=random.nextInt(3);
                    break;
                    
                case 1:
                    System.out.println("Taper le numero de l'action que vous voulez.");
                    System.out.println("0 se faire kidnapper");
                    System.out.println("1 se faire libérer");
                    System.out.println("2 changer de culotte");
                    System.out.println("3 se présenter");
                    input = scanner.nextLine();
                    chiffre = Integer.parseInt(input);
                    break;
                    
                default:
                    if(obj.lieu instanceof MainStreet){
                        //action dispo street
                        System.out.println(obj.name+" est sur "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous voulez.");
                        System.out.println("0 aller dans le bar");
                        System.out.println("1 kidnapper une fille");
                        System.out.println("2 changer de culotte");
                        System.out.println("3 parler à quelqu'un");
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goTo(list_lieux[0]);
                                return obj;
                        }
                    }
                    else if(obj.lieu instanceof Bar){
                        System.out.println(obj.name+" est dans  "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous "
                                + "voulez.");
                        System.out.println("0 sortir");
                        System.out.println("1 kidnapper une fille");
                        System.out.println("2 changer de culotte");
                        System.out.println("3 parler à quelqu'un");
                        System.out.println("4 commander à boire");
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goOut();
                                return obj;
                            case(4):
                                obj.orderADrink(obj.favoriteDrink);
                                return obj;
                        }
                    }
                    else{
                        //action autre
                        System.out.println(obj.name+" est dans "+obj.lieu.name);
                        chiffre=3;
                    }      
            }
            
            switch(chiffre){
                
                case(1):               
                    
                    ThugLady badlady = new ThugLady(0,0,"nouvelle",false,obj.isKidnapped,obj.pantieColor,obj.name,obj.favoriteDrink,obj.lieu);
                    list.get(0).get(0).remove(obj);
                    Lady girl = perso.randomLady(list.get(0));
                    while(girl==obj){
                        girl = perso.randomLady(list.get(0));
                    }
                    badlady.kidnappedLady(girl);
                    int gettojail = random.nextInt(2);
                    if (gettojail==1){
                        Sherif cop = perso.randomSherif(list.get(1));
                        cop.catchAThug(badlady);
                        cop.freeTheLady(girl);
                    }
                    return badlady;
                    
                case(2):
                    obj.getChanged();
                    return obj;
                    
                case(3):
                    Humain someone = perso.randomHumain(0, 0, list);
                    while(someone==obj){
                        someone = perso.randomHumain(0, 0, list);
                    }
                    obj.talkToSomeone(someone);
                    return obj;
                default:
                    throw new Exception("humain inconnu du monde");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return obj;
        }
    }
    
    public ThugLady thuglady(int choice, ThugLady obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list) { 
        try {
            int chiffre;
            System.out.println(obj.getClass());
            Scanner scanner = new Scanner(System.in);
            String input;
            switch (choice) {
                case 0:
                    chiffre=random.nextInt(3);
                    break;
                    
                case 1:
                    System.out.println("Taper le numero de l'action que vous "
                            + "voulez.");
                    System.out.println("0 se faire kidnapper");
                    System.out.println("1 se faire libérer");
                    System.out.println("2 changer de culotte");
                    System.out.println("3 se présenter");
                    input = scanner.nextLine();
                    chiffre = Integer.parseInt(input);
                    break;
                    
                default:
                    if(obj.lieu instanceof MainStreet){
                        //action dispo street
                        System.out.println(obj.name+" est sur "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous "
                                + "voulez.");
                        System.out.println("0 aller dans le bar");
                        System.out.println("1 kidnapper une fille");
                        System.out.println("2 changer de culotte");
                        System.out.println("3 parler à quelqu'un");
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goTo(list_lieux[0]);
                                break;
                        }
                    }
                    else if(obj.lieu instanceof Bar){
                        System.out.println(obj.name+" est dans  "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous "
                                + "voulez.");
                        System.out.println("0 sortir");
                        System.out.println("1 kidnapper une fille");
                        System.out.println("2 changer de culotte");
                        System.out.println("3 parler à quelqu'un");
                        System.out.println("4 commander à boire");
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goOut();
                                break;
                            case(4):
                                obj.orderADrink(obj.favoriteDrink);
                                break;
                        }
                    }
                    else{
                        //action autre
                        System.out.println(obj.name+" est dans "+obj.lieu.name);
                        chiffre=3;
                    }   break;
                    
                    
                    
            }
            
            switch(chiffre){
                
                case(1):    
                    Lady girl = perso.randomLady(list.get(0));
                    while(girl==obj){
                        girl = perso.randomLady(list.get(0));
                    }
                    obj.kidnappedLady(girl);
                    int gettojail = random.nextInt(2);
                    if (gettojail==1){
                        Sherif cop = perso.randomSherif(list.get(1));
                        cop.catchAThug(obj);
                        cop.freeTheLady(girl);
                    }
                    return obj;
                    
                case(2):
                    obj.getChanged();
                    return obj;
                    
                case(3):
                    Humain someone = perso.randomHumain(0, 0, list);
                    while(someone==obj){
                        someone = perso.randomHumain(0, 0, list);
                    }
                    obj.talkToSomeone(someone);
                    return obj;
                default:
                    throw new Exception("action inconnu");
            }
       
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return obj;
        }
        
      
    }
    
    public Cowboy cowboy(int choice,Cowboy obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        
        try {
            int chiffre;
            System.out.println(obj.getClass());
            Scanner scanner = new Scanner(System.in);
            String input;
            switch (choice) {
                case 0:
                    chiffre=random.nextInt(6);
                    break;
                    
                case 1:
                    System.out.println("Taper le numero de l'action que vous voulez.");
                    System.out.println("0 tirer sur un méchant");
                    System.out.println("1 libere une fille");
                    System.out.println("2 se présenter");
                    input = scanner.nextLine();
                    chiffre = Integer.parseInt(input);
                    break;
                    
                default:
                    if(obj.lieu instanceof MainStreet){
                        //action dispo street
                        System.out.println(obj.name+" est sur "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous voulez.");
                        System.out.println("0 aller dans le bar");
                        System.out.println("1 libérer une fille");
                        System.out.println("2 kidnapper une fille");
                        System.out.println("3 parler à quelqu'un");
                        System.out.println("4 tirer sur un méchant");
                        
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goTo(list_lieux[0]);
                                break;
                        }
                    }
                    else if(obj.lieu instanceof Bar){
                        System.out.println(obj.name+" est dans  "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous voulez.");
                        System.out.println("0 aller dans le bar");
                        System.out.println("1 libérer une fille");
                        System.out.println("2 kidnapper une fille");
                        System.out.println("3 parler à quelqu'un");
                        System.out.println("4 tirer sur un méchant");
                        System.out.println("5 commander un verre");
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goOut();
                                break;
                            case(5):
                                obj.orderADrink(obj.favoriteDrink);
                                break;
                        }
                    }
                    else{
                        //action autre
                        System.out.println(obj.name+" est dans "+obj.lieu.name);
                        chiffre=3;
                    } 
                    break;
                      
            }
            
            switch(chiffre){
                
                case(1):    
                    Lady girl = perso.randomLady(list.get(0));
                    obj.freeTheLady(girl);
                    return obj;
                    
                case(2):
                    BadCop badcop = new BadCop(0,0,"impitoyable",false,obj.popularity,obj.adjective,obj.money,obj.name,obj.favoriteDrink,obj.lieu);
                    list.get(1).get(0).remove(obj);
                    girl = perso.randomLady(list.get(0));
                    badcop.kidnappedLady(girl);
                    
                    int gettojail = random.nextInt(2);
                    if (gettojail==1){
                        Sherif cop = perso.randomSherif(list.get(1));
                        cop.catchAThug(badcop);
                        cop.freeTheLady(girl);
                    }
                    return badcop;
                    
                  
                    
                case(3):
                    Humain someone = perso.randomHumain(0, 0, list);
                    while(someone==obj){
                        someone = perso.randomHumain(0, 0, list);
                    }
                    obj.talkToSomeone(someone);
                    return obj;
                    
                case(4):
                    Thug badboy = (Thug) perso.randomHumain(2, 4, list);
                    System.out.println("C'est une oportunité pour vous! Si voulez le mettre en prison et devenir shérif tapez '1' sinon tapez '2'");
                    input = scanner.nextLine();
                    int becoming = Integer.parseInt(input);
                   
                    switch(becoming){
                        case 1:
                            Sherif cop = new Sherif(0,obj.popularity,obj.adjective,obj.money,obj.name,obj.favoriteDrink,obj.lieu);
                            list.get(1).get(0).remove(obj);
                            cop.shoot(badboy, cop);
                            return cop;
                            
                        default:
                            cop = (Sherif) perso.randomHumain(2, 3, list);
                            obj.shoot(badboy, cop);
                            return obj;
                    }
                    
                default:
                    throw new Exception("action inconnu");
            }
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
            return obj;
        }
        
    }
    
    public Sherif sherif(int choice,Sherif obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        try {
            int chiffre;
            System.out.println(obj.getClass());
            Scanner scanner = new Scanner(System.in);
            String input;
            switch (choice) {
                case 0:
                    chiffre=random.nextInt(6);
                    break;
                    
                case 1:
                    System.out.println("Taper le numero de l'action que vous voulez.");
                    System.out.println("0 tirer sur un méchant");
                    System.out.println("1 libere une fille");
                    System.out.println("2 se présenter");
                    input = scanner.nextLine();
                    chiffre = Integer.parseInt(input);
                    break;
                    
                default:
                    if(obj.lieu instanceof MainStreet){
                        //action dispo street
                        System.out.println(obj.name+" est sur "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous voulez.");
                        System.out.println("0 aller dans le bar");
                        System.out.println("1 libérer une fille");
                        System.out.println("2 kidnapper une fille");
                        System.out.println("3 parler à quelqu'un");
                        System.out.println("4 tirer sur un méchant");
                        
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goTo(list_lieux[0]);
                                break;
                        }
                    }
                    else if(obj.lieu instanceof Bar){
                        System.out.println(obj.name+" est dans  "+obj.lieu.name);
                        System.out.println("Taper le numero de l'action que vous voulez.");
                        System.out.println("0 aller dans le bar");
                        System.out.println("1 libérer une fille");
                        System.out.println("2 kidnapper une fille");
                        System.out.println("3 parler à quelqu'un");
                        System.out.println("4 tirer sur un méchant");
                        System.out.println("5 commander un verre");
                        input = scanner.nextLine();
                        chiffre = Integer.parseInt(input);
                        
                        switch(chiffre){
                            case(0):
                                obj.goOut();
                                break;
                            case(5):
                                obj.orderADrink(obj.favoriteDrink);
                                break;
                        }
                    }
                    else{
                        //action autre
                        System.out.println(obj.name+" est dans "+obj.lieu.name);
                        chiffre=3;
                    } 
                    break;
                      
            }
            
            switch(chiffre){
                
                case(1):    
                    Lady girl = perso.randomLady(list.get(0));
                    obj.freeTheLady(girl);
                    return obj;
                    
                case(2):
                    BadCop badcop = new BadCop(0,0,"impitoyable",false,obj.popularity,obj.adjective,obj.money,obj.name,obj.favoriteDrink,obj.lieu);
                    list.get(1).get(0).remove(obj);
                    girl = perso.randomLady(list.get(0));
                    badcop.kidnappedLady(girl);
                    
                    int gettojail = random.nextInt(2);
                    if (gettojail==1){
                        Sherif cop = perso.randomSherif(list.get(1));
                        cop.catchAThug(badcop);
                        cop.freeTheLady(girl);
                    }
                    return badcop;
                    
                  
                    
                case(3):
                    Humain someone = perso.randomHumain(0, 0, list);
                    while(someone==obj){
                        someone = perso.randomHumain(0, 0, list);
                    }
                    obj.talkToSomeone(someone);
                    return obj;
                    
                case(4):
                    Thug badboy = (Thug) perso.randomHumain(2, 4, list);
                    System.out.println("C'est une oportunité pour vous! Si voulez le mettre en prison et devenir shérif tapez '1' sinon tapez '2'");
                    input = scanner.nextLine();
                    int becoming = Integer.parseInt(input);
                   
                    switch(becoming){
                        case 1:
                            Sherif cop = new Sherif(0,obj.popularity,obj.adjective,obj.money,obj.name,obj.favoriteDrink,obj.lieu);
                            list.get(1).get(0).remove(obj);
                            cop.shoot(badboy, cop);
                            return cop;
                            
                        default:
                            cop = (Sherif) perso.randomHumain(2, 3, list);
                            obj.shoot(badboy, cop);
                            return obj;
                    }
                    
                default:
                    throw new Exception("action inconnu");
            }
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
            return obj;
        }
        
    }
    
    public BadCop badcop(int choice,BadCop obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        if (choice==0){
            chiffre=random.nextInt(2);
        }
        else{
            System.out.println("Taper le numero de l'action que vous voulez.");
            System.out.println("0 tirer sur un méchant");
            System.out.println("1 libere une fille");
            System.out.println("2 se présenter");
            Scanner scanner = new Scanner(System.in);
               
            String input = scanner.nextLine();
            chiffre = Integer.parseInt(input);
            
        }
        
        switch(chiffre){
            case(0):
                if(list.get(2).size()>0&&list.get(1).size()>0){
                    Thug badboy = (Thug) perso.randomHumain(3, 5, list);
                    Sherif cop = (Sherif) perso.randomHumain(3, 3, list);
                    obj.shoot(badboy,cop);
                }
                break;

            case(1):
                Lady girl = (Lady) perso.randomHumain(3,0,list);
                obj.freeTheLady(girl);
                break;

            case(2):
                if (!obj.lieu.people.isEmpty()){
                    Humain someone = perso.randomInList(0, 0, obj.lieu.people);
                    while(someone==obj){
                        someone = perso.randomInList(0, 0, obj.lieu.people);
                    }
                    obj.talkToSomeone(someone);
                }
                else{
                    System.out.println("Vous êtes seul vous ne pouvez parlez qu'à vous même!");
                }

        }
        return obj;
    }
    
    public Thug thug(int choice,Thug obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        if (choice==0){
            chiffre=random.nextInt(2);
        }
        else{
            System.out.println("Taper le numero de l'action que vous voulez.");
            System.out.println("0 s'échapper de la prison");
            System.out.println("1 kidnapper une fille");
            System.out.println("2 se présenter");
            Scanner scanner = new Scanner(System.in);
               
            String input = scanner.nextLine();
            chiffre = Integer.parseInt(input);
            
        }
        
        switch(chiffre){
            case(0):
               obj.escape();
                break;

            case(1):
                Lady girl = perso.randomLady(list.get(0));
                obj.kidnappedLady(girl);
                break;
                   
            case(2):
                if (!obj.lieu.people.isEmpty()){
                    Humain someone = perso.randomInList(0, 0, obj.lieu.people);
                    while(someone==obj){
                        someone = perso.randomInList(0, 0, obj.lieu.people);
                    }
                    obj.talkToSomeone(someone);
                }
                else{
                    System.out.println("Vous êtes seul vous ne pouvez parlez qu'à vous même!");
                }
                break;

        }
        return obj;
    }
    
    public Indian indian(int choice,Indian obj, Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list){ 
        int chiffre;
        if(choice==0){
            //Random random =new Random();
            //chiffre=random.nextInt(0);
            chiffre = 0;
        }
        else{
            System.out.println("Taper le numero de l'action que vous voulez.");
            System.out.println("0 se présenter");
            Scanner scanner = new Scanner(System.in);
               
            String input = scanner.nextLine();
            chiffre = Integer.parseInt(input);
        }
        
        switch(chiffre){             
            case(0):
                if (!obj.lieu.people.isEmpty()){
                    Humain someone = perso.randomInList(0, 0, obj.lieu.people);
                    while(someone==obj){
                        someone = perso.randomInList(0, 0, obj.lieu.people);
                    }
                    obj.talkToSomeone(someone);
                }
                else{
                    System.out.println("Vous êtes seul vous ne pouvez parlez qu'à vous même!");
                }
                
                break;
        }
        return obj;
    }
    
    public Humain humain(int choice, Humain man,Lieux[] list_lieux,
            ArrayList<ArrayList<ArrayList<Humain>>> list) {
    
    
    
        if (man instanceof Lady){
            Lady personnage = (Lady) man;
            personnage = lady(choice,personnage,list_lieux,list);
            return personnage;
        }

        if (man instanceof Cowboy){
            Cowboy personnage = (Cowboy) man;
            cowboy(choice,personnage,list);
            return personnage;
        }

        if (man instanceof Sherif){
            Sherif personnage = (Sherif) man;
            sherif(choice,personnage,list);
            return personnage;
        }

        if (man instanceof BadCop){
            BadCop personnage = (BadCop) man;
            badcop(choice,personnage,list);
            return personnage;
        }

        if (man instanceof Thug){
            Thug personnage = (Thug) man;
            thug(choice,personnage,list);
            return personnage;
        }

        if (man instanceof Indian){
            Indian personnage = (Indian) man;
            indian(choice,personnage,list);
            return personnage;
        }
        
        return man;
    }      
}
