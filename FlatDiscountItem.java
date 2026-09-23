public class FlatDiscountItem extends Item {
    private final int threshold;
    private final double flatAmount;

    public FlatDiscountItem(String name, double price, int threshold, double flatAmount) {
        super(name, price);
        this.threshold = threshold;
        this.flatAmount = flatAmount;
    }

    @Override
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);
        if (quantity >= threshold) {
            subtotal = Math.max(0, subtotal - flatAmount);
        }
        return subtotal;
    }

    @Override
    public String getDiscountNote(int quantity) {
        if (quantity >= threshold) {
            return String.format("(UGX %,.0f discount)", flatAmount);
        }
        return "";
    }
}
