package College;

import java.util.*;

class Card {
    String name;
    double balance;
    
    Card(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "Card: " + name + ", Balance: " + balance;
    }
}

public class CardCollectionApp {
    private static final int CARD_LIMIT = 5;
    
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Card  2. Find Card  3. Display All  4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    if (cards.size() >= CARD_LIMIT) {
                        System.out.println("Card limit reached! Cannot add more.");
                    } else {
                        System.out.print("Enter card name: ");
                        String cardName = scanner.nextLine();
                        System.out.print("Enter balance: ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine();
                        cards.add(new Card(cardName, balance));
                        System.out.println("Card added!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter card name to find: ");
                    String searchCard = scanner.nextLine();
                    boolean found = false;
                    for (Card card : cards) {
                        if (card.name.equalsIgnoreCase(searchCard)) {
                            System.out.println("Card found: " + card);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Card not found.");
                    }
                }
                case 3 -> {
                    if (cards.isEmpty()) {
                        System.out.println("No cards available.");
                    } else {
                        for (Card card : cards) {
                            System.out.println(card);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}


