package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water you want to add:");
        int filled_water = scanner.nextInt();
        this.water = this.water + filled_water;
        System.out.println("Write how many ml of milk you want to add:");
        int filled_milk = scanner.nextInt();
        this.milk = this.milk +filled_milk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int filled_beans = scanner.nextInt();
        this.beans = this.beans + filled_beans;
        System.out.println("Write how many disposable coffee cups you want to add:");
        int filled_cups = scanner.nextInt();
        this.cups = this.cups + filled_cups;
    }
    public void status_machine() {
        System.out.println("\nThe coffee machine has:");
        System.out.format("%d of water\n", this.water);
        System.out.format("%d of milk\n", this.milk);
        System.out.format("%d of coffee beans\n", this.beans);
        System.out.format("%d of disposable cups\n", this.cups);
        System.out.format("%d of money\n\n", this.money);
    }
    public void take(){
        System.out.format("I gave you %d\n\n",this.money);
        this.money = 0;
    }
}
