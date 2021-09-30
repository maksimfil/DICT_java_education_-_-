package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Amogus.");
        System.out.println("I was created in 2021.");
        System.out.println("Please, remind me your name.");
        Scanner scanner = new Scanner(System.in);
        String name_user = scanner.nextLine();
        System.out.format("What a great name you have, %s!\n",name_user);
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.format("Your age is %d; that's a good time to start programming!\n",age);
        System.out.println("Now I can prove to you that I can count to any number you want.");
        int user_number = scanner.nextInt();
        for (int i=0;i<user_number+1;i++){
            System.out.format("%d !\n",i);
        }

    }
}
