package org.example.characters;

public class Lancer extends Warrior {
    static final int PIERCING_POWER = 50;

    public Lancer() {
        super(50);
    }

    @Override
    public int getAttack() {
        return 6;
    }

    private int getPiercingPower() {
        return PIERCING_POWER;
    }

    @Override
    public void hit(Warrior opponent) {
        int hpBefore = opponent.getHp();
        super.hit(opponent);
        int hpAfter = opponent.getHp();
        if(opponent instanceof HasWarriorBehind unitInArmy) {
            int damageDealt = hpBefore - hpAfter;
            int damageForNextUnit = damageDealt * getPiercingPower() / 100;
            Warrior next = unitInArmy.getBehind();
            next.damage(damageForNextUnit);
        }
    }
}
