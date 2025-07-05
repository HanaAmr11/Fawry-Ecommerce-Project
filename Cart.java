import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }

        if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) {
            System.out.println(product.getName() + " is expired");
            return;
        }

        items.add(new CartItem(product, quantity));
        System.out.println(quantity + "x " + product.getName());
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            if (item.product instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippables.add((Shippable) item.product);
                }
            }
        }
        return shippables;
    }

    public void reduceStock() {
        for (CartItem item : items) {
            item.product.reduceQuantity(item.quantity);
        }
    }
}