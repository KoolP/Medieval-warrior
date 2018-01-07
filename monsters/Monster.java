package monsters;

import main.RandomHelper;

public abstract class Monster implements IMonster {
    private String name;
    private int hp, exp;
    private boolean isDead = true;
    public static RandomHelper randomHelper = new RandomHelper();


    /**
     * Instance of Monster
     * @param name
     * @param hp
     * @param exp
     */
    public Monster(String name, int hp, int exp) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
    }

    /**
     * Randomized attack
     */
    public int attack() {
        makeSound();
        int attack = randomHelper.attackStrength(25,5);
        System.out.println("You are attacked, and suffer " + attack + " damage");
        return attack;
    }

    /**
     * Damages Hp + is alive checker
     */
    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0) {
            isDead = false;
        }
    }
    /**
     * isDead is alive check
     * @return
     */
    public boolean getisDead() {return isDead;}

    /**
     * Hp check
     */
    public int getHp() { return this.hp; }

    /**
     * name check
     */
    public String getName() { return this.name; }

    /**
     * Set name for monster
     */
    public void setName(String name) {this.name = name;}

    /**
     * Check exp and give exp
     */
    public int giveExp() {return this.exp;}

    /**
     * sound check
     */
    public void makeSound() {

    }
}