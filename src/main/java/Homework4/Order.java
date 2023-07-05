package Homework4;

// Класс представляющий заказ
public class Order {
    private Customer customer;
    private Product product;
    private int quantity;
    private double totalPrice;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = calculateTotalPrice();
    }

    // Геттеры и сеттеры

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Вычисление общей стоимости заказа с учетом скидки
    private double calculateTotalPrice() {
        double discountedPrice = product.getPrice() - (product.getPrice() * product.getDiscount().getPercentage());
        return discountedPrice * quantity;
    }
}
