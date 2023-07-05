package Homework4;

// Перечисление размеров скидок
public enum Discount {
    NONE(0),
    FIVE(0.05),
    TEN(0.1),
    FIFTEEN(0.15),
    TWENTY(0.2);

    private final double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
