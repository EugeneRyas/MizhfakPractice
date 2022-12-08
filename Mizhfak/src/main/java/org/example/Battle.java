package org.example;

import org.example.characters.Vampire;
import org.example.characters.Warrior;

public class Battle {
    public static boolean fight(Warrior w1, Warrior w2) {
       while (w1.isAlive() && w2.isAlive()) {
            w1.hit(w2);
            if(w2.isAlive()) w2.hit(w1);
        }
       return w1.isAlive();
        /*while(true) {
            if (w1.isAlive()) {
                w1.hit(w2);
            } else {
                break;
            }
            if(w2.isAlive()) {
                w2.hit(w1);
            } else {
                break;
            }
        }
        return w1.isAlive();*/
    }

    public static boolean fight(Army army1, Army army2) {
        var w1 = army1.firstAlive();
        var w2 = army2.firstAlive();
        while(w1.hasNext() && w2.hasNext()) {
            fight(w1.next(), w2.next());
        }
        return w1.hasNext();


          /*while(army1.peekFirst() != null && army2.peekFirst() != null)  {
            var warrior1 =  army1.peekFirst();
            var warrior2 = army2.peekFirst();
           // fight(a, b);
            //a.hit(b);
              boolean warrior1IsAlive = fight(warrior1, warrior2);
            if(!warrior1IsAlive) {
                army1.deleteFirst();
            } else {
                army2.deleteFirst();
            }*/



           /* if (!a.isAlive()) {
                army1.deleteFirst();
            } else if (army1.peekFirst() == null) {
                break;
            }
            b.hit(a);
            if (!b.isAlive()) {
                army2.deleteFirst();
            } else if (army2.peekFirst() == null) {
                break;
            }*/
        //}
        //return army1.peekFirst() != null;
    }
}
