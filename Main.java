import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item[] items = {
            new PercentDiscountItem("Doll", 12000.00, 3, 5),
            new NoDiscountItem("Toy Car", 8000.00),
            new FlatDiscountItem("Puzzle", 6000.00, 4, 1000.00),
            new PercentDiscountItem("Ball", 5000.00, 6, 10)
        };

        int[] quantities = new int[items.length];

        try (Scanner scanner = new Scanner(System.in)) {
            //Display Price List
            System.out.println("FUNTIME TOY SHOP");
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %-10s UGX %.2f%n", (i + 1), items[i].getName(), items[i].getPrice());
            }

            // Prompt user to enter quantities
            System.out.println("\n ENTER QUANTITIES");
            for (int i = 0; i < items.length; i++) {
                int qty = -1;
                while (qty < 0) {
                    System.out.print("Enter quantity for " + items[i].getName() + ": ");
                    if (scanner.hasNextInt()) {
                        qty = scanner.nextInt();
                        if (qty < 0) {
                            System.out.println("Quantity cannot be negative. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a positive integer.");
                        scanner.next();
                    }
                }
                quantities[i] = qty;
            }

            //Print receipt with discount notes
            double grandTotal = 0.0;
            System.out.println("\n RECEIPT ");
            for (int i = 0; i < items.length; i++) {
                double lineTotal = items[i].calculateTotal(quantities[i]);
                String note = items[i].getDiscountNote(quantities[i]);
                System.out.printf("%-8s x%d = UGX %10.2f %s%n", items[i].getName(), quantities[i], lineTotal, note);
                grandTotal += lineTotal;
            }

            System.out.println("-------------------------------------------");
            System.out.printf("TOTAL    = UGX %.2f%n", grandTotal);
        }
    }
}
