package org.example.characters;

public class Healer extends Warrior {
    private static final int HEAL_POWER = 2;

    public Healer() {
        super(60);
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public void hit(Warrior opponent) {
    }

    public int getHealPower() {
        return HEAL_POWER;
    }

    @Override
    protected void processCommand(Command command, Warrior sender) {
        if(command instanceof ChampionHasHit) heal(sender);
        super.processCommand(command, sender);
    }

    private void heal(Warrior warrior) {
        warrior.healBy(getHealPower());
    }
}
