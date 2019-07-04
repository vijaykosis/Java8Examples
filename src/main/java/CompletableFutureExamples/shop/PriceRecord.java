package CompletableFutureExamples.shop;


import java.math.BigDecimal;

public class PriceRecord {
    private Discount.Code code;
    private BigDecimal price;

    public PriceRecord(Discount.Code code, BigDecimal price) {
        this.code = code;
        this.price = price;
    }

    public Discount.Code getCode() {
        return code;
    }

    public void setCode(Discount.Code code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}