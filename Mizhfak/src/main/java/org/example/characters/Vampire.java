package org.example.characters;

public class Vampire extends Warrior {
    final static int ATTACK = 4;
    private int hp = 40;
    private final int vampirism = 50; //percent

    @Override
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return vampirism;
    }

  @Override
    public void hit(Warrior opponent) {
        var oldOpponentHp = opponent.getHp();
        super.hit(opponent);
        var newOpponentHp = opponent.getHp();
        int differenceHp = oldOpponentHp - newOpponentHp;
        var health = getHp() + (differenceHp * getVampirism()) / 100;
        setHp(health);
         //setHp(getHp() + (/*getAttack()*/h3 * getVampirism()) / 100);
       /* if(heakth > getHp()) {
           heakth = getHp();
           setHp(heakth);
        } else {
           setHp(Math.max(0, heakth));
        }*/
    }

    @Override
    protected void damage(int damageUnits) {
        setHp(getHp() - damageUnits);
    }

}
