import java.util.List;

public class ShippingService {
    public static void send(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.println("1x " + item.getName() + " " + item.getWeight() * 1000 + "g");
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight: %.1fkg%n%n", totalWeight);
    }
}