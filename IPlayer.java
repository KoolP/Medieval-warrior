package main;

public interface IPlayer {

	String getName();
	void setName(String name);

	int getHp();
	void setHp(int hp);

	int getMaxHp();

	int getExp();
	void setExp(int exp);

	int getMaxExp();

	int getLevel();
	void setLevel();

	int attack();

	void takeDamage(int damage);
	boolean getIsAlive();

	void restoreHpAfterBattle();

	void afterBattleStats();


}
