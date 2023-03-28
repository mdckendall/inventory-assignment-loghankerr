import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    String name;
    String serial;
    int price;

    public Inventory(String name, String serial, int price) {
        this.name = name;
        this.serial = serial;
        this.price = price;
    }

    public String toString() {
        return name + "," + serial + "," + price;
    }
}

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var catalog = new ArrayList<Inventory>();

        while (true) {
            System.out.println("""
          Press 1 to add an item.
          Press 2 to delete an item.
          Press 3 to update an item.
          Press 4 to show all the items.
          Press 5 to quit the program.""");

            var option = input.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.println("Enter the name:");
                    var name = input.nextLine();

                    System.out.println("Enter the serial number:");
                    var serial = input.nextLine();

                    System.out.println("Enter the value in dollars (whole number):");
                    var price = input.nextInt();
                    input.nextLine();

                    catalog.add(new Inventory(name, serial, price));
                    System.out.println("Item added.");
                }

                case "2" -> {
                    System.out.println("Enter the serial number of the item to delete:");
                    var delSerial = input.nextLine();

                    var deleted = catalog.removeIf(item -> item.serial.equals(delSerial));
                    if (deleted) {
                        System.out.println("Item deleted.");
                    } else {
                        System.out.println("Item not found.");
                    }
                }

                case "3" -> {
                    System.out.println("Enter the serial number of the item to update:");
                    var serial = input.nextLine();

                    for (var item : catalog) {
                        if (item.serial.equals(serial)) {
                            System.out.println("Enter the new name:");
                            var name = input.nextLine();
                            item.name = name;

                            System.out.println("Enter the new value in dollars (whole number):");
                            var price = input.nextInt();
                            input.nextLine();
                            item.price = price;
                            
                            break;
                        }
                    }
                }

                case "4" -> {
                    if (catalog.isEmpty()) {
                        System.out.println("No items found.");
                    } else {
                        for (var item : catalog) {
                            System.out.println(item);
                        }
                    }
                }

                case "5" -> {
                    return;
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
