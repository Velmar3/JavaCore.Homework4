package Homework4;

// Исключение, выбрасываемое при ошибке с товаром
public class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}