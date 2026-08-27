import java.util.Scanner;

public class Funtime_toy_shop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Arrays storing item names and prices
        String[] itemNames = {"Doll", "Toy Car", "Puzzle", "Ball"};
        double[] itemPrices = {12000.00, 8000.00, 6000.00, 5000.00};
        int[] quantities = new int[itemNames.length];

        // 2. Display Price List using a loop
        System.out.println("FUNTIME TOY SHOP");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.printf("%d. %-10s UGX %.2f%n", (i + 1), itemNames[i], itemPrices[i]);
        }

        // Prompt user to enter quantities for each item
        System.out.println("\n ENTER QUANTITIES");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.print("Enter quantity for " + itemNames[i] + ": ");
            quantities[i] = scanner.nextInt();
        }

        // Arrays to hold output results for receipt generation
        double[] subtotals = new double[itemNames.length];
        String[] discountNotes = new String[itemNames.length];
        double grandTotal = 0.0;

        // 3 & 4. Calculate subtotals with discounts and sum grand total
        for (int i = 0; i < itemNames.length; i++) {
            subtotals[i] = calculateSubtotal(i, itemPrices[i], quantities[i]);
            discountNotes[i] = getDiscountNote(i, quantities[i]);
            grandTotal += subtotals[i];
        }

        // 5 & 6. Print itemized receipt using Method 2
        printReceipt(itemNames, quantities, subtotals, discountNotes, grandTotal);

        scanner.close();
    }

    /**
     * Method 1: Calculates the subtotal for an item applying specific discount rules
     */
    public static double calculateSubtotal(int itemIndex, double price, int quantity) {
        double total = price * quantity;

        switch (itemIndex) {
            case 0: // Doll: buy 3 or more, gets 5% off
                if (quantity >= 3) {
                    total -= total * 0.05;
                }
                break;
            case 1: // Toy Car: no deal
                break;
            case 2: // Puzzle: buy 4 or more, UGX 1,000 comes straight off
                if (quantity >= 4) {
                    total -= 1000.00;
                }
                break;
            case 3: // Ball: buy 6 or more, gets 10% off
                if (quantity >= 6) {
                    total -= total * 0.10;
                }
                break;
        }
        return total;
    }

    /**
     * Helper method to supply descriptions for the receipt output lines
     */
    public static String getDiscountNote(int itemIndex, int quantity) {
        switch (itemIndex) {
            case 0:
                return quantity >= 3 ? "(5% discount)" : "";
            case 2:
                return quantity >= 4 ? "(UGX 1,000 discount)" : "";
            case 3:
                return quantity >= 6 ? "(10% discount)" : "";
            default:
                return "";
        }
    }
    
    /**
     * Method 2: Prints the formatted receipt
     */
    public static void printReceipt(String[] names, int[] quantities, double[] subtotals, String[] notes, double grandTotal) {
        System.out.println("\n RECEIPT ");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-8s x%d = UGX %10.2f %s%n", names[i], quantities[i], subtotals[i], notes[i]);
        }
        System.out.println("----------------------------------------");

        System.out.printf("TOTAL    = UGX %.2f%n", grandTotal);
    }
}