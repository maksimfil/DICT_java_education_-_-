package Hangman;

import java.util.Objects;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        System.out.print("Guess the word: ");
        String user_lang = scanner.nextLine();
        if (!Objects.equals(user_lang, "java")){
            System.out.println("You lost!");
        }else{
            System.out.println("You survived!");
        }
    }
}
