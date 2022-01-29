package Hangman;

import java.util.*;

public class hangman {
    private String field;
    private String correct_word;
    private int lives = 8;
    private ArrayList used_words  = new ArrayList();

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public ArrayList getUsed_words() {
        return used_words;
    }

    public String getCorrect_word() {
        return correct_word;
    }

    public void setCorrect_word(String correct_word) {
        this.correct_word = correct_word;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void add_to_list(ArrayList<String> array, String user_letter){
        array.add(user_letter);
    }

    public void choice_word() {
        ArrayList<String> words = new ArrayList<>();
        Random random = new Random();
        words.add("python");
        words.add("java");
        words.add("javascript");
        words.add("kotlin");
        this.setCorrect_word(words.get(random.nextInt(words.size())));
    }

    public void start_field() {
        String[] syms = this.getCorrect_word().split("");
        Arrays.fill(syms, "-");
        this.setField(String.join("", syms));
    }

    public void game(String player_letter) {
        if (check_count_include(player_letter,this.getCorrect_word())>1){
            int index_first = this.correct_word.indexOf(player_letter);
            StringBuilder replaced_str = new StringBuilder(this.getField());
            replaced_str.setCharAt(index_first, player_letter.charAt(0));
            this.setField(replaced_str.toString());
            int index_next = this.correct_word.lastIndexOf(player_letter);
            StringBuilder replaced_string = new StringBuilder(this.getField());
            replaced_string.setCharAt(index_next, player_letter.charAt(0));
            this.setField(replaced_string.toString());

        }else {
            int index = this.correct_word.indexOf(player_letter);
            StringBuilder replaced_str = new StringBuilder(this.getField());
            replaced_str.setCharAt(index, player_letter.charAt(0));
            this.setField(replaced_str.toString());
        }
    }

    public int check_count_include(String user_letter,String correct_word){
        ArrayList<Character> symbols = new ArrayList<>();
        for (int i =0;i<this.getCorrect_word().length();i++){
            symbols.add(correct_word.charAt(i));
        }
        int count_letters = Collections.frequency(symbols, user_letter.charAt(0));
        return count_letters;
    }

    public boolean check_lower_eng_letter(String player_letter) {
        if (Character.isLetter(player_letter.charAt(0)) && Character.isLowerCase(player_letter.charAt(0))) {
            return true;
        }
        System.out.println("Please enter a lowercase English letter");
        return false;
    }

    public boolean check_len_letter(String player_letter) {
        if (player_letter.length() < 2){
            return true;
        }else {
            System.out.println("You should input a single letter");
            return false;
        }
    }

    public boolean all_checks(String user_letter){
        return check_len_letter(user_letter) && check_lower_eng_letter(user_letter) &&
                guessed_letter(this.getUsed_words(), user_letter)&& include_letter(user_letter);
    }

    public boolean include_letter(String user_letter){
        if (this.getCorrect_word().contains(user_letter)){
            return true;
        }else {
            System.out.println("That letter doesn't appear in the word\n");
            this.setLives(getLives()-1);
            return false;
        }
    }

    public boolean guessed_letter(ArrayList<String> array,String user_letter){
        if(array.contains(user_letter)){
            System.out.println("You've already guessed this letter\n");
            return false;
        }else {
            return true;
        }
    }

    public boolean check_win(){
        if (Objects.equals(this.getCorrect_word(), this.getField())){
            System.out.format("You guessed the word %s!\n",this.getCorrect_word());
            System.out.println("You survived!");
            System.exit(0);
            return false;
        }return true;
    }


    public static void main(String[] args) {
        hangman hang = new hangman();
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            String user_play_exit = scanner.nextLine();
            if (Objects.equals(user_play_exit, "play")) {
                hang.choice_word();
                hang.start_field();
                do {
                    System.out.println(hang.getField());
                    System.out.print("Input a letter: ");
                    String user_letter = scanner.nextLine();
                    if (hang.all_checks(user_letter)) {
                        hang.game(user_letter);
                        hang.add_to_list(hang.getUsed_words(), user_letter);
                        if (hang.check_win()) {
                            continue;
                        }
                    }
                    hang.add_to_list(hang.getUsed_words(), user_letter);
                    continue;
                } while (hang.lives > 0);
                System.out.println("You lost!");
            } else if (Objects.equals(user_play_exit, "exit")){
                System.exit(0);
            }else {
                continue;
            }
        }
    }
}
