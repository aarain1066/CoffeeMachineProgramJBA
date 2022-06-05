package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int waterLoaded = 400;
    static int milkLoaded = 540;
    static int coffeeBeansLoaded = 120;
    static int cupsLoaded = 9;
    static long moneyOnHand = 550;

    public static void main(String[] args) {

        // Values of coffee machine at start
        machineStatus();

        // Ask user for choice
        System.out.println("Write action (buy, fill, take):");

        String userChoice = scanner.nextLine();

        switch (userChoice){
            case ("buy"):
                optionBuy();
                break;
            case ("fill"):
                optionFill();
                break;
            case ("take"):
                optionTake();
        }
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
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        /* User enters choice of coffee wanted. Each option takes a different amount of ingredients and money. So
        it's best to break this down into a switch statement in order to go ahead and make the options more streamlined.
        */

        String beverageChoice = scanner.next();

        switch (beverageChoice){
            case ("1"):
                waterLoaded -= 250;
                coffeeBeansLoaded -= 16;
                cupsLoaded -= 1;
                moneyOnHand += 4;
                machineStatus();
                break;
            case ("2"):
                waterLoaded -= 350;
                milkLoaded -= 75;
                coffeeBeansLoaded -= 20;
                cupsLoaded -= 1;
                moneyOnHand += 7;
                machineStatus();
                break;
            case ("3"):
                waterLoaded -= 200;
                milkLoaded -= 100;
                coffeeBeansLoaded -= 12;
                cupsLoaded -= 1;
                moneyOnHand += 6;
                machineStatus();
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
        machineStatus();
    }
    private static void optionTake() {
        System.out.println("I gave you $" + moneyOnHand + "\n");
        moneyOnHand -= moneyOnHand;
        machineStatus();
    }

}
