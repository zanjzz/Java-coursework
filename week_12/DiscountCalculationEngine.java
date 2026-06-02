package week_12;

public class DiscountCalculationEngine {

    public static void main(String[] args) {

        // Create discount types
        Discount fixed = new FixedDiscount(200);
        Discount percentage = new PercentageDiscount(20);
        Discount seasonal = new SeasonalDiscount(30);

        double amount = 2000;

        DiscountProcessor discountProcessor = new DiscountProcessor();

        // Show original price
        System.out.println("Price: " + amount + "\n");

        // Apply individual discounts
        System.out.println("Price with Fixed Discount (200): " + fixed.apply(amount));
        System.out.println("Price with Percentage Discount (20%): " + percentage.apply(amount));
        System.out.println("Price with Seasonal Discount (30%): " + seasonal.apply(amount));

        // Apply all discounts together
        System.out.println("Final Price: " +
                discountProcessor.calculateFinalPrice(amount, fixed, percentage, seasonal));
    }
}

// Handles applying multiple discounts in sequence
class DiscountProcessor {

    public double calculateFinalPrice(double amount, Discount... discounts) {
        double result = amount;

        for (Discount d : discounts) {
            result = d.apply(result);
        }

        return result;
    }
}

// Base contract for all discount types
interface Discount {
    double apply(double amount);
}

// Percentage-based discount
class PercentageDiscount implements Discount {

    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double apply(double amount) {
        return amount - (amount * percent / 100);
    }
}

// Fixed amount discount
class FixedDiscount implements Discount {

    private double discount;

    public FixedDiscount(double discount) {
        this.discount = discount;
    }

    public double apply(double amount) {
        return amount - discount;
    }
}

// Seasonal percentage discount
class SeasonalDiscount implements Discount {

    private double percent;

    public SeasonalDiscount(double percent) {
        this.percent = percent;
    }

    public double apply(double amount) {
        return amount - (amount * percent / 100);
    }
}