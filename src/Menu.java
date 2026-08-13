import java.util.List;
import java.util.Scanner;

public class Menu {

    private DestinationManager manager = new DestinationManager();
    private Scanner scanner = new Scanner(System.in);

    private void printMenu() {
        System.out.println();
        System.out.println("--- Travel Budget ---");
        System.out.println("1. Add destination");
        System.out.println("2. Show all destinations");
        System.out.println("3. Show total cost");
        System.out.println("4. Show sorted by priority");
        System.out.println("5. Show within budget");
        System.out.println("6. Remove destination");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addDestination();
                    break;
                case "2":
                    showAll();
                    break;
                case "3":
                    showTotalCost();
                    break;
                case "4":
                    showByPriority();
                    break;
                case "5":
                    showWithinBudget();
                    break;
                case "6":
                    removeDestination();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private void addDestination() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Priority (1-5): ");
        int priority = Integer.parseInt(scanner.nextLine());

        Destination destination = new Destination(name, country, price, priority);
        manager.addDestination(destination);
        System.out.println("Destination added!");
    }

    private void showAll() {
        List<Destination> destinations = manager.getAllDestinations();

        if (destinations.isEmpty()) {
            System.out.println("No destinations yet.");
            return;
        }

        System.out.println("Your destinations:");
        for (int i = 0; i < destinations.size(); i++) {
            Destination d = destinations.get(i);
            System.out.println((i + 1) + ". " + d.getName() + " (" + d.getCountry() + ") - " + d.getPrice() + " kr, priority " + d.getPriority());

        }
    }

    private void showTotalCost() {
        double total = manager.getTotalCost();
        System.out.println("Total cost: " + total + " kr");
    }

    private void showByPriority() {
        List<Destination> destinations = manager.getSortedByPriority();

        if (destinations.isEmpty()) {
            System.out.println("No destinations yet.");
            return;
        }

        System.out.println("Your destinations:");
        for (int i = 0; i < destinations.size(); i++) {
            Destination d = destinations.get(i);
            System.out.println((i + 1) + ". " + d.getName() + " (" + d.getCountry() + ") - " + d.getPrice() + " kr, priority " + d.getPriority());

        }
    }

    private void showWithinBudget() {
        System.out.print("Enter your budget: ");
        double budget = Double.parseDouble(scanner.nextLine());

        List<Destination> destinations = manager.getWithinBudget(budget);

        if (destinations.isEmpty()) {
            System.out.println("Nothing within that budget.");
            return;
        }

        System.out.println("Destinations within " + budget + " kr:");
        for (int i = 0; i < destinations.size(); i++) {
            Destination d = destinations.get(i);
            System.out.println((i + 1) + ". " + d.getName() + " (" + d.getCountry() + ") - " + d.getPrice() + " kr, priority " + d.getPriority());
        }
    }

    private void removeDestination() {
        showAll();

        List<Destination> destinations = manager.getAllDestinations();
        if (destinations.isEmpty()) {
            return;
        }

        System.out.print("Enter the number to remove: ");
        int number = Integer.parseInt(scanner.nextLine());

        manager.removeDestination(number - 1);
        System.out.println("Destination removed");
    }

}
