package main;

import java.util.Scanner;

public class Tavern {
    private Scanner sc = new Scanner(System.in);
    private int input;
    Player player = Game.playern;

    public void goTavern() {

        System.out.println("* Welcome to the Old Tavern *");

        boolean leaveTavern = false;

        do {
            printTavernMenu();
            System.out.print("> ");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    orderBeer();
                    break;
                case 2:
                    orderStew();
                    break;
                case 3:
                    leaveTavern = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!leaveTavern);

    }

        /**
         * Prints Tavern menu
         */
        private void printTavernMenu() {
            System.out.println("1. Order beer");
            System.out.println("2. Order stew");
            System.out.println("3. Leave tavern");
        }

        private void orderBeer() {
            System.out.println("You sit down at the corner table.");
            System.out.println("A glass of medieval beer named Big Beard is served, the knights are singing.");
        }

         private void orderStew() {
             if (Game.playern.getHp() < 0){
                 System.out.println("We also serve to dead warrior zombies, here is your magic food.");
             }
             Game.playern.restoreHpAfterBattle();
             System.out.println("A medieval stew is served.");
             System.out.println("* You retrieve nutrition and refreshment");
             System.out.println( Game.playern.getName() + " has now " + Game.playern.getHp() + "HP");
         }

         private int leaveTavern() {
             return Game.playern.getHp();
    }

    }


