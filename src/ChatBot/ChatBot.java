package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Amogus.");
        System.out.println("I was created in 2021.");
        System.out.println("Please, remind me your name.");
        Scanner scanner = new Scanner(System.in);
        String name_user = scanner.nextLine();
        System.out.format("What a great name you have, %s!",name_user);
    }
}
