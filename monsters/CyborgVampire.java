package monsters;

public class CyborgVampire extends Monster {

    /**
     * Instance of Monster, monster
     *
     * @param nam
     * @param hp
     * @param exp
     */

    //Comment. co
    //Test comment

    public CyborgVampire() { super("Bob", 40, 40);}

    public CyborgVampire(String name) {
        super(name, 40, 40);
    }


    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public boolean isDead() {
        return false;
    }


    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getExp() {
        return 0;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int giveExp() {
        return super.giveExp();
    }

    @Override
    public void makeSound() {

        int random = randomHelper.randomtwo();
        if (random == 0) {
            System.out.println("Cyber Vampire screams: *blood*");
            //sc.nextLine();
        }else {
                System.out.println("Cyber Vampire moans: *kshh*");
            }
        }

    @Override
    public int givExp() {
        return 0;
    }

}
