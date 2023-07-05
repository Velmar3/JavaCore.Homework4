package Homework4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public Main() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Добавление покупателя в магазин
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Добавление товара в магазин
    public void addProduct(Product product) {
        products.add(product);
    }

    // Создание заказа и добавление его в магазин
    public void makePurchase(Customer customer, Product product, int quantity) throws CustomerException, ProductException, AmountException, TooMuchSaleException {
        if (!customers.contains(customer)) {
            throw new CustomerException("Invalid customer: " + customer.getFullName());
        }

        if (!products.contains(product)) {
            throw new ProductException("Invalid product: " + product.getName());
        }

        if (quantity <= 0 || quantity > 100) {
            throw new AmountException("Invalid quantity: " + quantity);
        }

        if (product.getCategory() == Category.PREMIUM && product.getDiscount().getPercentage() > 0.15) {
            throw new TooMuchSaleException("Too much sale for premium product: " + product.getName());
        }

        Order order = new Order(customer, product, quantity);
        orders.add(order);
    }

    // Вывод информации о каждом заказе
    public void printOrders() {
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            Product product = order.getProduct();
            int quantity = order.getQuantity();
            double totalPrice = order.getTotalPrice();
            Discount discount = product.getDiscount();

            System.out.println("Order Information:");
            System.out.println("Customer: " + customer.getFullName());
            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: $" + totalPrice);
            System.out.println("Discount: " + discount.getPercentage() * 100 + "%");
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Main shop = new Main();

        // Добавление покупателей
        Customer customer1 = new Customer("Edward Ball", 20, "830183520", Gender.MALE);
        Customer customer2 = new Customer("Magi Walker", 35, "830983520", Gender.FEMALE);
        shop.addCustomer(customer1);
        shop.addCustomer(customer2);

        // Добавление товаров
        Product product1 = new Product("Item 1", 10.0, Category.STANDARD);
        Product product2 = new Product("Item 2", 20.0, Category.PREMIUM);
        Product product3 = new Product("Item 3", 15.0, Category.STANDARD);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        try {
            // Совершение покупок
            shop.makePurchase(customer1, product1, 2);
            shop.makePurchase(customer2, product2, 1);
            shop.makePurchase(customer1, product3, 3);
        } catch (CustomerException | ProductException | AmountException | TooMuchSaleException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Вывод информации о заказах
        shop.printOrders();
    }
}