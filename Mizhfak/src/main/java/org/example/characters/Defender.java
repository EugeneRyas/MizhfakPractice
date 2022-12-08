package org.example.characters;

public class Defender extends Warrior {
    private int hp = 60;
    final static int ATTACK = 3;
    private int defence = 2;

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefence() {
        return defence;
    }

    /*private void setDefence(int defence) {
        this.defence = defence;
    }*/

    @Override
    protected void damage(int damageUnits) {
        if(damageUnits > getDefence()) {
            setHp(getHp() - (damageUnits - getDefence()));
        }
    }

    @Override
    public String toString() {
        return "%s = {health = %d, attack = %d, defence = %d}".formatted(getClass().getSimpleName(), getHp(), getAttack(), getDefence());
    }
}
