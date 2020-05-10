package ForFun.PlayingWithSeries;

import java.util.Scanner;

//This is the easy version of coffee machine
public class CoffeeMachine {
    protected static int water = 400;
    protected static int milk = 540;
    protected static int coffeeBeans = 120;
    protected static int disposableCups = 9;
    protected static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            System.out.println();
            new CoffeeMachineActions(action);
            System.out.println();
        }
    }

    protected static void checkStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}

class CoffeeMachineActions {
    Scanner scanner = new Scanner(System.in);

    CoffeeMachineActions(String action) {
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                CoffeeMachine.checkStatus();
                break;
            case "exit":
                System.exit(0);
        }


    }

    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String action = scanner.nextLine();
        if (!action.equals("back")) {
            String missingIngredient = ingredientCheck(Integer.parseInt(action));
            if (missingIngredient.equals("")) {
                System.out.println("I have enough resources, making you a coffee!");
                makeCoffee(Integer.parseInt(action));
            } else {
                System.out.println("Sorry, not enough " + missingIngredient + "!");
            }
        }
    }

    String ingredientCheck(int type){
        if (CoffeeMachine.disposableCups == 0)
            return "disposable cups";

        switch (type) {
            case 1:
                if (CoffeeMachine.water - 250 < 0)
                    return "water";
                if (CoffeeMachine.coffeeBeans - 16 < 0)
                    return "coffee beans";
                break;
            case 2:
                if (CoffeeMachine.water - 350 < 0)
                    return "water";
                if (CoffeeMachine.milk - 75 < 0)
                    return "milk";
                if (CoffeeMachine.coffeeBeans - 20 < 0)
                    return "coffee beans";
                break;
            case 3:
                if (CoffeeMachine.water - 200 < 0)
                    return "water";
                if (CoffeeMachine.milk - 100 < 0)
                    return "milk";
                if (CoffeeMachine.coffeeBeans - 12 < 0)
                    return "coffee beans";
                break;
            default:
        }
        return "";
    }

    void makeCoffee(int type){
        switch (type) {
            case 1:
                CoffeeMachine.water -= 250;
                CoffeeMachine.coffeeBeans -= 16;
                CoffeeMachine.money += 4;
                CoffeeMachine.disposableCups--;
                break;
            case 2:
                CoffeeMachine.water -= 350;
                CoffeeMachine.milk -= 75;
                CoffeeMachine.coffeeBeans -= 20;
                CoffeeMachine.money += 7;
                CoffeeMachine.disposableCups--;
                break;
            case 3:
                CoffeeMachine.water -= 200;
                CoffeeMachine.milk -= 100;
                CoffeeMachine.coffeeBeans -= 12;
                CoffeeMachine.money += 6;
                CoffeeMachine.disposableCups--;
                break;
            default:
                break;
        }
    }

    void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        CoffeeMachine.water += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        CoffeeMachine.milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        CoffeeMachine.coffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        CoffeeMachine.disposableCups += scanner.nextInt();
    }

    void take() {
        System.out.println("I gave you $" + CoffeeMachine.money);
        CoffeeMachine.money = 0;
    }
}

