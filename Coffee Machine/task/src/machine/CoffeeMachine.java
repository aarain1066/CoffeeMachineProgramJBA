package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static String userBuyChoice;
    static int waterLoaded = 400;
    static int milkLoaded = 540;
    static int coffeeBeansLoaded = 120;
    static int cupsLoaded = 9;
    static long moneyOnHand = 550;

    public static void main(String[] args) {

        String userChoice;
        do {
            // Ask user for choice
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            userChoice = scanner.next();
            switch (userChoice) {
                case ("buy"):
                    optionBuy();
                    break;
                case ("fill"):
                    optionFill();
                    break;
                case ("take"):
                    optionTake();
                    break;
                case ("remaining"):
                    machineStatus();
                    break;
            }
        } while (!userChoice.matches("exit"));
        // Proper exit?
        System.exit(0);
    }
    private static void machineStatus() {
            System.out.println("The coffee machine has:\n"
                    + waterLoaded + " ml of water\n"
                    + milkLoaded + " ml of milk\n"
                    + coffeeBeansLoaded + " g of coffee beans\n"
                    + cupsLoaded + " disposable cups\n" +
                    "$" + moneyOnHand + " of money\n"
            );
    }

    private static void optionBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        /* User enters choice of coffee wanted. Each option takes a different amount of ingredients and money. So
        it's best to break this down into a switch statement in order to go ahead and make the options more streamlined.
        */

        userBuyChoice = scanner.next();

        switch (userBuyChoice){
            case ("1"):
                if (insufficientResources(waterLoaded, 250)){
                    System.out.println("Sorry, not enough water!\n");
                    break;
                }
                if (insufficientResources(coffeeBeansLoaded, 16)){
                    System.out.println("Sorry, not enough coffee!\n");
                    break;
                }
                if (insufficientResources(cupsLoaded, 1)){
                    System.out.println("Sorry, not enough cups!\n");
                    break;
                }
                // If there are sufficient resources, then you will make it down here
                System.out.println("I have enough resources, making you a coffee!\n");
                waterLoaded -= 250;
                coffeeBeansLoaded -= 16;
                cupsLoaded -= 1;
                moneyOnHand += 4;
                break;
            case ("2"):
                if (insufficientResources(waterLoaded, 250)){
                    System.out.println("Sorry, not enough water!\n");
                    break;
                }
                if (insufficientResources(milkLoaded, 75)){
                    System.out.println("Sorry, not enough milk!\n");
                    break;
                }
                if (insufficientResources(coffeeBeansLoaded, 16)){
                    System.out.println("Sorry, not enough coffee!\n");
                    break;
                }
                if (insufficientResources(cupsLoaded, 1)){
                    System.out.println("Sorry, not enough cups!\n");
                    break;
                }
                // If there are sufficient resources, then you will make it down here
                System.out.println("I have enough resources, making you a coffee!\n");
                waterLoaded -= 350;
                milkLoaded -= 75;
                coffeeBeansLoaded -= 20;
                cupsLoaded -= 1;
                moneyOnHand += 7;
                break;
            case ("3"):
                if (insufficientResources(waterLoaded, 250)){
                    System.out.println("Sorry, not enough water!\n");
                    break;
                }
                if (insufficientResources(milkLoaded, 75)){
                    System.out.println("Sorry, not enough milk!\n");
                    break;
                }
                if (insufficientResources(coffeeBeansLoaded, 16)){
                    System.out.println("Sorry, not enough coffee!\n");
                    break;
                }
                if (insufficientResources(cupsLoaded, 1)){
                    System.out.println("Sorry, not enough cups!\n");
                    break;
                }
                // If there are sufficient resources, then you will make it down here
                System.out.println("I have enough resources, making you a coffee!\n");
                waterLoaded -= 200;
                milkLoaded -= 100;
                coffeeBeansLoaded -= 12;
                cupsLoaded -= 1;
                moneyOnHand += 6;
                break;
            case ("back"):
                break;
        }
    }
    private static void optionFill() {
        System.out.println("Write how many ml of water you want to add:");
        waterLoaded += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkLoaded += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansLoaded += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cupsLoaded += scanner.nextInt();
    }
    private static void optionTake() {
        System.out.println("I gave you $" + moneyOnHand + "\n");
        moneyOnHand -= moneyOnHand;
    }

    public static boolean insufficientResources(int amountOnHand, int amountNeeded){
        if (amountOnHand - amountNeeded < 0){
            return true;
        }
        else return false;
    }


}
