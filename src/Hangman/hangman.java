package Hangman;

import java.util.*;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> words = new ArrayList<>();
        words.add("python");
        words.add("java");
        words.add("javascript");
        words.add("kotlin");
        String correct_word = words.get(random.nextInt(words.size()));
        System.out.println("HANGMAN");
        String[] syms = correct_word.split("");
        for (int i = 2;i<syms.length;i++){
            syms[i] = "-";
        }
        String hint_word = String.join("",syms);
        System.out.format("Guess the word %s: ",hint_word);
        String user_lang = scanner.nextLine();
        if (!Objects.equals(user_lang, correct_word)){
            System.out.println("You lost!");
        }else{
            System.out.println("You survived!");
        }
    }
}
