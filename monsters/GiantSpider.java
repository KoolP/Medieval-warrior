package monsters;

import main.Game;

public class GiantSpider extends Monster {
    /**
     * Instance of Monster
     *
     * @param name
     * @param hp
     * @param exp
     */

    public GiantSpider(String name, int hp, int exp) {
        super(name, 35, 60);
    }

    public void takeDamage(int damage) {super.takeDamage(damage);}

    @Override
    public int attack() {return super.attack();}

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public int getExp() {
        return 0;
    }

    //test this
    @Override
    public int givExp() {
        return 0;
    }

    @Override
    public void makeSound() {

        int random = randomHelper.randomtwo();
        if (random == 0) {
            System.out.println("Giant spider whispers: *kill " + Game.playern.getName() + " stranger*");
        }else {
            System.out.println("Giant spider makes strange noice: *rrrr rrgh*");
        }
    }

    //extra methods
    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

}
