package main;

import java.util.Scanner;

import monsters.CyborgVampire;
import monsters.GiantSpider;
import monsters.IMonster;

public class Game {

	// Keeps track of when we should abort main loop
	private boolean lostGame, wonGame;
	// Handles input
	private Scanner sc;
	private static RandomHelper randomHelper = new RandomHelper();
	public static Player playern;
	private CyborgVampire cyborgVampire;
	private GiantSpider giantSpider;
	private Game game;
	private Tavern tavern = new Tavern();

	/**
	 * Creates a new Game.
	 */
	public Game() {
		sc = new Scanner(System.in);
	}

	/**
	 * Game welcome message, player creation and menu locics.
	 */
	public void startGame() {
		System.out.println("************************");
		System.out.println("* Medieval Warriors *\n* the adventure *");
		System.out.println("************************");
		System.out.print("Enter your name: ");

		this.playern = new Player(sc.nextLine());
		System.out.println("************************");
		System.out.println("Welcome " + playern.getName() + " The Warrior\n");
		
		int input = -1;
		while (!wonGame && !lostGame) {
			printMainMenu();
			System.out.print("> ");
			input = sc.nextInt();
			sc.nextLine();
			switch(input) {
				case 1:
					goAdventure();
					break;
				case 2:
					goToTavern();
					break;
				case 3:
					goCharacter();
					break;
				case 4:
					System.out.println("Bye!");
					lostGame = true;
					break;
			}
		}
		
		if (wonGame) {
			System.out.println("Congratulations! You won The Game!");
		}

	}
	
	/**
	 * Prints all menu options
	 */
	private void printMainMenu() {
		System.out.println("1. Go adventuring");
		System.out.println("2. Enter tavern");
		System.out.println("3. Show details about your character");
		System.out.println("4. Exit game");
	}
	
	/**
	 * First menu option - fighting monsters and storyboards
	 */
	private void goAdventure() {

		int experience = playern.getExp();
		int random = randomHelper.randomten();

		/**
		 * Random part that starts with 10% occurance when user chooses goAdventuring()
		 */
		if (random == 0) {
			System.out.println("You see nothing but unicorns running in the swaying grass..");
			System.out.println("[press enter to continue]");
			sc.nextLine();
		}

		/**
		 * Chooses storyboard and battle depending on experience level
		 */
		if (experience >= 40) {
			StoryboardTwo.leveltwo();
			battleSpider();
		}else {
			Storyboard.intro();
			battleVampire();
		}
		}

	/**
	 * User winns if experience raises abow 100.
	 */
	public void topScore() {
		if (playern.getExp() >= 100) {
			System.out.println("You become a Warrior and win the game");
			System.exit(0);
		}
	}

	/**
	 * Simulate a battle between player and given monster. Handles all side effects, like death, leveling up to and so on
	 * //not used: public void battle(IMonster monster)
	 */
	  public void battleVampire() {

	  	Player playern = this.playern;
		cyborgVampire = new CyborgVampire("Cyborg Vampire");
		System.out.println("*shivers* It is the evil Cyber Vampire");
		System.out.println("[press enter to fight]");
		sc.nextLine();

		while (true) {
			cyborgVampire.takeDamage(playern.attack());
			if (!cyborgVampire.getisDead()) {
				System.out.println("You killed the Cyborg Vampire, earned " + cyborgVampire.giveExp() + " experience");
				playern.setExp(cyborgVampire.giveExp());
				playern.afterBattleStats();
				//playern.restoreHpAfterBattle();
				System.out.println();
				break;
			}
			Game.playern.takeDamage(cyborgVampire.attack());
			if (!Game.playern.getIsAlive()){
				System.out.println("You are killed");
				System.out.println("You have lost the game and turn into warrior zombie");
				playern.afterBattleStats();
				break;
				//System.exit(0);
			}

			System.out.println("* " + playern.getName() + ": " + playern.getHp() + " hp");
			System.out.println("* " + cyborgVampire.getName() + ": " + cyborgVampire.getHp() + " hp");
			System.out.println("[press enter to continue]");
			sc.nextLine();
		}
		  topScore();
	}

	//Simulate battle with second level monster
	public void battleSpider() {

		Player playern = this.playern;
		giantSpider = new GiantSpider("Giant spider", 35, 60); //Bad way to initiate with hp and exp, see new cyborgvampire
		System.out.println("*gosh* this monster is dangerous");
		System.out.println("[press enter to fight]");
		sc.nextLine();

		while (true) {
			giantSpider.takeDamage(playern.attack());
			if (!giantSpider.getisDead()) {
				System.out.println("You kill the Giant spider, earned " + giantSpider.giveExp() + " experience");
				playern.setExp(giantSpider.giveExp());
				playern.afterBattleStats();
				//playern.restoreHpAfterBattle();
				System.out.println();
				break;
			}
			playern.takeDamage(giantSpider.attack());
			if (!playern.getIsAlive()){
				System.out.println("You are killed");
				System.out.println("You have lost the game");
				playern.afterBattleStats();
				break;
				//System.exit(0);
			}

			System.out.println("* " + playern.getName() + ": " + playern.getHp() + " hp");
			System.out.println("* " + giantSpider.getName() + ": " + giantSpider.getHp() + " hp");
			System.out.println("[press enter to continue]");
			sc.nextLine();
		}

		topScore();
	}

	public void goToTavern() {
		tavern.goTavern();
	}

	/**
	 * Second menu option - show details about character
	 */
	private void goCharacter() {
		// TODO print player
		System.out.println("***");
		System.out.println( "Warrior: " + playern.getName());
		System.out.println("Level: " + playern.getLevel());
		System.out.println("Experience: " + playern.getExp());
		System.out.println("HP " + playern.getHp());
		System.out.println("***");
	}

	/**
	 * Pauses the game, waiting for an enter keypress, helper method.
	 */
	private void pause() {
		// TODO
	}
	
}
