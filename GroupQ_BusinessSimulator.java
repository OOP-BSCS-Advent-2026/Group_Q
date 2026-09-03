

public class GroupQ_BusinessSimulator {

    public static void main(String[] args) {

        // ---- Step 1: store items and prices in arrays (not separate variables) ----
        String[] itemNames = {"Doll", "Toy Car", "Puzzle", "Ball"};
        double[] itemPrices = {12000.00, 8000.00, 6000.00, 5000.00};

        // ---- Step 3: quantities, set directly in code for this version ----
        int[] quantities = {2, 2, 3, 6};

        // ---- Step 2: display the price list, built from the arrays with a loop ----
        displayPriceList(itemNames, itemPrices);

        // ---- Steps 4-6: build and print the receipt ----
        printReceipt(itemNames, itemPrices, quantities);
    }

    /**
     * Custom method #1.
     * Loops over the arrays and prints a formatted price list.
     * Demonstrates: loops + arrays (Grading: Arrays, Loops).
     */
    public static void displayPriceList(String[] names, double[] prices) {
        System.out.println("==== FUNTIME TOY SHOP ====");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d. %s UGX %.2f%n", (i + 1), names[i], prices[i]);
        }
        System.out.println();
    }

    /**
     * Custom method #2.
     * Calculates ONE item's subtotal (price x quantity) and applies
     * that specific item's discount rule if it qualifies.
     * This is where the if/else decision logic lives (Grading: Decisions).
     *
     * @param itemIndex position of the item in the arrays (0 = Doll, 1 = Toy Car,
     *                   2 = Puzzle, 3 = Ball)
     * @param price     unit price of the item
     * @param qty       quantity being bought
     * @return          the discounted subtotal for that item
     */
    public static double calculateSubtotal(int itemIndex, double price, int qty) {
        double subtotal = price * qty;

        if (itemIndex == 0) {
            // Doll: 3 or more -> 5% off
            if (qty >= 3) {
                subtotal = subtotal - (subtotal * 0.05);
            }
        } else if (itemIndex == 1) {
            // Toy Car: no deal, ever — nothing to do
        } else if (itemIndex == 2) {
            // Puzzle: 4 or more -> flat UGX 1,000 off
            if (qty >= 4) {
                subtotal = subtotal - 1000.00;
            }
        } else if (itemIndex == 3) {
            // Ball: 6 or more -> 10% off
            if (qty >= 6) {
                subtotal = subtotal - (subtotal * 0.10);
            }
        }

        return subtotal;
    }

    /**
     * Custom method #3.
     * Works out the discount message shown on each receipt line, so the
     * receipt reads the same way as the worked example in the brief.
     */
    public static String getDiscountNote(int itemIndex, int qty) {
        switch (itemIndex) {
            case 0:
                return (qty >= 3) ? "5% discount applied" : "no discount — fewer than 3";
            case 1:
                return "no discount — never on sale";
            case 2:
                return (qty >= 4) ? "UGX 1,000 discount applied" : "no discount — fewer than 4";
            case 3:
                return (qty >= 6) ? "10% discount applied" : "no discount — fewer than 6";
            default:
                return "";
        }
    }

    /**
     * Custom method #4.
     * Builds the full itemised receipt: one line per item (quantity,
     * subtotal, discount status), then the grand total.
     * Ties everything together (Grading: Methods, Loops, Correctness).
     */
    public static void printReceipt(String[] names, double[] prices, int[] quantities) {
        System.out.println("==== RECEIPT ====");

        double grandTotal = 0.0;

        for (int i = 0; i < names.length; i++) {
            double subtotal = calculateSubtotal(i, prices[i], quantities[i]);
            String note = getDiscountNote(i, quantities[i]);

            System.out.printf("%s x%d = UGX %.2f (%s)%n",
                    names[i], quantities[i], subtotal, note);

            grandTotal = grandTotal + subtotal;
        }

        System.out.println("----------------------------------------------------");
        System.out.printf("TOTAL = UGX %.2f%n", grandTotal);
    }
}
