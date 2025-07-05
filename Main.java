import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.of(2025, 8, 1), 0.2);
        ExpirableShippableProduct biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, LocalDate.of(2025, 9, 1), 0.7);
        ShippableProduct tv = new ShippableProduct("TV", 500, 2, 3.0);
        Product scratchCard = new Product("Scratch Card", 50, 10);

        Customer customer = new Customer("Ahmed", 2000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        checkout(customer, cart);
    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double subtotal = cart.getSubtotal();
        double shippingFeePerKg = 30;
        double totalWeight = cart.getShippableItems().stream().mapToDouble(Shippable::getWeight).sum();
        double shipping = shippingFeePerKg * totalWeight;
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            System.out.println("Customer balance is insufficient");
            return;
        }

        List<Shippable> toShip = cart.getShippableItems();
        ShippingService.send(toShip);

        cart.reduceStock();
        customer.deduct(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + " " + item.getTotalPrice());
        }
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shipping);
        System.out.printf("Amount %.0f%n", total);
        System.out.printf("Customer balance after payment: %.0f%n", customer.getBalance());
    }
}