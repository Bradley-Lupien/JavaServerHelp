import java.util.ArrayList;
import java.util.Scanner;

public class Order {


    private String name;
    private String[] pizzaSizes = new String[] {"Small", "Medium", "Large"};
    private int pizzaSize;
    private String[] beverages = new String[] {"Coke", "Diet Coke", "Iced Tea"};
    private int beverage;
    private ArrayList<String> selectedToppings;
    private String[] desserts = new String[] {"Cookie", "Cake", "Ice Cream"};
    private int dessert;


    private int price;

    public Order(String name, int pizzaSize, int beverage, ArrayList<String> selectedToppings, int dessert, int price) {
        this.name = name;
        this.pizzaSize = pizzaSize;
        this.beverage = beverage;
        this.dessert = dessert;
        this.selectedToppings = selectedToppings;
        this.price = price;
    }

    public static Order getOrder() {
        ArrayList<String> toppings = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scan.nextLine();
        System.out.println("Welcome " + name + ", please select your pizza size. \r\n" +
                "Your options are: \r\n" +
                "1. Small\r\n" +
                "2. Medium\r\n" +
                "3. Large\r\n" +
                "Please enter the number that corresponds with the desired size.");
        int size = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter your desired beverage.\r\n" +
                "Your options are:\r\n" +
                "1. Coke\r\n" +
                "2. Diet Coke\r\n" +
                "3. Iced Tea\r\n" +
                "Please enter the number that corresponds with the desired beverage.");
        int beverage = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter your desired toppings. Type \"done\" when you're finished. ");
        String topping = scan.nextLine();
        if(!topping.equalsIgnoreCase("done")) {
            toppings.add(topping);
            while(!topping.equalsIgnoreCase("done")) {
                topping = scan.nextLine();
                toppings.add(topping);
            }
        }
        System.out.println("Please enter your desired dessert.\r\n" +
                "Your options are:\r\n" +
                "1. Cookie\r\n" +
                "2. Cake\r\n" +
                "3. Ice Cream\r\n" +
                "Please enter the number that corresponds with the desired dessert.");
        int dessert = scan.nextInt();
        scan.nextLine();
        toppings.remove(toppings.size() - 1); //remove "done" from toppings list
        return new Order(name, size, beverage, toppings, dessert, 12);
    }

    private void calculatePrice(Order order) {
        order.setPrice(12 + (order.pizzaSize + 15) + (order.selectedToppings.size() * 2));
        //12 is default price of beverage + dessert
    }

    public void showBill(Order order) {
        System.out.println("Thank you " + order.name + " for ordering today. Here is your bill: \r\n" +
                "Pizza size: " + order.getPizzaSizes()[order.getPizzaSize() - 1] + "\r\n" +
                "Beverage: " + order.getBeverages()[order.getBeverage() - 1] + "\r\n" +
                 order.getSelectedToppings().size() + " Toppings: ");
        for(String topping : order.getSelectedToppings()) {
            System.out.println(topping + "\r\n");
        }
        System.out.println("Dessert: " + order.getDesserts()[order.getDessert() - 1] + "\r\n");
        calculatePrice(order);
        System.out.println("Total Price: " + order.getPrice());
        System.out.println("Thank you " + order.getName() + " for ordering with us today!");
    }

    public String getName() {
        return name;
    }

    public String[] getPizzaSizes() {
        return pizzaSizes;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public String[] getBeverages() {
        return beverages;
    }

    public int getBeverage() {
        return beverage;
    }

    public ArrayList<String> getSelectedToppings() {
        return selectedToppings;
    }

    public int getDessert() {
        return dessert;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getDesserts() {
        return desserts;
    }

}

