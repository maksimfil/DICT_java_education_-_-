package CoffeeMachine;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String user_action = scanner.nextLine();
            label:
            switch (user_action) {
                case "fill" -> machine.fill();
                case "take" -> machine.take();
                case "remaining" -> machine.status_machine();
                case "exit" -> System.exit(0);
                case "buy" -> {
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back-to main menu:");
                    String user_coffee = scanner.nextLine();
                    switch (user_coffee) {
                        case "back":
                            break label;
                        case "1":
                            Coffee.making_coffee(1, machine);
                            break;
                        case "2":
                            Coffee.making_coffee(2,machine);
                            break;
                        case "3":
                            Coffee.making_coffee(3,machine);
                            break;
                    }
                }
            }
        }while (true);
    }
}
