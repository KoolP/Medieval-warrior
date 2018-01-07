package main;

public class Player implements IPlayer{
    private String name;
    private static RandomHelper randomHelper = new RandomHelper();
    private int hp, exp, level;
    private final int maxExp = 100, maxHp = 40;
    private boolean isAlive = true;


    public Player (String name) {
        setName(name);
        setHp(this.maxHp);
        setExp(0);
        setLevel();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getMaxHp() {
        return this.maxHp;
    }

    @Override
    public int getExp() {
        return this.exp;
    }

    @Override
    public void setExp(int exp) {
        this.exp += exp;
        if(this.exp > getMaxExp()) {
            setLevel();
            System.out.println("You leveled up! and are now on level " + this.level);
            this.exp -= maxExp;
        }
    }

    @Override
    public int getMaxExp() {
        return this.maxExp;
    }
    @Override
    public boolean getIsAlive() {
        return isAlive;
    }
    @Override
    public int getLevel() {
        return this.level;
    }
    @Override
    public void setLevel() {
        this.level++;
    }

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0){
            this.isAlive = false;

        }
    }
    @Override
    public void restoreHpAfterBattle() {
        this.hp = this.maxHp;
    }
    @Override
    public int attack() {
        int attack = randomHelper.attackStrength(15,9);
        System.out.println("You hit the monster, dealing " + attack + " damage");
        return attack;
    }
    @Override
    public void afterBattleStats() {
        System.out.println("You are level " + this.level + ", and you have " + this.exp + " exp, and " + this.hp + " hp");
    }


}



