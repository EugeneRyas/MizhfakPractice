package org.example.characters;

public class Warrior {
    static final int ATTACK = 5;
    private int hp;
    private Warrior behind;
    private final int initialHp;

    public Warrior() {
        this(50);
    }

    protected Warrior(int initHealth) {
        initialHp = hp = initHealth;
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    private void setHp(int hp) {
        this.hp = Math.min(getInitialHp(), hp);
    }

    private int getInitialHp() {
        return initialHp;
    }

    protected void damage(int damageUnits) {
        setHp(getHp() - damageUnits);
    }

    public void hit(Warrior opponent) {
        opponent.damage(getAttack());
        processCommand(ChampionHasHit.INSTANCE, null);
    }

    @Override
    public String toString() {
        return "%s = {health = %d, attack = %d}".formatted(getClass().getSimpleName(), getHp(), getAttack());
    }

    protected Warrior getBehind() {
        return behind;
    }

    public void setBehind(Warrior warrior) {
        behind = warrior;
    }

    protected void processCommand(Command command, Warrior sender) {
        var next = getBehind();
        if(next != null) next.processCommand(command, this);
    }

    protected void healBy(int fewHp) {
        setHp(getHp() + fewHp);
    }
}
