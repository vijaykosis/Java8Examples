package CompletableFutureExamples.shop;

import java.math.BigDecimal;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static PriceRecord applyDiscount(BigDecimal price) {
        Code discountCode = Code.values()[Randomizer.random(Code.values().length)];
        BigDecimal finalPrice = Discount.apply(price, discountCode);
        return new PriceRecord(discountCode, finalPrice);
    }

    private static BigDecimal apply(BigDecimal price, Code code) {
        SlowNetwork.delay(1);
        return BigDecimal.valueOf(price.doubleValue() * (100 - code.percentage) / 100);
    }

}