package Homework4;

// Исключение, выбрасываемое при превышении скидки для товара категории PREMIUM
public class TooMuchSaleException extends Exception {
    public TooMuchSaleException(String message) {
        super(message);
    }
}
