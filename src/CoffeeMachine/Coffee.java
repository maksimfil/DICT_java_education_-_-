package CoffeeMachine;

public enum Coffee {
    CAPPUCCINO(200, 100, 12, 1, 6),
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7);

    private final int water, milk, beans, cups, money;

    Coffee(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public static void making_coffee(int num_coffee, CoffeeMachine machine) {
        if (num_coffee == 1) {
            if (checking_coffee(ESPRESSO, machine)) {
                doing_coffee(ESPRESSO, machine);
                System.out.println("I have enough resources, making you a coffee!\n");
            }else {
                System.out.format("Sorry,not enough %s!\n\n", not_enough_comp(ESPRESSO, machine));
            }
        }else if (num_coffee == 2){
            if (checking_coffee(LATTE,machine)) {
                doing_coffee(LATTE, machine);
                System.out.println("I have enough resources, making you a coffee!\n");
            }else {
                System.out.format("Sorry,not enough %s!\n\n", not_enough_comp(LATTE, machine));
            }
        }else{
            if (checking_coffee(CAPPUCCINO,machine)) {
                doing_coffee(CAPPUCCINO, machine);
                System.out.println("I have enough resources, making you a coffee!\n");
            }else {
                System.out.format("Sorry,not enough %s!\n\n", not_enough_comp(CAPPUCCINO, machine));
            }
        }
    }

    public static String not_enough_comp(Coffee num_coffee, CoffeeMachine machine) {
        if (machine.getWater() <= num_coffee.water) {
            return "water";
        } else if (machine.getMilk() <= num_coffee.milk) {
            return "milk";
        } else if (machine.getBeans() <= num_coffee.beans) {
            return "beans";
        } else {
            return "cups";
        }
    }

    public static boolean checking_coffee(Coffee num_coffee, CoffeeMachine machine) {
        return machine.getWater() >= num_coffee.water &&
                machine.getBeans() >= num_coffee.beans &&
                machine.getCups() >= num_coffee.cups;
    }
    public static void doing_coffee(Coffee num_coffee, CoffeeMachine machine){
        machine.setWater(machine.getWater()- num_coffee.water);
        machine.setMilk(machine.getMilk()- num_coffee.milk);
        machine.setBeans(machine.getBeans()- num_coffee.beans);
        machine.setCups(machine.getCups()- num_coffee.cups);
        machine.setMoney(machine.getMoney()+ num_coffee.money);
    }
}
